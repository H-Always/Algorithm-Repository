package AlgorithmPackge;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SubestPro
 * @Description: TODO
 * @Author 余霜
 * @Date 2019/9/24
 * @Version V1.0
 **/

public class SubestPro {
    public List<List<Integer>> subestPro(int[] nums) {

        List<List<Integer>> subestPro = new ArrayList<List<Integer>>();
        subestPro.add(new ArrayList<>());
        //可以随便一个取不到对数字，只要不和第一位一样就行
        int temp = -10086;
        for (int num : nums) {
            if (temp != num) {
                int length = subestPro.size();
                for (int i = 0; i < length; i++) {
                    List<Integer> sub = new ArrayList<>(subestPro.get(i));
                    sub.add(num);
                    subestPro.add(sub);
                }
            }
            //把临时值赋值为当前判断完的元素
            temp = num;
        }
        return subestPro;
    }
}
