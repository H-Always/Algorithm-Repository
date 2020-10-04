import java.util.*;

/**
 * @ClassName: Combine
 * @Description: 组合
 * @Author: 余霜
 * @Date: 2020/09/08 13:19
 * @Version : 1.0
 *
 * 给定两个整数n和k，返回1...n中所有 可能的k个数的组合
 *
 * 例如n = 4，k = 2,输出[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 */
// 这个题，乍一看挺简单，俩循环就完事了，但是转念一想，循环做不出来
// 首先想到的是树状图，用树的分支来做，也确实是这么做的，
public class Combine {
    public List<List<Integer>> combine(int n,int k){

        //创建结果集，用来存放递归的结果
        List<List<Integer>> list = new ArrayList<>();

        //初始条件，不满足条件则返回
        if (n <=0 || k > n)
            return list;

        //双向队列，用来存放单次结果，对这个数据结构不熟悉的话，用栈也可以
        Deque<Integer> deque = new ArrayDeque<>();

        //栈实现
        //Stack<Integer> stack = new Stack<>();

        //递归创建
        dfs(n,k,1,deque,list);

        return list;
    }

    //算法核心，主要是判断递归的层次，
    public void dfs(int n, int k , int begin, Deque<Integer> deque, List<List<Integer>> list ){

        if (deque.size()==k){
            list.add(new ArrayList<>(deque));
            return;
        }

        // 主要理解这三行，首先是每次都在队列的最后面添加新元素
        // 每次添加递归的深度都会+1，同时循环的i也会+1，所以每一次都会添加都是不同的元素
        // 这个算法的主要精髓在于回溯，当判断当前结果集合格之后还要在进行修剪最后的内容，在添加新元素

        for (int i = begin; i <= n ; i++) {
            //在最后面添加新元素
            deque.addLast(i);

            //dfs递归
            dfs(n,k,i+1,deque,list);

            //回溯，修剪最后一个元素
            deque.removeLast();
        }

    }
}
