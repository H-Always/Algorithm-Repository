/**
 * @ClassName: Test
 * @Description: 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:18
 * @Version: 1.0
 */
public class TestCanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1,0,0,0,1,0,1,0};
        int a = 3;

        CanPlaceFlowers ys = new CanPlaceFlowers();
        System.out.println(ys.canPlaceFlowers(flowerbed,a));
    }
}
