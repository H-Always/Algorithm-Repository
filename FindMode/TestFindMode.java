/**
 * @ClassName: Test
 * @Description: 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:18
 * @Version: 1.0
 */
public class TestFindMode {
    public static void main(String[] args) {
        FindMode ys = new FindMode();


        int[] arrs = {26, 2, 2, 2, 2, 2, 16, 16, 5, 5, 26, 2, 5, 20, 20, 5, 2, 20, 2, 2, 20, 2, 16, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 20, 1};


        System.out.println(ys.findMode(arrs));
    }
}
