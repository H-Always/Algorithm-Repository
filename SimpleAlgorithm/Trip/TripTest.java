import java.util.Arrays;

/**
 * @ClassName: TripTest
 * @Description: 算法测试
 * @Author: 余霜
 * @Date: 2020/04/05 11:01
 * @Version: V1.0
 **/
public class TripTest {
    public static void main(String[] args) {
        Trip ys = new Trip();

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(Arrays.toString(height));

        System.out.println( ys.trip(height) );
    }
}
