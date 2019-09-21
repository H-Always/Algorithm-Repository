package AlgorithmPackge;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName TestAlgorithm
 * @Description: TODO 这是所有方法的入口
 * @Author 余霜
 * @Version V1.0
 **/

public class TestAlgorithm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("链表长度: ");
        int length = scan.nextInt();
        //头节点,不存放信息
        LinkNode head = new LinkNode(-1);

        LinkNode temp = head;

        //创建链表循环赋值，
        for (int i = 0; i < length; i++) {
            System.out.println("第" + (i + 1) + "个节点元素值: ");
            int value = scan.nextInt();
            LinkNode node = new LinkNode(value);
            temp.addToNode(node);
            temp = node;
        }

        System.out.println("初始链表:");

        head.toString(head);

        DeleteLinkListDuplicateNode ys = new DeleteLinkListDuplicateNode();

        System.out.println();
        System.out.println("删除重复节点之后的链表:");

        head.toString(ys.deleteLinkListDuplicateNode(head));

    }

}
