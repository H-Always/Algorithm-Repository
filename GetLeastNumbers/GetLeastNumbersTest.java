import java.util.Arrays;

/**
 * @ClassName: getLeastNumbersTest
 * @Description: 算法测试
 * @Author: 余霜
 * @Date: 2020/03/20 07:43
 * @Version: V1.0
 **/
public class GetLeastNumbersTest {
    public static void main(String[] args) {
        GetLeastNumbers ys = new GetLeastNumbers();

        int[] arr = {1,0,2,3,6,1,4};

        int[] res = ys.getLeastNumbers(arr,3);

        System.out.println(Arrays.toString(res));
    }
}
