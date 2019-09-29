package AlgorithmPackge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * @ClassName UniqueOccurrences
 * @Description: TODO
 * @Author 余霜
 * @Date 2019/9/29 19:46
 * @Version V1.0
 **/

public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        //建立一个map函数，这个东西相当于python里的字典，在一定时候相当好用
        Map<Integer, Integer> judge = new HashMap<Integer, Integer>();

        //遍历数组,存进map函数里
        for (int value : arr) {
            if (judge.containsKey(value)) {
                judge.put(value, judge.get(value) + 1);
            } else {
                judge.put(value, 1);
            }
        }

        //把对应的值，也就是出现了多少次存进一个数组里
        int[] res = new int[judge.size()];
        int i = 0;
        for (Integer value : judge.values()) {
            res[i] = value;
            i++;
        }

        //排序
        Arrays.sort(res);

        //如果相邻数组出现相同的就说明出现重复，返回false
        for (int j = 1; j < res.length; j++) {
            if (res[j - 1] == res[j])
                return false;
        }
        return true;
    }
}
