import java.util.Arrays;

/**
 * @ClassName: MinIncrementForUnique
 * @Description: 使数组唯一的最小增量
 * @Author: 余霜
 * @Date: 2020/03/22 10:50
 * @Version: V1.0
 *
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 *
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 示例 1:
 *
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 示例 2:
 *
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * 提示：
 *
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 **/

//  排序，然后每次操作之后加一，返回一个结果
// 首先排序，有序之后从1开始只要前面的元素小于后面的元素就可以，
// 如果不小于的话，就把这个元素加1，最小操作数+1
// 遍历完就好了
// 这代码刚写完就发现可以优化...
// 如果不小于的话，直接加上A[i-1]-A[i]+1就比前一个元素大1了
// 优化之前跑了1400多毫秒，优化之后跑了15ms，作为一个菜鸡感觉还阔以

public class MinIncrementForUnique {
    public int minIncrementForUnique(int[] A) {

        int min_length = 0;

        Arrays.sort(A);

        int i = 1;

        while (i < A.length) {
            if (A[i - 1] >= A[i]) {
                // min_length++;
                min_length+=A[i-1]-A[i]+1;
                // A[i]++;
                A[i]+=A[i-1]-A[i]+1;
            } else {
                i++;
            }
        }

        return min_length;
    }
}
