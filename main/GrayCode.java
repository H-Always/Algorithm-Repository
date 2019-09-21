package AlgorithmPackge;

import java.util.ArrayList;
import java.util.List;
/**
 * @ClassName TestAlgorithm
 * @Description: TODO 这是所有方法的入口
 * @Author 余霜
 * @Version V1.0
 **/

public class TestAlgorithm {
    public static void main(String[] args) {

        List gray = new ArrayList();

        GrayCode ys = new GrayCode();
        gray = ys.grayCode(4);

        System.out.println(gray);
    }

}
