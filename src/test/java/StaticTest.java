import org.junit.Test;

/**
 * author bebetter159
 * date  2018/5/15 21:16
 */
public class StaticTest {
    private static int test1=0;
    private int test2=0;

    /**
     * 单独理解没有问题，但是在一堆代码里面挺难发现，花了点时间才发现是static的问题
     * 开始还以为是多线程下指令重排的问题，但是后来想了想不对，ExpertBlogSpider的test不存在该问题
     */
    @Test
    public void test(){
        test1=1;
        test2=1;
        System.out.println(test1);
        System.out.println(new StaticTest().test2);
    }
}
