import java.util.Stack;

/**
 * @ClassName: AddTwoNumbers_D
 * @Description: 两数相加 II
 * @Author: 余霜
 * @Date: 2020/04/14 18:18
 * @Version: V1.0
 *
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

// 这题思路和我原文件夹的两数相加思想一样，不过这题难了一丢丢，并且这次的代码写的比较好
// 这题不允许改变链表，并且数值是正序的，也就是正常读法，比如2->3->4->5就是两千三百四十五
// 而加和一定是从最后一位算起，因为不知道有没有进位，有了这个想法题目就简单多了
// 两种方法，第一种最笨的，先跑一遍两个，算出长度，然后一个一个从后往前取(有这想法还能把这个写出来我觉得也算是条汉子，盲猜超时)
// 再不就是想法子把链表变成别的结构，有了这个想法，自然想到了栈！栈！！好东西啊，正好计算的顺序是倒叙
// 那么遍历一遍取出来，在用的时候就是正确的顺序，接下来就是循环赋值了，记得这里要用头插法哦，学过数据结构的应该都会
// 如果不会的话何以关注一下作者的数据结构库https://github.com/H-Always/DataStructure-Repository，(不了解请务必看一看QAQ)
/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers_D {
    public ListNode addTwoNumbers_D(ListNode l1, ListNode l2){
        //两个栈，存放数据
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1!=null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;

        int cur = 0; // 当前值
        int byt = 0; // 当前进位

        //在还有数据或者进位不为0的时候进入循环
        while (!stack1.empty()||!stack2.empty()||byt!=0){
            cur += byt;
            cur += !stack1.empty() ? stack1.pop() : 0;
            cur += !stack2.empty() ? stack2.pop() : 0;

            ListNode test = new ListNode(cur%10);

            test.next = head;
            head = test;

            byt = cur/10;
            cur=0;


        }

        return head;

    }

}
