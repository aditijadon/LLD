package com.example.design.hashmap;

public class MapNode<K,V> {
    K key;
    V value;
    MapNode<K, V> next;

    MapNode(K key, V value, MapNode<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
