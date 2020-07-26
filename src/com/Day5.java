package com;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: WangGuo
 * @Description:
 * @Date: Created in 9:54 下午 2020/7/24
 * @Modified By:
 */
public class Day5 {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int val){
            this.value = val;
        }
    }

    public static class ReturnData {
        public boolean isB;
        public int h;

        public ReturnData(boolean isB, int h) {
            this.isB = isB;
            this.h = h;
        }
    }

    public static boolean isB(Node head){
        return process(head).isB;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        head.left = node3;
        head.right = node4;
        node3.left = node2;
        node4.left = node1;
        node2.right = node5;
        boolean isBST = isB(head);
        System.out.println(isBST);
    }

    //判断是否为BST
    public static boolean isBST(Node head){
        int pre = Integer.MIN_VALUE;
        if (head != null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    if (head.value < pre){
                        return false;
                    }
                    pre = head.value;
                    head = head.right;
                }

            }
        }
        return true;
    }

    public static ReturnData process(Node head){
        if (head == null){
            return new ReturnData(true,0);
        }
        ReturnData nodeLeft = process(head.left);
        if (!nodeLeft.isB){
            return new ReturnData(false,0);
        }
        ReturnData nodeRight = process(head.right);
        if (!nodeRight.isB){
            return new ReturnData(false,0);
        }
        if (Math.abs(nodeLeft.h - nodeRight.h) > 1){
            return new ReturnData(false,0);
        }
        return new ReturnData(true,Math.max(nodeLeft.h,nodeRight.h) + 1);
    }

}
