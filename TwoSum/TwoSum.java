import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TwoSum
 * @Description: 两数之和，用哈希函数复杂度O(n),挺快的
 * @Author 余霜
 * @Date 2019/11/28 18:55
 * @Version V1.0
 **/

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class TwoSum {
    //遍历一遍，还是挺容易想到hash的
    public int[] twoSum(int[] nums, int target) {
        //建立map函数，保存前面不满足要求的值
        //注意键值对，key是nums值，value是下标值
        Map<Integer, Integer> map = new HashMap<>();

        //遍历一遍所给数组
        for (int i = 0; i < nums.length; i++) {
            //如果hash里面存在target - nums[i]，就证明找到了，返回
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            //如果没找到，就把这个值当作key值存入，用来以后遍历判断
            map.put(nums[i], i);
        }

        return null;
    }


    //暴力解，没啥说的，两层循环就好了，复杂度O(n^2)
    public int[] twoSum_BF(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }

        return null;
    }

}
