import java.util.Arrays;

/**
 * @ClassName: Massage
 * @Description: 按摩师
 * @Author: 余霜
 * @Date: 2020/03/24 15:49
 * @Version: V1.0
 *
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 *  
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * 示例 3：
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

//这题做不出来以后不配去会所按摩！！！
//这题典型的动态规划，还是很简单的那种

// 资本家压榨无产阶级的面目从未改变，不曾想我也成了资本家的帮凶
public class Massage {

    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        //判断一下是接下当前单好还是不接当前单接前一单好
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];

    }

    //菜鸡方便理解版动态规划
    public int massage_QAQ(int[] nums) {

        //判断一下
        if (nums.length == 0)
            return 0;

        if (nums.length<2)
            return nums[0];

        if (nums.length<3)
            return Math.max(nums[0],nums[1]);


        //如果数组超过了3，就动态规划，
        //前三个元素和原数组一样，其他初始值赋值为-1
        int[] dp = new int[nums.length];

        Arrays.fill(dp,-1);
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0]+nums[2];


        int max = 0;

        //当前接单代表前一单必定不能接，所以判断一下接下当前单之后前两单和前三单那个时间比较长
        //去最长的作为当前最有解
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-3]+nums[i]);
        }

        for (int value : dp) {
            max = Math.max(value, max);
        }

        return max;
    }

}
