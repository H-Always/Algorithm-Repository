import java.util.Arrays;

/**
 * @ClassName: MinimumLengthEncoding
 * @Description: 单词的压缩编码
 * @Author: 余霜
 * @Date: 2020/03/28 19:15
 * @Version: V1.0
 *
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 *
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 *
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 *  
 *
 * 示例：
 *
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * 每个单词都是小写字母 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/short-encoding-of-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

// 题目大概啥意思呢
// ["time", "me", "bell"]是待编码列表，"time#bell#"是编码结果，indexes = [0, 2, 5]对应的是三个单词在编码结果中的起始位置。
// 字典树又名前缀树，Trie树，是一种存储大量字符串的树形数据结构，相比于HashMap存储，在存储单词（和语种无关，任意语言都可以）的场景上，节省了大量的内存空间。
// 这题目前我做不出来，不过今天很高兴，学到了一种新的方法，字典树，
// leetcode一个大佬写的，厉害啊，写的很好，
// 高级数，回头在数据结构库里面补一份
// 今天的题还算有点水平，学到了不少知识
// 字典树！其实就是一颗树，只不过每一个节点由长度26的数组组成
// 文件夹中我给了一张字典树示例 图来源leetcodeID:sweetiee
// 这题是我实例不够，确实没做过字典树的题
// leetcode的208. 实现 Trie (前缀树)，有兴趣的小伙伴可以写一下这个
public class MinimumLengthEncoding {
    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        // 先对单词列表根据单词长度由长到短排序
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        // 单词插入trie，返回该单词增加的编码长度
        for (String word: words) {
            len += trie.insert(word);
        }
        return len;
    }
}

// 定义tire
class Trie {

    //创建树的时候，根节点是没有值的，因为没有办法用根节点保存数据
    TrieNode root;

    //构造函数，默认创建一个节点
    public Trie() {
        root = new TrieNode();
    }

    //算法核心，插入单词，因为比的是后缀，比如，time/me，这俩可以合并成time
    //但是time/im，就是两个单词，没办法合并
    public int insert(String word) {
        //当前节点为当前的根节点，注意，这个根节就是整体的根节点，插入的时候是在这个根节点下面插入
        TrieNode cur = root;
        boolean isNew = false;
        // 倒着插入单词
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            //这里如果能够进去，证明没有这个以这个字母开头的单词，是一个新单词
            if (cur.children[c] == null) {
                isNew = true; // 是新单词
                //在这个节点中在开辟一个节点，用来保存接下来的字符
                cur.children[c] = new TrieNode();
            }
            //当前节点往下走，相当于node = node.next
            cur = cur.children[c];
        }
        // 如果是新单词的话编码长度增加新单词的长度+1，否则不变。
        return isNew? word.length() + 1: 0;
    }
}

//字典树的节点结构
class TrieNode {
    //每一个字符会保存一个字符
    char val;
    //假设都是小写，最多也就二十六个字符，如果还有其他字符，就继续加长度
    TrieNode[] children = new TrieNode[26];

    //给一个构造函数
    public TrieNode() {}
}
