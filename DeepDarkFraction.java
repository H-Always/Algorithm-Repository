package AlgorithmPackge;
/**
 * @ClassName DeepDarkFraction
 * @Description: TODO 分式化简
 * @Author 余霜
 * @Date 2019/9/25
 * @Version V1.1
 **/
public class DeepDarkFraction {
    public static int[] deepDarkFraction(int[] cont) {
        int length = cont.length;
        //分子为1 因为默认的取最后一个数，当然是几分之一
        int a = 1;
        //分母
        int b = cont[length - 1];
        //计算的时候是一个整数加上一个分数，所以分母是原来分子加上整数*分母
        //然后翻转，变成倒数，继续运算
        //这里注意，运算完的结果一定多执行了一次反转，最后要翻转回来
        for (int j = length - 2; j >= 0; j--) {
            a += b * cont[j];
            a ^= b;
            b ^= a;
            a ^= b;
        }

        //因为是化简，所以要除以最大公约数
        int c = gcd(a, b);
        a /= c;
        b /= c;

        return new int[]{b, a};
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
