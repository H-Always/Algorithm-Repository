import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: CollectBeadsTest
 * @Description: 理琥珀珠测试
 * @Author: 余霜
 * @date: 2020/2/15/18:13
 * @Version: 1.0
 */
public class CollectBeadsTest {
    public static void main(String[] args) {
        CollectBeads ys = new CollectBeads();

        int[][] amber = ys.collectBeads_1(8,3);

        for (int[] ints : amber) {
            System.out.println(Arrays.toString(ints));
        }



    }
}
