/**
 * @ClassName: MaxDepthAfterSplit
 * @Description: 有效括号的嵌套深度
 * @Author: 余霜
 * @Date: 2020/04/01 22:30
 * @Version: V1.0
 *
 * 有效括号字符串 定义：对于每个左括号，都能找到与之对应的右括号，反之亦然。详情参见题末「有效括号字符串」部分。
 *
 * 嵌套深度 depth 定义：即有效括号字符串嵌套的层数，depth(A) 表示有效括号字符串 A 的嵌套深度。详情参见题末「嵌套深度」部分。
 *
 * 给你一个「有效括号字符串」 seq，请你将其分成两个不相交的有效括号字符串，A 和 B，并使这两个字符串的深度最小。
 *
 * 不相交：每个 seq[i] 只能分给 A 和 B 二者中的一个，不能既属于 A 也属于 B 。
 * A 或 B 中的元素在原字符串中可以不连续。
 * A.length + B.length = seq.length
 * 深度最小：max(depth(A), depth(B)) 的可能取值最小。 
 * 划分方案用一个长度为 seq.length 的答案数组 answer 表示，编码规则如下：
 *
 * answer[i] = 0，seq[i] 分给 A 。
 * answer[i] = 1，seq[i] 分给 B 。
 * 如果存在多个满足要求的答案，只需返回其中任意 一个 即可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：seq = "(()())"
 * 输出：[0,1,1,1,1,0]
 * 示例 2：
 *
 * 输入：seq = "()(())()"
 * 输出：[0,0,0,1,1,0,1,1]
 * 解释：本示例答案不唯一。
 * 按此输出 A = "()()", B = "()()", max(depth(A), depth(B)) = 1，它们的深度最小。
 * 像 [1,1,1,0,0,1,1,1]，也是正确结果，其中 A = "()()()", B = "()", max(depth(A), depth(B)) = 1 。
 *  
 *
 * 提示：
 *
 * 1 < seq.size <= 10000
 *  
 *
 * 有效括号字符串：
 *
 * 仅由 "(" 和 ")" 构成的字符串，对于每个左括号，都能找到与之对应的右括号，反之亦然。
 * 下述几种情况同样属于有效括号字符串：
 *
 *   1. 空字符串
 *   2. 连接，可以记作 AB（A 与 B 连接），其中 A 和 B 都是有效括号字符串
 *   3. 嵌套，可以记作 (A)，其中 A 是有效括号字符串
 * 嵌套深度：
 *
 * 类似地，我们可以定义任意有效括号字符串 s 的 嵌套深度 depth(S)：
 *
 *   1. s 为空时，depth("") = 0
 *   2. s 为 A 与 B 连接时，depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是有效括号字符串
 *   3. s 为嵌套情况，depth("(" + A + ")") = 1 + depth(A)，其中 A 是有效括号字符串
 *
 * 例如：""，"()()"，和 "()(()())" 都是有效括号字符串，嵌套深度分别为 0，1，2，而 ")(" 和 "(()" 都不是有效括号字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 **/


// 这题其实读懂题挺好理解的
// 我假设你知道什么叫做有效括号
// 如果不知道有效括号的概念的，或者没有刷过判断有效括号题目的，建议做一下leetCode20. 有效的括号
public class MaxDepthAfterSplit {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int [seq.length()];
        int idx = 0;
        for(char c: seq.toCharArray()) {
            //注意，下面的两种写法虽然都可以通过，但是跑出来的结果是不一样的
            // 可以理解成取反，未注释的代码是先执行idx++的哦，要注意优先级
            /*int a = idx & 1;
            int b =((idx + 1) & 1);
            ans[idx++] = c == '(' ? a :b ;//[0, 0, 0, 1, 1, 0, 0, 0]*/
            ans[idx++] = c == '(' ? idx & 1:((idx + 1) & 1);//[1, 1, 1, 0, 0, 1, 1, 1]
        }
        return ans;

    }


    //如果上面那个不好懂得话，这个好理解点
    public int[] maxDepthAfterSplit_Simple(String seq) {
        int d = 0;
        int len = 0;
        int[] ans = new int[seq.length()];
        //遍历字符串，深度为单数得分一组，深度为偶数得分一组
        for (char c : seq.toCharArray())
        if (c == '(') {
            ++d;
            ans[len++] = d % 2;
        }
        else {
            ans[len++] = d % 2;
            --d;
        }
        return ans;


    }
}
