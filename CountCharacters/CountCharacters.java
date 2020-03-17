import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: CountCharacters
 * @Description: 拼写单词
 * @Author: 余霜
 * @Date: 2020/03/17 20:31
 * @Version: V1.0
 *
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 * 示例 1：
 *
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 *
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

//看到这题就想到了哈希函数
// 不过吐槽一下，map干不过array...QAQ，毕竟高级数据结构

//思路: 总的来说就是计数，把字典字母存到一个计数容器中，我这里用的map，每次遇到可以判断的字母就-1，
// 否则就说明拼不出该单词，跳出循环
public class CountCharacters {
    public int countCharacters(String[] words, String chars) {

        //建立初始容器，把字母表每一个字母出现的次数存放进去，
        Map<Character,Integer> map = new HashMap<>();

        int max_length = 0;

        //存在就+1，不存在就创建
        for (int i = 0; i < chars.length(); i++) {
            if (map.containsKey(chars.charAt(i))){
                map.put(chars.charAt(i),map.get(chars.charAt(i))+1);
            } else{
                map.put(chars.charAt(i),1);
            }
        }

        //遍历词汇数组，注意这里的每一个单词都需要单独一个容器来计算
        //创建当前单词容器不能写成Map<Character, Integer> current = map;
        //写成下面的或者创建一个新的用current.putAll(map);也可以
        //这样创建的是指针，本体还是同一个地址，遍历的时候就会有问题
        for (String word : words) {
            //创建当前单词容器不能写成Map<Character, Integer> current = map;
            //写成下面的或者创建一个新的用current.putAll(map);也可以
            //这样创建的是指针，本体还是同一个地址，遍历的时候就会有问题
            Map<Character, Integer> current = new HashMap<>(map);
            for (int j = 0; j < word.length(); j++) {
                //判断当前的word的每一个字母是否存在于chars中，并且数量不为0
                if (current.containsKey(word.charAt(j)) && current.get(word.charAt(j)) > 0) {
                    current.put(word.charAt(j), current.get(word.charAt(j)) - 1);
                    if (j == word.length() - 1)
                        max_length += word.length();
                } else {
                    break;
                }
            }
        }

        return max_length;
    }
}
