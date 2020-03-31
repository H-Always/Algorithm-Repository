import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: LastRemaining
 * @Description: 圆圈中最后剩下的数字(约瑟夫环)
 * @Author: 余霜
 * @Date: 2020/03/30 22:18
 * @Version: V1.0
 *
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
//这题给的有点意思
// 一开始我觉得简单，这写个链表不就完事了么，把数一存，一个一个删除，看一下size什么时候为1，或者开一个数组也行
// 然而洒家看到限制，发现事情并不简单！这特么，m<=10^6?? 10^6?? 这复杂度绝对超时，结果果然不出我所料...跑了一千多毫秒
// 因为 LinkedList 虽然删除指定节点的时间复杂度是 O(1)O(1) 的，但是在 remove 时间复杂度仍然是 O(n)O(n) 的，因为需要从头遍历到需要删除的位置。
// 那 ArrayList 呢？索引到需要删除的位置，时间复杂度是 O(1)O(1)，删除元素时间复杂度是 O(n)O(n)（因为后续元素需要向前移位），
// remove 整体时间复杂度是 O(n)O(n) 的。看起来LinkedList 和 ArrayList 单次删除操作的时间复杂度是一样的
// 这题其实是个著名的数学问题，叫约瑟夫环，具体可以参考这两篇文章，结合着看
// https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
// https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/huan-ge-jiao-du-ju-li-jie-jue-yue-se-fu-huan-by-as/
// 总结一下就是递推公式f(n,m)=[f(n−1,m)+m]%n,

public class LastRemaining {

    public int lastRemaining(int n, int m) {
        //最后一个活下来的下标必为0，所以从0开始反推
        int res = 0;
        // 前一轮剩下2个人，所以循环从2开始
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
            System.out.println(res);
        }
        return res;
    }

    //暴力解法，没啥好说的，模拟链表
    public int lastRemaining_QAQ(int n, int m) {
        //开一个ArrayList，注意LinkList不行，因为LinkList是随机内存访问，但是ArrayList是连续的内存，因为底层是数组嘛
        // 所以所以相比于LinkedList大量非连续性地址访问，ArrayList的性能是勉强可以的....
        // 时间复杂度O(n^2)
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            //(index+m)%n,这个稍微推一推就可以，比如四个数，每6个一删除，那么必然要取模，这里如果不-1的话取到的是对应的位置而不是下标
            index = (index + m - 1) % n;
            //删除这个元素，这个语句执行速度是O(n),外面还有一层循环所以是n^2
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

}
