/**
 * @ClassName DeepDarkFraction
 * @Description: TODO 分式化简
 * @Author 余霜
 * @Date 2019/9/25
 * @Version V1.1
 **/

/**
 * 有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
 *
 * 连分数是形如上图的分式(在main中给出了图片)。在本题中，所有系数都是大于等于0的整数。
 *
 * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：cont = [3, 2, 0, 2]
 * 输出：[13, 4]
 * 解释：原连分数等价于3 + (1 / (2 + (1 / (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。
 * 示例 2：
 *
 * 输入：cont = [0, 0, 3]
 * 输出：[3, 1]
 * 解释：如果答案是整数，令分母为1即可。
 * 限制：
 *
 * cont[i] >= 0
 * 1 <= cont的长度 <= 10
 * cont最后一个元素不等于0
 * 答案的n, m的取值都能被32位int整型存下（即不超过2 ^ 31 - 1）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/deep-dark-fraction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class DeepDarkFraction {
    public int[] deepDarkFraction(int[] cont) {
        int length = cont.length;
        //分子为1 因为默认的取最后一个数，当然是几分之一
        int a = 1;
        //分母
        int b = cont[length - 1];
        //计算的时候是一个整数加上一个分数，所以分母是原来分子加上整数*分母
        //然后翻转，变成倒数，继续运算
        //这里注意，运算完的结果一定多执行了一次反转，最后要翻转回来
        for (int j = length - 2; j >= 0; j--) {
            a += b * cont[j];
            a ^= b;
            b ^= a;
            a ^= b;
        }

        //因为是化简，所以要除以最大公约数
        int c = gcd(a, b);
        a /= c;
        b /= c;

        return new int[]{b, a};
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
