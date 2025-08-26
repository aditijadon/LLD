package com.example.design.LRU;

public class Driver {
    public static void main(String[] args) {
        // Create an LRU Cache with capacity 2
        LRUCache cache = new LRUCache(2);

        // Demo operations
        System.out.println("Put (1, 1)");
        cache.put(1, 1); // Cache: {1=1}, List: head <-> 1 <-> tail
        System.out.println("Put (2, 2)");
        cache.put(2, 2); // Cache: {1=1, 2=2}, List: head <-> 2 <-> 1 <-> tail
        System.out.println("Get 1: " + cache.get(1)); // Returns 1, List: head <-> 1 <-> 2 <-> tail
        System.out.println("Put (3, 3)");
        cache.put(3, 3); // Evicts key 2, Cache: {1=1, 3=3}, List: head <-> 3 <-> 1 <-> tail
        System.out.println("Get 2: " + cache.get(2)); // Returns -1 (not found)
        System.out.println("Put (4, 4)");
        cache.put(4, 4); // Evicts key 1, Cache: {4=4, 3=3}, List: head <-> 4 <-> 3 <-> tail
        System.out.println("Get 1: " + cache.get(1)); // Returns -1 (not found)
        System.out.println("Get 3: " + cache.get(3)); // Returns 3, List: head <-> 3 <-> 4 <-> tail
        System.out.println("Get 4: " + cache.get(4)); // Returns 4, List: head <-> 4 <-> 3 <-> tail
    }
}
