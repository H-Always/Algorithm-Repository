/**
 * @ClassName: RemoveArrayDuplicatesTest
 * @Description: 算法测试
 * @Author: 余霜
 * @date: 2020/3/8/17:15
 * @Version: 1.0
 */
public class RemoveArrayDuplicatesTest {
    public static void main(String[] args) {

        RemoveArrayDuplicates ys = new RemoveArrayDuplicates();

        int[] arr = {1,2,2,2,2,3,4,5,6,7,7};

        int len = ys.removeArrayDuplicates(arr);

        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }

    }
}
