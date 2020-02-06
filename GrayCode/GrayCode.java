import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GrayCode
 * @Description: TODO 打印格雷编码
 * @Author 余霜
 * @Date 2019/9/21
 * @Version V1.0
 **/

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 *
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * 对于给定的 n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
 *
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gray-code
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class GrayCode {

    int val = 0;

    public List<Integer> grayCode(int value) {
        //创建一个List对象，这个和数组差不多，有的时候比数组好用
        List<Integer> gray = new ArrayList<>();
        grayCode(value, gray);
        return gray;
    }

    public void grayCode(int value, List<Integer> gray) {
        //递归出口
        if (value == 0) {
            gray.add(val);
        } else {
            //这两个调用有点巧妙,它一共执行了2^value次，每次传入一个数字
            grayCode(value - 1, gray);
            //位运算，^是按位异或，就是转换城二进制相同位取0不同位取1
            //<<是位移运算 n<<k就是把n向左位移k位，也就是第k位是n其他都是0
            val ^= (1 << value - 1);
            grayCode(value - 1, gray);
        }
    }

    //这个是一个单独的生成格雷编码的算法，非常好，我抄来的，感兴趣可以看一看
    public List<Integer> grayCodePro(int value) {
        List<Integer> gray = new ArrayList<>();
        for (int i = 0; i < 1 << value; i++) {
            gray.add(i ^ i >> 1);
        }
        return gray;
    }
}
