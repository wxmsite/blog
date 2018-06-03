package segmentation;

import com.blog.Mapper.BlogMapper;
import com.blog.Mapper.WordMapper;
import com.blog.model.BlogDetail;
import com.blog.service.BlogService;
import com.blog.service.WordService;
import com.blog.service.impl.BlogServiceImpl;
import com.blog.service.impl.WordServiceImpl;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.*;

/**
 * author bebetter159
 * date  2018/5/30 10:00
 */

/**
 * 用来创建停用词表的类
 * 流程为首先读取数据库的所有数据，并且进行分词，然后将分出来的单词放入HashMap中
 * 然后判断是否在stopwords.txt中出现，如果出现则输出（程序需要稍作修改，挺简单），然后自己选择性加入mystopwords.txt中
 * 另外可以输出所有分词后的单词自己选择性加入mystopwords中
 * 最后感觉Jieba分词其实不是很准确，后期会使用更加智能的API或者尝试自己写一个分词
 */
public class Segmentation {

    private static ApplicationContext ctx = null;
    private static BlogService blogService;
    private static BlogMapper blogMapper;
    private static WordService wordService;
    private static WordMapper wordMapper;


    static {
        ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        blogMapper = (BlogMapper) ctx.getBean("blogMapper");
        blogService = new BlogServiceImpl(blogMapper);
        wordMapper = (WordMapper) ctx.getBean("wordMapper");
        wordService = new WordServiceImpl(wordMapper);
    }

    @Test
    public void testDemo() {
        //存储自己的停用词
        Map<String, Boolean> map = readFile();
        //存储已有停用词,可以用来判断数据中含有哪些可以被停用的单词，然后选择性的加入自己的停用词表
        Map<String, Boolean> map2 = readFile2();
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<BlogDetail> list = blogService.getBlogTitle();
        Map<String, Integer> map1 = new HashMap<>();

        for (BlogDetail blog : list) {
            for (SegToken segToken : segmenter.process(blog.getTitle(), JiebaSegmenter.SegMode.INDEX)) {
                if (!segToken.word.equals(" ") && !map.containsKey(segToken.word)) {
                    if (!map1.containsKey(segToken.word)) {
                        map1.put(segToken.word, 1);
                    } else
                        map1.put(segToken.word, map1.get(segToken.word) + 1);
                }
            }
        }
        List<Map.Entry<String, Integer>> list2 = new ArrayList<>(map1.entrySet());
        Collections.sort(list2, new Comparator<>() {
            //升序排序
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

        });

        for (Map.Entry<String, Integer> mapping : list2) {
            if ( !map.containsKey(mapping.getKey())) {
                if(mapping.getValue()>3)
                    System.out.println(mapping.getKey()+mapping.getValue());
                //System.out.println(mapping.getKey());
                //System.out.println(mapping.getKey() + "   " + mapping.getValue());
            }
        }
    }


    public Map<String, Boolean> readFile() {
        Map<String, Boolean> map = new HashMap<>();
        String filePath = Segmentation.class.getResource("/").getPath() + "mystopwords.txt";
        File file = new File(filePath);
        if (file.exists()) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader br = new BufferedReader(fileReader);
                String lineContent = null;
                while ((lineContent = br.readLine()) != null) {
                    map.put(lineContent, true);
                }
                br.close();
                fileReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("no this file");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("io exception");
                e.printStackTrace();
            }
        }
        return map;
    }

    public Map<String, Boolean> readFile2() {
        Map<String, Boolean> map = new HashMap<>();
        String filePath = Segmentation.class.getResource("/").getPath() + "stopwords.txt";
        File file = new File(filePath);
        if (file.exists()) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader br = new BufferedReader(fileReader);
                String lineContent = null;
                while ((lineContent = br.readLine()) != null) {
                    map.put(lineContent, true);
                }
                br.close();
                fileReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("no this file");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("io exception");
                e.printStackTrace();
            }
        }
        return map;
    }


}
