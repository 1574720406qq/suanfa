package com;


import java.util.Stack;

/**
 * @Author: WangGguo
 * @Description:
 * @Date: Created in 7:48 上午 2020/7/14
 * @Modified By:
 */
public class Day3 {
    public void preOrder(Node head){
        if (head == null){
            return;
        }
        System.out.println(head.value);
        preOrder(head.left);
        preOrder(head.right);

    }

    public void inOrder(Node head){
        if (head == null){
            return;
        }
        inOrder(head.left);
        System.out.println(head.value);
        inOrder(head.right);
    }

    public void postOrder(Node head){
        if (head == null){
            return;
        }
        postOrder(head.left);
        preOrder(head.right);
        System.out.println(head.value);
    }

    public void proOrderRecu(Node head){
        if (head  == null){
            return;
        }
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.value);
                if (head.right != null){
                    stack.push(head.left);
                }
                if (head.left != null){
                    stack.push(head.right);
                }
            }
        }
        System.out.println();
    }

    public void inOrderUnRecur(Node head){
        System.out.println();
        if (head != null){
            Stack<Node> stack = new Stack<>();
            while (head!=null || !stack.isEmpty()){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.println(head.value);
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public void postOrderUnRecur(Node head){
        System.out.println();
        if (head != null){
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if (head.left != null) s1.push(head.left);
                if (head.right != null) s1.push(head.right);
            }
            while (!s2.isEmpty()){
                System.out.println(s2.pop().value);
            }
        }
    }

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value = value;
        }
    }
}



