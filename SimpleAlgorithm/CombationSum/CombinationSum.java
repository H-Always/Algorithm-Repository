import java.util.*;

/**
 * @ ClassName : CombinationSum
 * @ Description :组合总和
 * @ Author : 余霜
 * @ Date : 2020/09/09 17:25
 * @ Version : 1.0
 *
 *
 * 给定一个无重复元素的数组candidates和一个目标target，找出dandidates中所有可以是数字和为target的组合
 * candidates中的数字可以无限制重复被选取
 *
 * 说明：
 *      所有数字都是正整数
 *      解集不能包含重复的组合
 * 示例1；
 * 输入 candidates = [2，3，6，7] target = 7
 * 所求解集  [[7],
 *          [2,2,3]
 *          ]
 */
public class CombinationSum {
    public List<List<Integer>> CombationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();

        if (candidates.length <= 0)
            return list;

        //开一个双向队列，保存当前解集
        Deque<Integer> deque = new ArrayDeque<>();

        //dfs
        dfs(candidates, 0, target, list, deque);

        return list;
    }

    // 算法核心，这个题和leetcode一个题目非常相似，这个算是进阶版
    void dfs(int[] candidates, int begin, int target, List<List<Integer>> list, Deque<Integer> deque) {


        // 递归出口，判断当前解集是否满足条件，满足的话就添加进去
        // 这里注意，当前结果集满足之后要把最后添加的一个元素剪掉
        // 因为当前结果如果满足的话，下一个数字必定会超过该元素值，随意要修剪掉然后进行回溯
        if (value(deque) == target) {
            list.add(new ArrayList<>(deque));
            deque.removeLast();
            return;
        }

        // 当前添加完元素之后如果大于这个数字，那么之后添加任意元素都必定会大于target
        // 所以直接把最后一个元素剪掉即可，同时进行回溯，这里要注意，当前给定的数组不一定是有序数组，所以还要继续往下寻找
        if (value(deque) > target) {
            deque.removeLast();
            return;
        }

        // 核心思想，遍历整个数组，然后把当前元素添加进去，添加进去会有三种情况<target,>target,=target
        // 这里需要注意的是每一个元素可以无限制的被使用，比如给定{1，2，3}，tar = 5;那么[1,1,1,1,1]就是第一个结集
        // 所以dfs递归深度+1的时候传递进去的begin值要为当前i的值，如果依旧给定begin，那么会得到一个有重复项的解集
        for (int i = begin; i < candidates.length; i++) {
            deque.addLast(candidates[i]);
            dfs(candidates, i, target, list, deque);
        }

        // 运行到这里的时候证明当前深度已经把所有的数字都用一遍了还是没能达到target
        // 那么就要深度-1，在上一层的基础上在进行判断
        // dfs-1的时候要注意修剪当前的解集最后一个数字
        if (!deque.isEmpty())
            deque.removeLast();
    }

    // 求和，判断当前解集数字总和
    int value(Deque<Integer> deque) {
        Deque<Integer> tempDeque = new ArrayDeque<>(deque);
        int val = 0;

        for (Integer integer : tempDeque)
            val+=integer;

        return val;
    }
}