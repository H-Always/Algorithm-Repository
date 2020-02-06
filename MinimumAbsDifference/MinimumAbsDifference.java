import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MinimumAbsDifference
 * @Description: 最小绝对差
 * @Author 余霜
 * @Date 2019/10/5 22:13
 * @Version V1.0
 **/

/**
 * LeetCode周塞题
 *
 * 给你个整数数组 arr，其中每个元素都 不相同。
 *
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 *
 * 示例 1：
 *
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 *
 * 示例 3：
 *
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 *
 *
 * 提示：
 *
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 */

public class MinimumAbsDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        int min = Math.abs(arr[1]-arr[0]);

        //创建返回值
        List<List<Integer>> result = new ArrayList<>();

        //排序数组,用来简化程序
        //如果没有这一步，在下面循环就要平方复杂度
        Arrays.sort(arr);

        //因为是排序数组，最小值一定是出现在相邻两个数之间
        //元素不重复，所以如果两个值相减为1时就是理论最小值了
        for (int i = 1; i < arr.length; i++) {
                int temp = Math.abs(arr[i]-arr[i-1]);
                if (temp == 1){
                    min = 1;
                    break;
                }

                if (temp<min)
                    min = temp;
        }

        //遍历一遍数组，把相邻相减是1的元素放进List中
        for (int i = 1; i < arr.length; i++) {
            List<Integer> list = new ArrayList<>();
            if (Math.abs(arr[i]-arr[i-1]) == min){
                list.add(arr[i-1]);
                list.add(arr[i]);
                result.add(list);
            }
        }

        return result;
    }
}
