package AlgorithmPackge;
/**
 * @ClassName MaxEqualSubstring
 * @Description: TODO 尽可能使字符串相等(暴力求解)
 * @Author 余霜
 * @Date 2019/10/2 10:33
 * @Version V1.0
 **/

public class MaxEqualSubstring {
    public int maxEqualSubstring(String s, String t, int maxCost) {
        int count = 0;
        int value = 0;
        int max = 0;

        //建立第一个数组，这个数组用来存放两个字符串的ASCII绝对值
        int[] temp = new int[s.length() < t.length() ? s.length() : t.length()];

        for (int i = 0; i < temp.length; i++)
            temp[i] = Math.abs(s.charAt(i) - t.charAt(i));

        //暴力搜索，如果当前跳出了if，就回溯，把i置为初始的下一个位置，继续搜索
        // (复杂度极差...)
        int j = 0;
        for (int i = 0; i < temp.length; i++) {
            value += temp[i];
            if (value <= maxCost) {
                count++;
                max = max < count ? count : max;
            } else {
                count = 0;
                value = 0;
                i = j++;
            }
        }

        return max;
    }
}






