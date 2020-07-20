package com;

/**
 * @Author: WangGguo
 * @Description:
 * @Date: Created in 11:56 下午 2020/7/9
 * @Modified By:
 */
public class Day1 {
    public static Node reverseSingleLinked(Node node){
        Node pre = null;
        Node cur = node;
        Node next = null;
        while (node != null){
            cur.next = pre;
            next = cur.next;
            pre =cur;
            cur = next;
        }
        return pre;
    }
    public static class Node{
        public int value;
        public Node next;

    }
}

