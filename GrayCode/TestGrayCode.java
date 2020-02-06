import java.util.List;

/**
 * @ClassName: Test
 * @Description: TODO 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:18
 * @Version: 1.0
 */
public class TestGrayCode {
    public static void main(String[] args) {

        GrayCode ys = new GrayCode();
        List<Integer> gray = ys.grayCode(4);

        System.out.println(gray);
    }
}
