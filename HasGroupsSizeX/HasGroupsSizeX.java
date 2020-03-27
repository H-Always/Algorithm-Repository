/**
 * @ClassName: HasGroupsSizeX
 * @Description: 卡牌分组
 * @Author: 余霜
 * @Date: 2020/03/27 09:53
 * @Version: V1.0
 *
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 *
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 3：
 *
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 4：
 *
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 示例 5：
 *
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 *
 * 提示：
 *
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
//这题HashMap也干不过Array，用int[10000]统计比hashmap快很多
// 原来我是HashMap党的，现在有一点叛变了
// 当然，Array有限制，HashMap没太多，比如这题数字如果int级别，Array就不行了
// 但是这个占用内存不少，
// 但是！！这里我就要说了！栈空间固定大小，寄存器固定位宽，只要别太大，内存啥的，都一个样....
// 思路，这题其实挺好想的，遍历一遍，统计每一个数字出现的次数，然后找出他们的最大公约数
// 最大公约数肯定是gcd啊，但是这里不用两个for暴力哦，遍历一次就可以了，每个数字和当前最大公约数比
public class HasGroupsSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        //开一个数组，长度10000，
        //别问我浪不浪费空间，问就是固定大小！
        int[] counts = new int[10000];
        //统计次数
        for(int card : deck) {
            counts[card]++;
        }
        //找各个数字的最大公约数，一旦出现<2就说明不可能分割成功
        int gcd = counts[deck[0]];
        for(int cnt : counts) {
            if(cnt != 0) {
                gcd = gcd(gcd, cnt);
                if(gcd < 2) {
                    return false;
                }
            }
        }
        return true;
    }

   public int gcd(int a ,int b){return b==0?a:gcd(b,a%b);}
}
