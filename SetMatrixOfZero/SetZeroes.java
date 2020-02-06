import java.util.Arrays;

/**
 * @ClassName SearcMatrix
 * @Description: TODO 给出一个二维数组，把数值为0的元素的行列的值都置为零
 * @Author 余霜
 * @Date 2019/9/14
 * @Version V1.0
 **/
public class SetZeroes {

    public int[][] setZeroe(int[][] nums) {

        int[] row = new int[nums.length];
        int[] column = new int[nums[0].length];
        init(row, column);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == 0) {
                    row[i] = 0;
                    column[j] = 0;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i] == 0) {
                setRow(nums, i);
            }
        }

        for (int i = 0; i < column.length; i++) {
            if (column[i] == 0) {
                setColumn(nums, i);
            }
        }


        return nums;
    }


    public void init(int[] row, int[] column) {
        Arrays.fill(row, 1);

        Arrays.fill(column, 1);
    }

    public void setRow(int[][] nums, int i) {
        for (int j = 0; j < nums[0].length; j++) {
            nums[i][j] = 0;
        }
    }

    public void setColumn(int[][] nums, int j) {
        for (int i = 0; i < nums.length; i++) {
            nums[i][j] = 0;
        }
    }
}
