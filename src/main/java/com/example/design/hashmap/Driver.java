package com.example.design.hashmap;

public class Driver {
    public static void main(String[] args) {
        MyHashmap<String, Integer> map = new MyHashmap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        System.out.println("Size: " + map.size()); // Output: Size: 3
        System.out.println("Get A: " + map.get("A")); // Output: Get A: 1
        System.out.println("Contains B: " + map.containsKey("B")); // Output: Contains B: true
        System.out.println("Remove B: " + map.remove("B")); // Output: Remove B: 2
        System.out.println("Size after remove: " + map.size()); // Output: Size after remove: 2
        System.out.println("Contains B: " + map.containsKey("B")); // Output: Contains B: false
    }
}
