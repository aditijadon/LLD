package com.example.design.hashmap;

public class MyHashmap<K, V> {
    private MapNode<K, V>[] table; // Array of linked lists
    private int size; // Number of key-value pairs
    private static final int INITIAL_CAPACITY = 16; // Initial table size
    private static final float LOAD_FACTOR = 0.75f; // Load factor threshold

    // Constructor
    @SuppressWarnings("unchecked")
    public MyHashmap() {
        table = (MapNode<K, V>[]) new MapNode[INITIAL_CAPACITY];
        size = 0;
    }

    // Hash function to compute index
    private int hash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode() % table.length);
    }

    // Put a key-value pair into the map
    public V put(K key, V value) {
        if (size >= table.length * LOAD_FACTOR) {
            resize();
        }

        int index = hash(key);
        MapNode<K, V> node = table[index];

        // If bucket is empty, create new node
        if (node == null) {
            table[index] = new MapNode<>(key, value, null);
            size++;
            return null;
        }

        // Traverse the linked list at the index
        MapNode<K, V> prev = null;
        while (node != null) {
            if ((node.key == null && key == null) ||
                    (node.key != null && node.key.equals(key))) {
                V oldValue = node.value;
                node.value = value; // Update value
                return oldValue;
            }
            prev = node;
            node = node.next;
        }

        // Add new node at the end of the list
        prev.next = new MapNode<>(key, value, null);
        size++;
        return null;
    }

    // Get value for a key
    public V get(K key) {
        int index = hash(key);
        MapNode<K, V> node = table[index];

        while (node != null) {
            if ((node.key == null && key == null) ||
                    (node.key != null && node.key.equals(key))) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    // Remove a key-value pair
    public V remove(K key) {
        int index = hash(key);
        MapNode<K, V> node = table[index];
        MapNode<K, V> prev = null;

        while (node != null) {
            if ((node.key == null && key == null) ||
                    (node.key != null && node.key.equals(key))) {
                V oldValue = node.value;
                if (prev == null) {
                    table[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return oldValue;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    // Check if key exists
    public boolean containsKey(K key) {
        int index = hash(key);
        MapNode<K, V> node = table[index];

        while (node != null) {
            if ((node.key == null && key == null) ||
                    (node.key != null && node.key.equals(key))) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    // Get size of the map
    public int size() {
        return size;
    }

    // Resize the table when load factor is exceeded
    @SuppressWarnings("unchecked")
    private void resize() {
        MapNode<K, V>[] oldTable = table;
        table = (MapNode<K, V>[]) new MapNode[oldTable.length * 2];
        size = 0;

        // Rehash all entries
        for (MapNode<K, V> node : oldTable) {
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }
}
