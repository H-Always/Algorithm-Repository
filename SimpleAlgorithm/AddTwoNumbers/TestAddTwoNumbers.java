/**
 * @ClassName: TestAddTwoNumbers
 * @Description: 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:17
 * @Version: 1.0
 */
public class TestAddTwoNumbers {
    public static void main(String[] args) {
        ListNode ys1 = new ListNode(7);
        ListNode ys2 = new ListNode(2);
        ListNode ys3 = new ListNode(4);
        ListNode ys7 = new ListNode(3);
        ys1.next = ys2;
        ys2.next = ys3;
        ys3.next = ys7;
        ListNode ys4 = new ListNode(5);
        ListNode ys5 = new ListNode(6);
        ListNode ys6 = new ListNode(4);
        ys4.next = ys5;
        ys5.next = ys6;

        AddTwoNumbers ys = new AddTwoNumbers();
        ListNode res = ys.addTwoNumbers(ys1, ys4);
        while (res!= null) {
            System.out.println(res.val);
            res = res.next;
        }
        System.out.println();
        AddTwoNumbers_D ys0 = new AddTwoNumbers_D();
        ListNode head = ys0.addTwoNumbers_D(ys1, ys4);
        while (head!= null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}
