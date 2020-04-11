/**
 * @ClassName: ReverseWordsTest
 * @Description: 算法测试
 * @Author: 余霜
 * @Date: 2020/04/10 17:03
 * @Version: V1.0
 **/
public class ReverseWordsTest {

    public static void main(String[] args) {
        ReverseWords ys = new ReverseWords();


        String s = "   hello world              mirror   apple  incisive  include   contain  ";
        System.out.println(s);
        System.out.println(ys.reverseWords(s));
    }
}
