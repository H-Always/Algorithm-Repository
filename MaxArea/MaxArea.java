/**
 * @ClassName: MaxArea
 * @Description: 盛水最多的容器
 * @Author: 余霜
 * @date: 2020/2/12/17:45
 * @Version: 1.0
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。

 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


// 这个题还是很好的，来说一下思路
// 首先明确我们的目的，是选择出最大的容器，首先我默认最外侧的两条线(i,j)所围成的面积最大
// 此时面积为min(i,j)*len 那里面可能有围城面积比这个数字大的两条线，现在就要往里面判断，往里面缩进一个距离
// 如果我们缩进i和j中较长的那一条线，那么收缩完成之后，的下一条线可能会比原来的大，可能会比原来的小,设为线k
// 我们要明确一点，无论如何底长都会减少一。那么所围成的新面积会是min(k,j)*(len-1),此时这个数字一定比原来的面积min(i,j)*len要小
// 因为注水面积是由底长和较短的一条线决定的，所以就违背我们寻找最大面积的想法
// 正确的做法是往里移动较短一边的线，这样面积才有可能会增加，也就获得了O(n)的解法--每次收缩较短一边的线，直至相遇

public class MaxArea {
    public int maxArea(int[] height) {

        int maxArea = 0;
        int lift = 0;
        int right = height.length-1;

        while (lift<right){
            int current = height[lift] < height[right] ? height[lift++] : height[right--];
            maxArea = Math.max(maxArea, current*(right-lift+1));

        }

        return maxArea;
    }

    public int maxAreaBF(int[] height){
        int max = 0;
        int len = height.length;
        for(int i=0;i<len-1;i++) {
            for(int j=i+1;j<len;j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }

}
