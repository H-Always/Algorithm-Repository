package AlgorithmPackge;

import java.util.Arrays;

/**
 * @ClassName TestAlgorithm
 * @Description: TODO 这是所有方法的入口
 * @Author 余霜
 * @Version V1.0
 **/

public class TestAlgorithm {

    public static void main(String[] args) {

        String s = "hello,world,,mirror,,apple,incisive,include,contain";

        ReverseWord ys = new ReverseWord();
        String[] res = ys.reverseWord(s);

        System.out.println(Arrays.toString(res));

    }
}
