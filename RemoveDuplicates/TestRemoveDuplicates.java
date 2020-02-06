/**
 * @ClassName: Test
 * @Description: 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:18
 * @Version: 1.0
 */
public class TestRemoveDuplicates {
    public static void main(String[] args) {
        String str = "deeedbbcccbdaa";
        int k = 2;
        RemoveDuplicates ys = new RemoveDuplicates();

        String res = ys.removeDuplicates(str,k);


        System.out.println(res);
    }
}
