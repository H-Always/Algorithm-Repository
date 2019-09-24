package AlgorithmPackge;
/**
 * @ClassName ReverseLinkList
 * @Description: TODO 反转链表
 * @Author 余霜
 * @Date 2019/9/24
 * @Version V1.0
 **/

public class ReverseLinkList {
    public LinkNode reverseLinkList(LinkNode node, int m, int n) {

        if (node.next == null || node == null || m == n)
            return node;

        //这里声明一个空位置是为了方便反转，如果m=1的话就需要一个前驱节点来控制反转
        LinkNode head = new LinkNode(0);
        head.next = node;
        LinkNode front = head;
        //判断反转的起始位置，这个位置节点是反转开始的前一个节点
        for (int i = 0; i < m - 1; i++) {
            front = front.next;
        }
        //开始的节点和临时控制反转的节点
        LinkNode start = front.next;
        LinkNode temp = start.next;

        //这个是核心算法，主要就是把开始反转的下一个节点放到前面来，就完成了一次反转
        //不懂的同学可以画一画图,看一看怎么反转的
        for (int i = 0; i < n - m; i++) {
            start.next = temp.next;
            temp.next = front.next;
            front.next = temp;
            temp = start.next;
        }
        return head.next;
    }
}
