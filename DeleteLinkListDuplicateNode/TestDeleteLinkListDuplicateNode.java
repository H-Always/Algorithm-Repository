/**
 * @ClassName: TestDeleteLinkListDuplicateNode
 * @Description: TODO
 * @Author: 余霜
 * @date: 2020/2/6/17:25
 * @Version: 1.0
 */
public class TestDeleteLinkListDuplicateNode {
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

        DeleteLinkListDuplicateNode ys = new DeleteLinkListDuplicateNode();

        ListNode head = ys.deleteLinkListDuplicateNode(node1);


        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}
