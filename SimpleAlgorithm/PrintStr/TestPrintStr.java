/**
 * @ClassName: TestPrintStr
 * @Description: 算法测试
 * @Author: 余霜
 * @Date: 2021/03/04 20:45
 * @Version: V1.0
 **/
public class TestPrintStr {
    public static void main(String[] args) {
        PrintStr printStr = new PrintStr();

        String str = "abcdefghigklmn123456789!@#$";
        System.out.println(str);
        printStr.printStr(str);
        System.out.println();
        printStr.printStr1(str);
        printStr.printStr2(str);
        System.out.println();
        System.out.println(printStr.printStr3(str));
        System.out.println(printStr.printStr4(str));

    }
}
