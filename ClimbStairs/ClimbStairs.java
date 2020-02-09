import java.util.ArrayList;

/**
 * @ClassName: ClimbStairs
 * @Description: 跳台阶
 * @Author: 余霜
 * @date: 2020/2/9/14:55
 * @Version: 1.0
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ClimbStairs {
    public int climbStair(int n){
        if (n<=1)
            return 1;
        if (n==2)
            return 2;

        //这个题算是一道最简单的动态规划了吧
        //初始条件，一个1，一个2，因为从这一位起，每一次都需要前两次的计算结果
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);

        //判断条件，list的长度即为当前已经跳了多少台阶，那么把对应的前两位加一下就好
        while(list.size()<n){
            list.add(list.get(list.size()-1)+list.get(list.size()-2));
        }

        return list.get(list.size()-1);
    }
}
