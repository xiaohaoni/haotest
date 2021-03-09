package com.hao.dataStructure.linear.linkedlist;

/**
 * 链表
 *
 * @author zrh
 * @version 1.0
 * @date 2021-03-08 19:55
 **/
public class IntegerListDemo {
    public static void main(String[] args) {
        IntegerList linkList = new IntegerList();
        IntegerNode node = new IntegerNode(1);
        IntegerNode node1 = new IntegerNode(2);
        linkList.add(node);
        linkList.add(node1);
        linkList.list();


    }
}

class IntegerList {
    //定义一个头节点
    private IntegerNode head = new IntegerNode();

    public IntegerNode getHead() {
        return head;
    }

    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点，不能动，因此我们需要一个辅助变量来遍历
        IntegerNode temp = head.next;
        while (true) {
            // 判断是否到链表最后
            if (temp == null) {
                break;
            }
            // 输出节点的信息
            System.out.println(temp);
            // 将temp后移， 一定小心
            temp = temp.next;
        }
    }

    public void add(IntegerNode node) {
        IntegerNode temp = head;

        // 遍历链表，找到最后
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {

                break;
            }
            // 如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向了链表的最后
        temp.next = node;


    }
}

class IntegerNode {
    Integer value;
    IntegerNode next;

    public IntegerNode() {
    }

    public IntegerNode(Integer value) {
        this.value = value;
    }

    public IntegerNode(IntegerNode next) {
        this.next = next;
    }

    public IntegerNode(Integer value, IntegerNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "IntegerNode{" +
                "value=" + value +
                '}';
    }
}
