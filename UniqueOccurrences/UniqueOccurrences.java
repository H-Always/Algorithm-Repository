import java.util.*;

/**
 * @ClassName UniqueOccurrences
 * @Description: 独一无二数字出现次数
 * @Author 余霜
 * @Date 2019/9/29 19:46
 * @Version V1.0
 **/

/**
 * LeetCode周赛题
 *
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 *
 * 提示：
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */

public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        //建立一个map函数，这个东西相当于python里的字典，在一定时候相当好用
        Map<Integer, Integer> judge = new HashMap<>();

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
