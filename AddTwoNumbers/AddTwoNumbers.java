/**
 * @ClassName AddTwoNumbers
 * @Description: 两数之和
 * @Author 余霜
 * @Date 2019/12/17 21:32
 * @Version V1.0
 **/

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

