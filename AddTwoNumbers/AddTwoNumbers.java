/**
 * @ClassName AddTwoNumbers
 * @Description: 两数相加
 * @Author 余霜
 * @Date 2019/12/17 21:32
 * @Version V1.0
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

/*
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //开一个新链表
        ListNode head = new ListNode(0);
        ListNode res = head;
        //用来存储进位
        int byt = 0;
        //用来储存当前位的数字
        int num;

        while (l1 != null || l2 != null) {
            //创建一个新节点，存当前计算出来的位数
            ListNode p = new ListNode(0);

            //加和所需的数字
            int value_1 = l1 != null ? l1.val : 0;
            int value_2 = l2 != null ? l2.val : 0;

            //用10取余数当作这一位，除10当作下一位的进位
            num = (value_1 + value_2 + byt) % 10;
            byt = (value_1 + value_2 + byt) / 10;

            //插入链表
            p.val = num;
            p.next = res.next;
            res.next = p;
            res = res.next;

            //链表往下走
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        //遍历完之后如果有余数，就证明还要再加一位
        //比如5，5，当前位就是0，但是进位是1，就要加一位新的
        if (byt != 0) {
            res.next = new ListNode(1);
        }

        //因为头节点不存东西，返回下一个节点
        return head.next;
    }
}

