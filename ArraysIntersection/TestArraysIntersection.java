import java.util.List;

/**
 * @ClassName: TestAddTwoNumbers
 * @Description: 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:17
 * @Version: 1.0
 */
class TestArraysIntersection {
    public static void main(String[] args) {
        ArraysIntersection ys = new ArraysIntersection();

        int[] arr1 = {1,2,3,4,5,6,7,8};
        int[] arr2 = {1,2,4,6,7,10};
        int[] arr3 = {1,3,5,7};

        List<Integer> list = ys.arraysIntersection(arr1,arr2,arr3);

        System.out.println(list);
    }
}
