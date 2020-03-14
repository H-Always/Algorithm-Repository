import java.util.Arrays;

/**
 * @ClassName: LengthOfLIS
 * @Description: 最长上升子序列
 * @Author: 余霜
 * @Date: 2020/03/14 21:33
 * @Version: V1.0
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

//看到这题就想到了双指针或者三指针，思想都错了，贴一下自己写辣鸡代码，算是给自己一个警示
    /*
     int left = nums[0];
        int temp = nums[0];
        int length = 1;
        int max_length = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i]<left){
                left = nums[i];
                length = 1;
                temp = left;
                continue;
            }

            if (nums[i]>temp){
                length++;
                max_length = Math.max(length,max_length);
                temp = nums[i];
            }

        }

        return max_length;
    }
     */


//动态规划！动态规划！！动态规划又没写出来！！！，我太难了，我太菜了...
//先找状态，我就不写一些数学公式了，简单一点说，什么情况下才是最长上升子序列？(此处上升为严格上升)
//下一个最长子序列一定是在当前最长上升子序列的基础上判断的，
// 比如我给出[1,2,50]最大序列为3，如果我往后拼接一个2，那么就要判断3是否大于50？大于的话最长就更新为4，
// 否则就再往前判断，2是否大于2？不大于的话就再往前判断，2是否大于1？大于的话就更新以1为最长自序+1，就是2，返回的时候遍历一遍
// 这个意思就是，只要找到前面一个比它小的数字就好了，dp[i]代表了以i为数字结尾的最长上升子序列
// 其实也可把dp写成非降序的,就不用去遍历了
// 大概就这意思...动态规划是一种思想，不是方法，好好思考...
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        if (len < 2)
            return len;

        int max_length = 0;

        int[] dp = new int[len];
        // 自己一定是一个子序列
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            // 看以前的，比它小的，说明可以接在后面形成一个更长的子序列
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            //同时记录一下当前最长升序子串的长度
            max_length = Math.max(max_length,dp[i]);
            System.out.println(Arrays.toString(dp));
        }

        return max_length;
    }
}
