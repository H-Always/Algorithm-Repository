import java.util.Arrays;

/**
 * @ClassName: LengthOfLISTest
 * @Description: 算法测试
 * @Author: 余霜
 * @Date: 2020/03/14 21:33
 * @Version: V1.0
 **/
public class LengthOfLISTest {
    public static void main(String[] args) {

        LengthOfLIS ys = new LengthOfLIS();

        int[] nums = {10,91,2,43,54,7,546,435,7,9,546,4,534,23,7,67,345};
        //int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(Arrays.toString(nums));

        System.out.println(ys.lengthOfLIS(nums));

    }
}
