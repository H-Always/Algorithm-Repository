import java.util.List;

/**
 * @ ClassName : CombineTest
 * @ Description :算法测试
 * @ Author : 余霜
 * @ Date : 2020/09/08/13:19
 * @ Version : 1.0
 */
public class CombineTest {
    public static void main(String[] args) {
        Combine combine = new Combine();

        System.out.println( );
        List<List<Integer>> lists = combine.combine(12,7);

        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }
}
