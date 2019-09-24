package AlgorithmPackge;

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

        //创建链表循环赋值
        System.out.println("链表长度: ");
        int length = scan.nextInt();

        System.out.println("第" + 1 + "个节点元素值: ");
        int value = scan.nextInt();
        LinkNode head = new LinkNode(value);

        LinkNode temp = head;

        for (int i = 0; i < length - 1; i++) {
            System.out.println("第" + (i + 2) + "个节点元素值: ");
            value = scan.nextInt();
            LinkNode node = new LinkNode(value);
            temp.addToNode(node);
            temp = node;
        }

        System.out.println("初始链表:");

        head.toString(head);

        ReverseLinkList ys = new ReverseLinkList();
        System.out.println();
        head.toString(ys.reverseLinkList(head, 1, 4));

    }
}
