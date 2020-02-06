/**
 * @ClassName: Test
 * @Description: 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:18
 * @Version: 1.0
 */
public class TestPrintArrays {
    public static void main(String[] args) {
        PrintArrays ys = new PrintArrays();
        int[][] arr = new int[7][7];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = count++;
            }
        }

        System.out.println(ys.printArrays(arr));


    }
}
