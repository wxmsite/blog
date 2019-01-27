package com.blog.service.impl;

import com.blog.Mapper.SearchMapper;
import com.blog.model.BlogDetail;
import com.blog.service.SearchService;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
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
    private final int pageSize = 10;
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
    public List<BlogDetail> searchBlogSolr(String keyword, int pn) {
        int start = pn - 1;
        SolrQuery query = new SolrQuery(keyword);
        query.setHighlight(true);
        //设置高亮
        //query.addHighlightField("blog_title");
        query.setStart(start * pageSize);
        query.setRows(pageSize);
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
        List<BlogDetail> blogList = new ArrayList<>();
        resultCount = response.getResults().getNumFound();

        for (SolrDocument solrDocument : response.getResults()) {
            BlogDetail blog = new BlogDetail();
            blog.setTitle(solrDocument.get(BLOG_TITLE_FIELD).toString());
            blog.setReadNum(Integer.parseInt(solrDocument.get(BLOG_READ_FIELD).toString()));
            blog.setCommentNum(Integer.parseInt(solrDocument.get(BLOG_COMMENT_FIELD).toString()));
            blogList.add(blog);
        }
        return blogList;
    }

    @Override
    public List<BlogDetail> searchBlogLucene(String keyword, int pn) {

        List<BlogDetail> blogDetails = new ArrayList<>();
        TopDocs hits = null;
        ScoreDoc[] scores = null;
        File indxeFile = new File("E:/blog索引");
        //创建Directory对象
        Directory directory = null;
        try {
            directory = FSDirectory.open(indxeFile.toPath());
            DirectoryReader ireader = null;
            ireader = DirectoryReader.open(directory);
            IndexSearcher isearcher = new IndexSearcher(ireader);
            String[] fields = {"title"};
            Analyzer analyzer = new IKAnalyzer(true);
            MultiFieldQueryParser mparser = new MultiFieldQueryParser(fields, analyzer);
            System.out.println(keyword);
            Query query = mparser.parse(keyword);
            if (pn == 1) {
                hits = isearcher.search(query, pageSize);
            } else if (pn > 1) {
                int start = (pn - 1) * pageSize;
                hits = isearcher.search(query, start);
                ScoreDoc prescore = hits.scoreDocs[start - 1];
                hits = isearcher.searchAfter(prescore, query, pageSize);
            }
            if (hits != null) {
                resultCount = hits.totalHits;
                scores = hits.scoreDocs;
                for (ScoreDoc scoreDoc : scores) {
                    Document doc = isearcher.doc(scoreDoc.doc);

                    BlogDetail blogDetail = new BlogDetail();
                    blogDetail.setTitle(doc.get("title"));
                    blogDetail.setDate(doc.get("date"));
                    blogDetail.setBlogUrl(doc.get("blogUrl"));
                    blogDetail.setReadNum(Integer.parseInt(doc.get("readNum")));
                    blogDetail.setCommentNum(Integer.parseInt(doc.get("commentNum")));
                    blogDetails.add(blogDetail);
                }
            }

            ireader.close();
            directory.close();
        } catch (IOException e) {
            logger.error("lucene读取索引失败");
        } catch (ParseException e) {
            logger.error("lucene转换失败");
        }
        return blogDetails;
    }

    @Override
    public long getCount() {
        return resultCount;
    }


}
