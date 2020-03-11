import java.util.Arrays;

/**
 * @ClassName: CanThreePartsEqualSumTest
 * @Description: 算法测试
 * @Author: 余霜
 * @Date: 2020/03/11 17:13
 * @Version: V1.0
 **/
public class CanThreePartsEqualSumTest {
    public static void main(String[] args) {
        CanThreePartsEqualSum ys = new CanThreePartsEqualSum();

        int[] A = {6,1,1,13,-1,0,-10,20};

        System.out.println(Arrays.toString(A));

        System.out.println(ys.canThreePartsEqualSum(A));


    }
}
