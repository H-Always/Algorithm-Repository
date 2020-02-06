/**
 * @ClassName ReverseLinkList
 * @Description: TODO 反转链表
 * @Author 余霜
 * @Date 2019/9/24
 * @Version V1.0
 **/

/**
 * 给定一个链表，反转从m到n位置
 * 你不能直接更改值，而是要真正的反转节点
 * 1<=n<=m<=链表长度
 * 例如1->2->3->4->5->6->null  m = 2,n = 6
 * 反转之后1->6->5->4->3->2-null
 * 最好在时间复杂度O(n)下完成
 */

/*
public class ListNode {
    //Definition for singly-linked list.
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
}
 */

public class ReverseLinkList {
    public ListNode reverseLinkList(ListNode node, int m, int n) {

        if (node.next == null || m == n)
            return node;

        //这里声明一个空位置是为了方便反转，如果m=1的话就需要一个前驱节点来控制反转
        ListNode head = new ListNode(0);
        head.next = node;
        ListNode front = head;
        //判断反转的起始位置，这个位置节点是反转开始的前一个节点
        for (int i = 0; i < m - 1; i++) {
            front = front.next;
        }
        //开始的节点和临时控制反转的节点
        ListNode start = front.next;
        ListNode temp = start.next;

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
