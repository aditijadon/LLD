package com.example.design.licious.model;

public class Node {
    public int key;
    public int value;
    public Node prev;
    public Node next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
//        this.prev = null;
//        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
//                ", prev=" + prev +
                ", next=" + next +
                '}';
    }
}
