import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Subest
 * @Description: TODO 打印非重复数组子集
 * @Author 余霜
 * @Date 2019/9/22
 * @Version V1.0
 **/

/**
 * 给出一个数组，返回该数组的所有子集
 * 给出 {1, 2, 3}
 * 返回[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
 */

public class Subest {
    public List<List<Integer>> subest(int[] nums) {
        //这个相当于一个二维数组，和数组套数组一样
        List<List<Integer>> subests = new ArrayList<List<Integer>>();
        //空集是所有集合的子集
        subests.add(new ArrayList<>());
        //foreach循环，这个不太懂的同学最好在把Java基础看一遍
        for (int num : nums) {
            //每次添加元素的个数，每增加一个元素，就在前面元素的基础之上添加这个元素，形成新的子集
            int len = subests.size();
            for (int i = 0; i < len; i++) {
                //ArrayList()中参数的意义是获取之前旧的的子集，在这之上添加新元素
                // 不太明白的同学可以自己测试一下
                List<Integer> sub = new ArrayList<>(subests.get(i));
                //当获取到旧的子集再把新元素添加上，构成新的子集
                sub.add(num);
                //把新的子集放入到最总的List中
                subests.add(sub);
            }
        }
        return subests;
    }
}
