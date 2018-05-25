package com.blog.service.impl;

import com.blog.Mapper.SearchMapper;
import com.blog.model.Blog;
import com.blog.service.SearchService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * author bebetter159
 * date  2018/5/18 21:54
 */
@Service
public class SearchServiceImpl implements SearchService {
    private long resultCount = 0;
    private final int rows = 20;
    private Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);
    @Autowired
    SearchMapper searchMapper;
    private static final String SOLR_URL = "http://127.0.0.1:8983/solr/blog";
    private HttpSolrClient client = new HttpSolrClient.Builder(SOLR_URL).build();
    private static final String BLOG_URL_FIELD = "blog_url";
    private static final String BLOG_TITLE_FIELD = "blog_title";
    private static final String BLOG_READ_FIELD = "blog_read";
    private static final String BLOG_COMMENT_FIELD = "blog_comment";

    @Override
    public void searchByCategories(String category) {
    }

    @Override
    public List<Blog> searchBlog(String keyword, int pn) {
        int start = pn - 1;
        SolrQuery query = new SolrQuery(keyword);
        query.setHighlight(true);
        //设置高亮
        //query.addHighlightField("blog_title");
        query.setStart(start * rows);
        query.setRows(rows);
        query.set("hl.fl", BLOG_TITLE_FIELD);

        query.setHighlightSimplePre("");
        query.setHighlightSimplePost("");
        QueryResponse response = null;
        try {
            response = client.query(query);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Blog> blogList = new ArrayList<>();
        resultCount = response.getResults().getNumFound();
        System.out.println(resultCount);
        for (SolrDocument solrDocument : response.getResults()) {
            Blog blog = new Blog();
            blog.setBlogUrl(solrDocument.get(BLOG_URL_FIELD).toString());
            blog.setTitle(solrDocument.get(BLOG_TITLE_FIELD).toString());
            blog.setReadNum(Integer.parseInt(solrDocument.get(BLOG_READ_FIELD).toString()));
            blog.setCommentNum(Integer.parseInt(solrDocument.get(BLOG_COMMENT_FIELD).toString()));
            blogList.add(blog);
        }
        return blogList;
    }

    @Override
    public long getCount() {
        return resultCount;
    }

    @Override
    public boolean indexBlog(String blog_url, String title) {
        SolrInputDocument doc = new SolrInputDocument();
        doc.setField("id", blog_url);
        doc.setField(BLOG_TITLE_FIELD, title);
        UpdateResponse response = null;
        try {
            response = client.add(doc, 1000);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response != null && response.getStatus() == 0;
    }


}
