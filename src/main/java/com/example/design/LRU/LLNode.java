package com.example.design.LRU;

public class LLNode {
    int key;
    int value;
    LLNode prev;
    LLNode next;

    LLNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
