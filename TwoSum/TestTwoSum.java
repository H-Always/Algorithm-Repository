import java.util.Arrays;

/**
 * @ClassName: Test
 * @Description: 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:18
 * @Version: 1.0
 */
public class TestTwoSum {
    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        int target = -8;

        TwoSum ys = new TwoSum();

        System.out.println(Arrays.toString(ys.twoSum(nums, target)));
        System.out.println(Arrays.toString(ys.twoSum(nums, target)));
    }
}
