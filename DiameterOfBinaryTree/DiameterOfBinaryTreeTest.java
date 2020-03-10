/**
 * @ClassName: DiameterOfBinaryTreeTest
 * @Description: 算法测试
 * @Author: 余霜
 * @Date: 2020/03/10 08:47
 * @Version: V1.0
 **/
public class DiameterOfBinaryTreeTest {
    public static void main(String[] args) {
        TreeNode ys1 = new TreeNode(1);
        TreeNode ys2 = new TreeNode(1);
        TreeNode ys3 = new TreeNode(1);
        TreeNode ys4 = new TreeNode(1);
        TreeNode ys5 = new TreeNode(1);
        TreeNode ys6 = new TreeNode(1);
        TreeNode ys7 = new TreeNode(1);
        TreeNode ys8 = new TreeNode(1);

        ys1.left = ys2;
        ys1.right = ys3;
        ys2.left = ys4;
        ys2.right = ys5;
        ys5.left = ys6;

        DiameterOfBinaryTree ys = new DiameterOfBinaryTree();

        System.out.println(ys.diameterOfBinaryTree(ys1));


    }
}
