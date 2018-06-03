package search;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

/**
 * author bebetter159
 * date  2018/6/1 9:34
 */
public class searcher {
    @Test
    public  void searchTest() throws IOException {
        search(1);
    }

    public void search(int currentPage) throws IOException {
        TopDocs hits = null;
        ScoreDoc[] scores = null;
        int pageSize = 10;
        File indxeFile = new File("E:/blog索引");
        //创建Directory对象
        Directory directory = FSDirectory.open(indxeFile.toPath());
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher isearcher = new IndexSearcher(ireader);

        String[] fields = {"title"};
        Analyzer analyzer = new IKAnalyzer(true);
        MultiFieldQueryParser mparser = new MultiFieldQueryParser(fields, analyzer);
        Query query = null;
        try {
            query = mparser.parse("1");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (currentPage == 1) {
            hits = isearcher.search(query, pageSize);

        } else if (currentPage > 1) {
            int start = (currentPage - 1) * pageSize;
            hits = isearcher.search(query, start);
            ScoreDoc prescore = hits.scoreDocs[start - 1];
            hits = isearcher.searchAfter(prescore, query, pageSize);

        }
        if (hits != null) {
            System.out.println(hits.totalHits);
            scores = hits.scoreDocs;
            for (ScoreDoc scoreDoc : scores) {
                Document doc = isearcher.doc(scoreDoc.doc);
                System.out.println(doc.get("title"));
            }
        }
        ireader.close();
        directory.close();
    }


}
