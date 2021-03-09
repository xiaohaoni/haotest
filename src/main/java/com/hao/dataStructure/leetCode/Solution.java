package com.hao.dataStructure.leetCode;

import java.util.Stack;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。  请你将两个数相加，并以相同形式返回一个表示和的链表。  你可以假设除了数字 0 之外，这两个数都不会以 0 开头。     来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zrh
 * @version 1.0
 * @date 2021-03-08 12:45
 **/
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));

        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        //   ListNode l3 = new ListNode();
        // System.out.println(l3.val);
        addTwoNumbers1(l1, l2);
        System.out.println();
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNodeList listNodeList = new ListNodeList();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1.next != null) {
            stack1.push(l1.val);
            l1 = l1.next;
            if (l1.next == null) {
                stack1.push(l1.val);
            }
        };

        while (l2.next != null) {
            stack2.push(l2.val);
            l2 = l2.next;
            if (l2.next == null) {
                stack2.push(l2.val);
            }
        }
        ;

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        while (stack1.size() > 0) {
            str1.append(stack1.pop());
        }
        while (stack2.size() > 0) {
            str2.append(stack2.pop());
        }
        int i1 = Integer.parseInt(str1.toString());
        int i2 = Integer.parseInt(str2.toString());

        if (str1.length() > str2.length()) {
            i2 = i2 * (int) Math.pow(10, str1.length() - str2.length());
        } else {
            i1 = i1 * (int) Math.pow(10, str1.length() - str2.length());
        }
        String sum = (i1 + i2) + "";
        char[] arr = sum.toCharArray();
        ListNode result = new ListNode();
        for (char c : arr) {

        }
        return result;
    }



    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    public static ListNode add(ListNode l1, ListNode l2, int z) {
        if (l1 == null && l2 == null && z == 0) {
            return null;
        }
        if (l1 == null) {
            l1 = new ListNode(0);
        }
        if (l2 == null) {
            l2 = new ListNode(0);
        }
        int value = l1.val + l2.val + z;
        ListNode result = new ListNode(value % 10);
        result.next = add(l1.next, l2.next, value / 10);
        System.out.println(result);
        return result;
    }

    ListNode head = new ListNode(0);

}


class ListNodeList {
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private ListNode head = new ListNode(0);


    //返回头节点
    public ListNode getHead() {
        return head;
    }

    public void add(ListNode heroNode) {

        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        ListNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {//
                break;
            }
            //如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = heroNode;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
