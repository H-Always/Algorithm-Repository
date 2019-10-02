package AlgorithmPackge;
/**
 * @ClassName TestAlgorithm
 * @Description: TODO 这是所有方法的入口
 * @Author 余霜
 * @Version V1.0
 **/

public class TestAlgorithm {

    public static void main(String[] args) {

        MaxEqualSubstring ys = new MaxEqualSubstring();

        int res = ys.maxEqualSubstring("ujteygggjwxnfl", "nstsenrzttikoy", 43);

        System.out.println(res);
    }
}
