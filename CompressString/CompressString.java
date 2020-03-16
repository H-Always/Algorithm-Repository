/**
 * @ClassName: CompressString
 * @Description: 面试题 01.06. 字符串压缩
 * @Author: 余霜
 * @Date: 2020/03/16 07:38
 * @Version: V1.0
 *
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 *
 * 字符串长度在[0, 50000]范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compress-string-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

//这题很简单，真的很简单，但是我测试用例花了十分钟找bug，总是提示找不到标志，为什么呢？题目给的S我写的s，吐了...
//这题我最开始想到的是set去重，判断是否可以被压缩，写两行发现给出的字符串没有顺序..
//思路，这题真的没啥...如果一个给定的字符串长度小于3，那么必定不会被压缩，直接返回
// 如果可能被压缩，那么就往下遍历，遇到不一样的就存一下。
// 可能稍微难一点的就是边界判断了把，比如"aabbcccc"怎么把最后的c也遍历到，我的方法是直接在末尾加一个不可能出现的字符，比如"aabbcccc0"
// 最后返回的时候判断一下长度
public class CompressString {
    public String compressString(String S){

        if (S.length()<3)
            return S;

        //创建一个新的，优化了边界的字符串
        StringBuilder str = new StringBuilder(S);
        str.append("0");

        char temp = S.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();

        //遍历字符串，如果下一个字母一样，就继遍历，否则添加
        for (int i = 1; i < str.length(); i++) {
            if (temp==str.charAt(i)){
                count++;
                continue;
            }

            sb.append(temp);
            sb.append(count);
            count = 1;
            temp = str.charAt(i);
        }

        //返回的时候判断一下压缩的长度
        return sb.length()<S.length()?sb.toString():S;
    }
}
