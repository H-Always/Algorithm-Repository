/**
 * @ClassName: Test
 * @Description: 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:18
 * @Version: 1.0
 */
public class TestRemoveSubfolders {
    public static void main(String[] args) {
       String[] folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        RemoveSubfolders ys = new RemoveSubfolders();

        System.out.println(ys.removeSubfolders(folder));

    }
}
