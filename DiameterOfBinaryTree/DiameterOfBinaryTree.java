/**
 * @ClassName: DiameterOfBinaryTree
 * @Description: 二叉树的直径
 * @Author: 余霜
 * @Date: 2020/03/10 08:41
 * @Version: V1.0
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

//思路：先找到最长的一条分支的最后一个节点，以该节点为根向上查找(这个思路典型的递归)
//首先遍历树，左不为空向左走，作为空向右走，递归下去就能遍历到分支最长的最后一个节点
//递归完事之后开始往回走，把最后一个节点当作根节点(这个根和树的根节点不一样)，然后左子树和右子树比较，取分支较长的一个
//判断更新全局变量最大半径，这个值是lift+right+1，注意一点！最大半径不一定经过根节点！！任意两点距离最大！！！
//最后遍历完所有节点，返回值

    //一定注意，最长大径不一定经过根节点

    /*
    //Definition for a binary tree node.
    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {val = x;}
    }
     */


public class DiameterOfBinaryTree {
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }

    public int depth(TreeNode node) {

        //如果节点为空，返回零，其中一个出口
        if (node == null) return 0;

        //这两行第一遍执行值遍历到最长分支节点，因为最大直径必定经过最长分支最后一个节点
        //之后的作用是当前分支长度
        int L = depth(node.left);
        int R = depth(node.right);

        //更新最大值，左子树最大深度+右子树最大深度和原来的比
        maxDiameter = Math.max(maxDiameter, L+R);
        // 返回该节点为根的子树的深度，第一次返回的时候一定是最长分支最后一个节点，他的左右子树都为空，但是深度为1
        return Math.max(L, R) + 1;
    }

}
