/**
 * @ClassName: Test
 * @Description: TODO 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:18
 * @Version: 1.0
 */
public class TestReverseLinkList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ReverseLinkList ys = new ReverseLinkList();

        ListNode head = ys.reverseLinkList(node1,1,7);


        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
