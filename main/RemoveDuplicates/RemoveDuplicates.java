package AlgorithmPackge;
/**
 * @ClassName TestAlgorithm
 * @Description: TODO 这是所有方法的入口
 * @Author 余霜
 * @Version V1.0
 **/

public class TestAlgorithm {

    public static void main(String[] args) {

        String str = "deeedbbcccbdaa";
        int k = 2;
        RemoveDuplicates ys = new RemoveDuplicates();

        String res = ys.removeDuplicates(str,k);


        System.out.println(res);

    }
}
