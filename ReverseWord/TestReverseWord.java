/**
 * @ClassName: Test
 * @Description: 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:18
 * @Version: 1.0
 */
public class TestReverseWord {
    public static void main(String[] args) {
        String s = "hello,world,,mirror,,apple,incisive,include,contain";

        ReverseWord ys = new ReverseWord();
        String res = ys.reverseWord(s);

        System.out.println(res);
    }
}
