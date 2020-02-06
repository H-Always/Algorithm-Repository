/**
 * @ClassName: Test
 * @Description: 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:18
 * @Version: 1.0
 */
public class TestLongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs =  {"flower","flow","flight"};
        String[] c = {"c","acc","ccc"};
        LongestCommonPrefix ys = new LongestCommonPrefix();
        System.out.println(ys.longestCommonPrefix(strs));
    }
}
