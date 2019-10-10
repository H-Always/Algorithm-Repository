package AlgorithmPackge;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ArraysIntersection
 * @Description: TODO 三个有序数组的交集
 * @Author 余霜
 * @Date 2019/10/10 22:01
 * @Version V1.0
 **/

public class ArraysIntersection {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        //要返回的List
        List<Integer> list = new ArrayList<Integer>();

        //如果其中一个或者以上的数组为空，就没有必要在查找了
        if (arr1.length == 0 || arr2.length == 0 || arr3.length == 0)
            return list;

        int i = 0, j = 0, k = 0;

        while (true) {
            //如果同时存在，就放进List中
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                list.add(arr1[i]);
                i++;
                j++;
                k++;
                if (i >= arr1.length || j >= arr2.length || k >= arr3.length) {
                    break;
                }
            }
            //否则的话，就找一下最小的那个数字，把最小的数字下标加一，
            //注意判断一下加完之后是否越界
            else {
                int min = arr1[i] < arr2[j] ? 1 : 2;
                switch (min) {
                    case 1:
                        if (arr1[i] > arr3[k])
                            k++;
                        else
                            i++;
                        break;
                    case 2:
                        if (arr2[j] > arr3[k])
                            k++;
                        else
                            j++;
                        break;
                    default:
                        break;
                }
                if (i >= arr1.length || j >= arr2.length || k >= arr3.length)
                    break;
            }
        }

        return list;
    }
}
