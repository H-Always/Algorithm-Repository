/**
 * @ClassName: MiddleNodeTest
 * @Description: 算法测试
 * @Author: 余霜
 * @Date: 2020/03/23 08:58
 * @Version: V1.0
 **/
public class MiddleNodeTest {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode ys1 = new ListNode(1);
        ListNode ys2 = new ListNode(2);
        ListNode ys3 = new ListNode(3);
        ListNode ys4 = new ListNode(4);
        ListNode ys5 = new ListNode(5);
        ListNode ys6 = new ListNode(6);
        ListNode ys7 = new ListNode(7);
        ListNode ys8 = new ListNode(8);
        ListNode ys9 = new ListNode(9);
        ListNode ys10 = new ListNode(10);
        ListNode ys11 = new ListNode(11);
        ListNode ys12 = new ListNode(12);

        head.next = ys1;
        ys1.next = ys2;
        ys2.next = ys3;
        ys3.next = ys4;
        ys4.next = ys5;
        ys5.next = ys6;
        ys6.next = ys7;
        ys7.next = ys8;
        ys8.next = ys9;
        ys9.next = ys10;
        ys10.next = ys11;
        ys11.next = ys12;

        ListNode cur = head;
        while (cur!=null){
            System.out.print(cur.val+"\t");
            cur = cur.next;
        }

        MiddleNode ys = new MiddleNode();

        System.out.println(ys.middleNode(head).val);
    }
}
