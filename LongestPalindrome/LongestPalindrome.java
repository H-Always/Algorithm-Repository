import java.util.Arrays;

/**
 * @ClassName: LongestPalindrome
 * @Description: 最长回文串
 * @Author: 余霜
 * @Date: 2020/03/19 22:25
 * @Version: V1.0
 *
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 **/
//有了上次array干不过HashMap的经验，这次洒家机制的用了数组！！
// 思路，有点暴力解题的嫌疑...
// 遍历整个数组，把每种字符出现的次数加到一个长度52的数组里，因为大小写字母一共52个
// 如果出现次数不为零，此时有两种情况，出现偶数次和奇数次，这里注意，出现单次的字母只能有一个放在中间使用
// 偶数次直接添加对应长度就好了，奇数次需要一个补充，比如EEEDD，显然结果为5，DD出现两次添加，而DDD仅在特例中添加了3
// EEEACERDD，这里出现了单个的有ACER还有奇数次数的E，显然，在这五个中只能取一个放在中间，所以要设置一个标志
// 设置一个标志flag，证明出现了单个次数的字母，最后把这个单个字符加到中间，就可以了
// 最后返回的长度加上flag就是最后的结果

//其实这个题用HashMap也很好，添加进去然后遍历一遍，思路一样，只不过可能会慢一点
public class LongestPalindrome {
    public int longestPalindrome(String s) {

        int[] frequency = new int[52];
        int current;

        //遍历数组,把每个字符出现的次数加进去
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);

            if (current < 91)
                frequency[current - 65]++;
            else
                frequency[current - 97 + 26]++;

        }

        int falg = 0;
        int max_length = 0;

        //遍历频率数组，选择匹配的字符
        for (int value : frequency) {

            //如果%2==0，证明出现了偶数次，加进去就好了，出现0次也没关系
            if (value % 2 == 0) {
                max_length += value;
            } else {
                //奇数次除了匹配的偶数次之外，还要添加一下标志
                max_length += value - 1;
                falg = 1;
            }
        }

        return max_length + falg;
    }
}
