import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: IsolationTest
 * @Description: 算法测试
 * @Author: 余霜
 * @Date: 2020/05/08 12:37
 * @Version: V1.0
 **/
public class IsolationTest {
    public static void main(String[] args) {

        Isolation ys = new Isolation();

        List<List<Integer>> lists = new ArrayList<>();


        List<Integer> list1 = new ArrayList<>(Arrays.asList(100,4));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(2,1,2));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(5,10,13,2,12,14));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(2,0,1));
        List<Integer> list5 = new ArrayList<>(Arrays.asList(2,99,2));



        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        lists.add(list5);

        System.out.println(ys.isolation(lists));




    }
}
