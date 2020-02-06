import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FindMode
 * @Description: 寻找众数
 * @Author 余霜
 * @Date 2019/12/28 15:37
 * @Version V1.0
 **/

/**
 * 给定一个非排序正整数数组，返回其中出现次数超过一半的数字
 */

public class FindMode {
    public int findMode(int[] arrs) {
        //创建一个Map函数， 利用hashMap的特点来找
        Map<Integer, Integer> map = new HashMap<>();

        //map.containsKey()-判断有没有键值
        //map.get()-添加键值对
        //map.get()-获取当前值
        for (int i = 0; i < arrs.length; i++) {
            if (!map.containsKey(arrs[i])) {
                map.put(arrs[i], 1);
            } else {
                //判断这个数字是否是众数，只要value值大于一半就好了
                if (map.get(arrs[i]) > arrs.length / 2)
                    return arrs[i];
                else
                    map.put(arrs[i], map.get(arrs[i]) + 1);
            }
        }

        return -1;
    }
}
