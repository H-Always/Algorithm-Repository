package AlgorithmPackge;

import java.util.Arrays;
import java.util.SplittableRandom;

/**
 * @ClassName TestAlgorithm
 * @Description: TODO 这是所有方法的入口
 * @Author 余霜
 * @Version V1.0
 **/

public class TestAlgorithm {


    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum ys = new TwoSum();

        System.out.println(Arrays.toString(ys.twoSum(nums, target)));

    }
}
