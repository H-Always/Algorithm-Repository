/**
 * @ClassName: GcdOfStringsTest
 * @Description: 算法测试
 * @Author: 余霜
 * @Date: 2020/03/12 22:58
 * @Version: V1.0
 **/
public class GcdOfStringsTest {
    public static void main(String[] args) {
        GcdOfStrings ys = new GcdOfStrings();

        String str1 =  "ABABAB", str2 = "ABAB";

        // "TAUXXTAUXXTAUXXTAUXXTAUXX"
        // "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"

        System.out.println(ys.gcdOfStrings(str1,str2));
    }
}
