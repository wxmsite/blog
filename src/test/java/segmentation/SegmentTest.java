package segmentation;

import com.huaban.analysis.jieba.JiebaSegmenter;
import org.junit.Test;

/**
 * author bebetter159
 * date  2018/5/31 11:05
 */
public class SegmentTest {
    @Test
    //有些句子分词还不是十分准确，比如研二其实应该被分为研和研二
    public void segTest(){
        JiebaSegmenter jiebaSegmenter=new JiebaSegmenter();
        System.out.println(jiebaSegmenter.process("研二学生的迷茫",JiebaSegmenter.SegMode.INDEX));
    }
}
