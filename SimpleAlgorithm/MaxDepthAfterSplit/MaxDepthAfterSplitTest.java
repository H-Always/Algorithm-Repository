import java.util.Arrays;

/**
 * @ClassName: MaxDepthAfterSplitTest
 * @Description: 算法测试
 * @Author: 余霜
 * @Date: 2020/04/01 22:30
 * @Version: V1.0
 **/
public class MaxDepthAfterSplitTest {
    public static void main(String[] args) {
        MaxDepthAfterSplit ys = new MaxDepthAfterSplit();
        ys.maxDepthAfterSplit("()(()())");
    }


    //对优先级不懂得，可以跑一跑下面的代码
    public static void abc() {
        int a = 0;

        int[] ans1 = new int[2];
        int[] ans2 = new int[2];

        ans1[a++] = ans2[a++] = a;



        System.out.println(Arrays.toString(ans1));//[2, 0]
        System.out.println(Arrays.toString(ans2));//[0, 2]
    }


}
