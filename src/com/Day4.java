package com;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: WangGguo
 * @Description:
 * @Date: Created in 10:41 下午 2020/7/20
 * @Modified By:
 */
public class Day4 {
    //后继节点可以理解为中序遍历的下一个节点
    //某个节点存在右子树，后继节点就是右子树最左边一个节点
    //某个节点不存在右子树，则寻找当前节点之前的某个节点，这个节点的左子树是以当前节点结尾
    public static void main(String[] args) {

    }

    //反序列化
    public static Node recondByPreString(String pre){
        String[] values = pre.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return recondPreOrder(queue);
    }

    public static Node recondPreOrder(Queue<String> queue){
        String value = queue.poll();
        if ("#".equals(value)){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = recondPreOrder(queue);
        head.right = recondPreOrder(queue);
        return head;
    }

    //序列化和反序列化
    public static String serialByPre(Node head){
        if (head == null){
            return "#!";
        }
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;

    }

    public static class Node {
        public Node parent;
        public Node left;
        public Node right;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node) {
        if (node == null) {
            return node;
        }
        if (node.left != null) {
            node = node.left;
        }
        return node;
    }


}
