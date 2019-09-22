package AlgorithmPackge;

import java.util.List;
/**
 * @ClassName TestAlgorithm
 * @Description: TODO 这是所有方法的入口
 * @Author 余霜
 * @Version V1.0
 **/

public class TestAlgorithm {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subest ys = new Subest();

        List<List<Integer>> subest = ys.subest(nums);

        System.out.println(subest);

    }

}
//给出1,2,3
//第一次{[]}
//第二次{[],[] 1}
//第三次{[],[] 1,[] 2,[] 1 2}
//第四次{[],[] 1,[] 2,[] 1 2,[] 3,[] 1 3,[] 2 3，[] 1 2 3}
//每次循环的次数是上一个数组的长度
