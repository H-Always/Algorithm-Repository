/**
 * @ClassName: GcdOfStrings
 * @Description: 字符串的最大公因子
 * @Author: 余霜
 * @Date: 2020/03/12 22:58
 * @Version: V1.0
 *
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 *
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 *
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *  
 *
 * 提示：
 *
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

//看到这题首先就想到了最长公共子串这个题，是不是把最长换成最短就可以了，找最短公共子串
// 答案是不可以的，最短公共子串一定只有一个字母...
// 这个时候我们回到题目，两个字符串都能被同一个子串除尽，假设子串为s，那么第一个字符串就是a个s，第二个就是b个s，
// 既然都相等，字符串str1+str2=(a+b)s=str2+str1,这个式子看起来是废话，但是这证明了一个充要条件，str1+str2==str2+str1时才会有结果
// 那么问题就简单了，当确定有解的情况下，找到最小公因数就好了，也就是gcd算法:gcd(str1.length, str2.length)
// 这个理论最优长度是不是每次都能达到呢？是的。
// 因为如果能循环以它的约数为长度的字符串，自然也能够循环以它为长度的字符串，所以这个理论长度就是我们要找的最优解。


    //补充一下gcd算法，这个算是比较常用的算法
    //int gcd(int a, int b) {return b == 0? a : gcd(b , a % b);}
    //给定a,b两个整数，通过辗转相除法求得最小公倍数:b不为0则把b赋值给a，b=a%b,一直到b为0为止
    //比如给定两个数字，a:24和b:144，-> a:144,b:24 -> a:24,b:0 -> 24

public class GcdOfStrings {

    public String gcdOfStrings(String str1, String str2) {

        if (!(str1 + str2).equals(str2 + str1)) return "";

        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public static int gcd(int a, int b) { return b == 0? a : gcd(b , a % b); }

}
