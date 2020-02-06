import java.util.Arrays;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: 余霜
 * @date: 2020/2/6/17:18
 * @Version: 1.0
 */
public class TestSortColours {
    public static void main(String[] args) {
        int[] colours = {1,2,1,1,0,0,1,2,0,1,2,0,1};
        System.out.println(Arrays.toString(colours));
        SortColours ys = new SortColours();
        ys.sortColours(colours);

        System.out.println(Arrays.toString(colours));
    }
}
