package AlgorithmPackge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MinimumAbsDifference
 * @Description: TODO 最小绝对差
 * @Author 余霜
 * @Date 2019/10/5 22:13
 * @Version V1.0
 **/

public class MinimumAbsDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        int min = Math.abs(arr[1]-arr[0]);

        //创建返回值
        List<List<Integer>> result = new ArrayList<List<Integer>>();

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
            List<Integer> list = new ArrayList<Integer>();
            if (Math.abs(arr[i]-arr[i-1]) == min){
                list.add(arr[i-1]);
                list.add(arr[i]);
                result.add(list);
            }
        }

        return result;
    }
}
