/**
 * @ClassName: CanThreePartsEqualSum
 * @Description: 将数组分成和相等的三个部分
 * @Author: 余霜
 * @Date: 2020/03/11 17:12
 * @Version: V1.0
 *
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 *
 *  
 *
 * 示例 1：
 *
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 示例 2：
 *
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * 示例 3：
 *
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *  
 *
 * 提示：
 *
 * 3 <= A.length <= 50000
 * -10^4 <= A[i] <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/


//如果能够三等分的话，必定存在一前一后和中间，所以中间的就不用管了，判断出左右能够数值相等，那么中间也就找到了
// 这题我想了挺长时间，太菜了，双指针的题...条件判断上也失误很多，要好好反省一下

//思路:能够被分成三份的数组加和一定能够被三整除，那么先求和，在%3判断是否可以直接返回，不能的话在判断
// 三部分和相等，那么问题就好办了，把加和除三，算出目标值，双指针前后遍历到这个和就完事了
// 要注意一下，这里的判断条件为i+1，因为要分成非空三份，中间必须空一个
public class CanThreePartsEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int value : A) sum += value;

        //如果不能被3整除，代表一定不可能被整分
        if (sum % 3 != 0)
            return false;

        int average = sum / 3;

        //变量初始化
        int i = 0, j = A.length - 1;
        int left = A[i], right = A[j];

        //双指针开始遍历，当某一个指针找到目标值就结束该指针的遍历
        //如果都找到了，又满足中间空出来了一段，就证明该数组可以平均分成三份
        while (i + 1 < j) {
            if (left != average) {
                i++;
                left += A[i];
            }

            if (right != average) {
                j--;
                right += A[j];
            }

            if (left == average && right == average && i + 1 < j)
                return true;
        }

        return false;
    }


    //来看一种更好的方法
    //单指针，这个算法时间复和空间杂度非常好
    public boolean canThreePartsEqualSum_SinglePointer(int[] A) {
        int sum = 0;
        for (int num: A)
            sum += num;

        if (sum % 3 != 0)
            return false;

        // 遍历数组累加，每累加到目标值就把flag加1，表示找到了一段满足条件的数字,当flag为2的时候就返回
        // 这里注意！遍历上限为length-1，这样就把第三段自动空出来了
        sum /= 3;
        int flag = 0, temp = 0;

        for (int i = 0; i < A.length - 1; i++) {
            temp+=A[i];
            if (temp == sum){
                flag++;
                if (flag == 2)
                    return true;
                temp = 0;
            }
        }

        return false;
    }



    //暴力解，两层循环套，算法测试可能通不过，通过了也是运气好
    public boolean canThreePartsEqualSum_BF(int[] A) {
        int sum = 0;
        for (int value : A) sum += value;

        if (sum % 3 != 0)
            return false;

        int left = 0;

        for (int i = 0; i < A.length; i++) {
            left += A[i];
            int right = 0;
            for (int j = A.length - 1; j > i + 1; j--) {
                right += A[j];
                if (left == right) {
                    if (judge(A, i, j, left, right))
                        return true;
                }
            }
        }

        return false;
    }

    public static boolean judge(int[] A, int i, int j, int left, int right) {

        int mid = 0;

        for (int k = i + 1; k < j; k++) {
            mid += A[k];
        }
        return (mid == left) && (right == mid);
    }

}
