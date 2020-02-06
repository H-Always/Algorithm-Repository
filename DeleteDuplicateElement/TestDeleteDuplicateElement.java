import java.util.Arrays;

/**
 * @ClassName: TestAddTwoNumbers
 * @Description: TODO 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:17
 * @Version: 1.0
 */
public class TestDeleteDuplicateElement {
    public static void main(String[] args) {
        int[] element = {5,6,1,1,1,2,2,2,2,2,3,3,3,3,4};

        System.out.println(Arrays.toString(element));


        DeleteDuplicateElement ys = new DeleteDuplicateElement();
        int len = ys.deleteDuplicateElement(element);

        for (int i = 0; i < len; i++) {
            System.out.print(element[i]+" ");
        }
    }
}
