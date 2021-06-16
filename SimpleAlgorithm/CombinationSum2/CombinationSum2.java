import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
/**
 * @ ClassName : combinationSum2
 * @ Description : 组合综合II
 * @ Author : 余霜
 * @ Date : 2021/6/16 17:32
 * @ Version : 1.0
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 **/


public class CombinationSum2 {

    // data 为银行流水原数据，但必须是纯数字（非负数），
    // target是目标业务总和
    public List<List<Integer>> combinationSum2(int[] data, int target,boolean degaultFlag) {
        // 长度控制回溯的深度
        int len = data.length;
        // 结果集
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 首先数组排序，如果数据结构不是非纯数字形式，找一个map映射一下
        Arrays.sort(data);
        // 双向队列，比较好用，只能操作头尾，其余不可更改
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(data, len, 0, target, path, res, degaultFlag);
        return res;
    }

    //成功标志，
    static boolean flag = false;

    private void dfs(int[] data, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res,boolean degaultFlag) {

        if (flag) return;

        // 出口，如果存在匹配的银行流水，则立刻添加结果集并返回上一层
        if (target == 0) {
            flag = !degaultFlag;
            res.add(new ArrayList<>(path));
            return;
        }

        // begin 代表了当for开始时候的下标，比如[2,3,3,3,4,5]，
        // 当判断是否要进行小剪枝的时候，比如当前i等于3，那么后面的两个3都是重复的元素，则把后面的两个去掉
        // 举一个例子，我目标为8，那么有5和3加和为8，但是这里有重复，下标为1，2，3的数字3和5都可以构成8，
        // 那么就会产生重复，要在小剪枝中判断剪掉
        for (int i = begin; i < len; i++) {
            // 大剪枝：减去 data[i] 小于 0，减去后面的 data[i + 1]、data[i + 2] 肯定也小于 0，因此用 break
            // 说白了大剪枝就是后面不存在了，也就不用判断了，我判断加和为4，那么无论如果5不能出现，那么5就剪掉
            if (target - data[i] < 0) {
                break;
            }

            // 小剪枝：同一层相同数值的结点，结果一定发生重复，因此跳过，用 continue
            // 注意，这里是该层不可用，不是最后的结果，因为一层中同样的数字无意义
            // 上面例子中，如果找11，那么还是会有[2，3，3，3]结果出现的，
            if (i > begin && data[i] == data[i - 1]) {
                continue;
            }

            //其实重点，就这三行，一个添加元素，一个删除元素，首先要添加元素，
            path.addLast(data[i]);

            // 添加完元素进行下一层判断是否用重复的
            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            // 想重复的话，变成i就可以了
            dfs(data, len, i + 1, target - data[i], path, res,degaultFlag);

            // 当执行到这里，证明上一次添加的元素(尾元素)被利用完毕，那么把他去掉，换另一个元素
            path.removeLast();

        }
    }


}
