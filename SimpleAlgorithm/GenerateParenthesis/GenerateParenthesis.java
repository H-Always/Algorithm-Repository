import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: GenerateParenthesis
 * @Description: 括号生成
 * @Author: 余霜
 * @Date: 2020/04/09 22:22
 * @Version: V1.0
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

// 这题一眼看就像递归...其实递归算不上好方法，递归的时间复杂度很差很差
// 在以前还是很菜的时候，总想着这些大佬怎么看见题就知道用什么方法，
// 虽然我现在还不是大佬，算1/3个吧，有点懂大佬是怎么想的了
// 递归！递归！从后往前递归。我假定你已经知道什么叫有效括号，不再赘述
// 如果左括号还有剩余，就把左括号加进去，如果右括号的个数大于当前左括号的个数，证明左括号已经加进去了一部分，可以添加右括号，
// 注意，递归的时候一定是先添加左括号
// 当左右括号都添加完毕，也就是(left == 0 && right == 0，证明判断出了一种情况，添加到结果集
public class GenerateParenthesis {
    //创建一个list，全局的，不走递归
    List<String> res = new ArrayList<>();


    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    //这三个参数分别是左括号个数，右括号个数，当前生成的括号的字符串
    private void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }

        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号，这里一定要先判断左括号，因为起始一定是左边
            System.out.println(res);
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            System.out.println(res);
            dfs(left, right - 1, curStr + ")");
        }
    }


    // 我就知道！有动！态！规！划！！！
    // 带佬就是带佬...我还是太菜了，写个算法双5%QAQ
    public List<String> generateParenthesis_QAQ(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // 这里 dp 数组我们把它变成列表的样子，方便调用而已
        List<List<String>> dp = new ArrayList<>(n);

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        // 枚举右括号的位置
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }


}
