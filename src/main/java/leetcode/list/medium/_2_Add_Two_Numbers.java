package leetcode.list.medium;

/**
 * Created by lenovo on 2019/4/15.
 * 将两个链表中的元素相加，每一位只能存储一个0-9的数
 */
public class _2_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lSum = null;
        ListNode lReturn = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;  // 每一位相加
            int remain = sum % 10;  // 记录低位
            carry = sum / 10; // 记录高位
            ListNode currNode = new ListNode(remain);
            if (lSum != null) {  // 如果是链表的第一个元素
                lSum.next = currNode;
            } else {
                lReturn = currNode;
            }
            lSum = currNode;

            l1 = l1.next; // 往前移动
            l2 = l2.next;
        }

        ListNode remaining = l1 == null ? l2 : l1; // 两个链表中剩余的元素
        if (lSum == null) {  // 如果只有一个链表有值，则直接返回那个链表就可以了
            return remaining;
        }

        lSum.next = remaining;
        ListNode remainPrevious = lSum;
        while (carry != 0 && remaining != null) {  // 对于长度更长的那个元素，不能单纯的加到相加的元素末尾，因为前面相加的元素可能会大于10
            int sum = remaining.val + carry;
            carry = sum / 10;

            remaining.val = sum % 10;
            remainPrevious = remaining;
            remaining = remaining.next;
        }

        if (carry != 0) {  // 如果链表最后的一个元素是超过10的就需要把这个值放到新new出来的ListNode中。
            if (remaining == null) { // 两个链表等长
                remainPrevious.next = new ListNode(carry);
            } else { // 两个链表不等长
                remaining.next = new ListNode(carry);
            }
        }
        return lReturn;
    }

}
