/**
 * @ClassName: Test
 * @Description: 算法测试
 * @Author: 余霜
 * @date: 2020/03/13 07:53
 * @Version: 1.0
 */
public class MajorityElementTest {
    public static void main(String[] args) {
        MajorityElement ys = new MajorityElement();


        int[] nums = {26, 2, 2, 2, 2, 2, 16, 16, 5, 5, 26, 2, 5, 20, 20, 5, 2, 20, 2, 2, 20, 2, 16, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 20, 1};


        System.out.println(ys.majorityElement_2(nums));
    }
}
