package index;

import com.alibaba.druid.pool.DruidDataSource;
import com.blog.model.BlogDetail;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * author bebetter159
 * date  2018/5/31 22:30
 */
public class createIndex {

    private static DruidDataSource dataSource;
    private static Logger logger=LoggerFactory.getLogger(createIndex.class);
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        dataSource = (DruidDataSource) context.getBean("dataSource");
        File indxeFile = new File("E:/blog索引");
        //创建Directory对象
        Directory directory = FSDirectory.open(indxeFile.toPath());
        Analyzer analyzer = new IKAnalyzer(false);
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        //创建IndexWriter
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        //从数据库中读取出所有的新闻记录以便进行索引的创建
        try {

            Connection conn = dataSource.getConnection();
            Statement stmt = null;
            ResultSet rs = null;
            String sql = "select * from blog";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            List<BlogDetail> list = new ArrayList<BlogDetail>();
            while (rs.next()) {
                BlogDetail blogDetail = new BlogDetail();
                blogDetail.setBlogUrl(rs.getString("blog_url"));
                blogDetail.setTitle(rs.getString("title"));
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                sdf.setLenient(false);

                blogDetail.setDate(rs.getString("date"));
                blogDetail.setCommentNum(rs.getInt("comment_num"));
                blogDetail.setReadNum(rs.getInt("read_num"));

                list.add(blogDetail);
            }

            for (int i = 0; i < list.size(); i++) {
                //建立一个lucene文档
                Document doc = new Document();
                //得到url
                String blogID = list.get(i).getBlogUrl();
                //得到title
                String title = list.get(i).getTitle();
                String publishDate =list.get(i).getDate();
                int commentNum = list.get(i).getCommentNum();
                int readNum = list.get(i).getReadNum();

                doc.add(new Field("title", title, TextField.TYPE_STORED));

                doc.add(new Field("blogUrl", String.valueOf(blogID), StringField.TYPE_STORED));

                doc.add(new Field("date", publishDate, StringField.TYPE_STORED));
                //添加主键至文档，不分词，不高亮。
                doc.add(new Field("commentNum", String.valueOf(commentNum), StringField.TYPE_STORED));
                doc.add(new Field("readNum", String.valueOf(readNum), StringField.TYPE_STORED));
                indexWriter.addDocument(doc);
            }
            indexWriter.close();
            dataSource.getConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        directory.close();

    }

}