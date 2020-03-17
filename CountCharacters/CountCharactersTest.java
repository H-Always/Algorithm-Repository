import java.util.Arrays;

/**
 * @ClassName: CountCharactersTest
 * @Description: 算法测试
 * @Author: 余霜
 * @Date: 2020/03/17 20:31
 * @Version: V1.0
 **/
public class CountCharactersTest {
    public static void main(String[] args) {
        CountCharacters ys = new CountCharacters();

        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";

        System.out.println(Arrays.toString(words));
        System.out.println(chars);
        System.out.println(ys.countCharacters(words,chars));

    }
}
