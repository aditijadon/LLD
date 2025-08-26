package com.example.design.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashmapTest {
    private MyHashMap<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new MyHashMap<>();
    }

    // Test 1: Put and get a single key-value pair
    @Test
    void testPutAndGet() {
        map.put("A", 1);
        assertEquals(1, map.get("A"), "Should retrieve the correct value for key A");
        assertEquals(1, map.size(), "Size should be 1 after adding one entry");
    }

    // Test 2: Update value for existing key
    @Test
    void testUpdateValue() {
        map.put("A", 1);
        map.put("A", 2);
        assertEquals(2, map.get("A"), "Should update value for existing key A");
        assertEquals(1, map.size(), "Size should remain 1 after updating");
    }

    // Test 3: Handle null key
    @Test
    void testNullKey() {
        map.put(null, 0);
        assertEquals(0, map.get(null), "Should retrieve value for null key");
        assertEquals(1, map.size(), "Size should be 1 after adding null key");
    }

    // Test 4: Test containsKey
    @Test
    void testContainsKey() {
        map.put("A", 1);
        assertTrue(map.containsKey("A"), "Should return true for existing key A");
        assertFalse(map.containsKey("B"), "Should return false for non-existing key B");
    }

    // Test 5: Test remove
    @Test
    void testRemove() {
        map.put("A", 1);
        map.put("B", 2);
        assertEquals(1, map.remove("A"), "Should return removed value for key A");
        assertNull(map.get("A"), "Key A should be removed");
        assertEquals(1, map.size(), "Size should be 1 after removing one entry");
    }

    // Test 6: Remove non-existing key
    @Test
    void testRemoveNonExistingKey() {
        assertNull(map.remove("A"), "Removing non-existing key should return null");
        assertEquals(0, map.size(), "Size should remain 0");
    }

    // Test 7: Test collisions (multiple keys hashing to same index)
    @Test
    void testCollisionHandling() {
        // Assuming keys "A" and "B" hash to the same index (depends on hash function)
        map.put("A", 1);
        map.put("B", 2);
        assertEquals(1, map.get("A"), "Should retrieve correct value for key A");
        assertEquals(2, map.get("B"), "Should retrieve correct value for key B");
        assertEquals(2, map.size(), "Size should be 2 after adding two entries");
    }

    // Test 8: Test resizing
    @Test
    void testResize() {
        // Add enough entries to trigger resize (load factor 0.75, initial capacity 16)
        for (int i = 0; i < 12; i++) { // 12 entries > 16 * 0.75
            map.put("Key" + i, i);
        }
        assertEquals(12, map.size(), "Size should be 12 after adding entries");
        for (int i = 0; i < 12; i++) {
            assertEquals(i, map.get("Key" + i), "Should retrieve correct value for Key" + i);
        }
    }

    // Test 9: Test empty map
    @Test
    void testEmptyMap() {
        assertEquals(0, map.size(), "Size should be 0 for empty map");
        assertNull(map.get("A"), "Get on empty map should return null");
        assertFalse(map.containsKey("A"), "ContainsKey should return false for empty map");
    }

    // Test 10: Test put and remove multiple entries
    @Test
    void testPutAndRemoveMultiple() {
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        assertEquals(3, map.size(), "Size should be 3 after adding three entries");
        assertEquals(2, map.remove("B"), "Should remove key B");
        assertNull(map.get("B"), "Key B should be removed");
        assertEquals(1, map.get("A"), "Key A should still exist");
        assertEquals(3, map.get("C"), "Key C should still exist");
        assertEquals(2, map.size(), "Size should be 2 after removal");
    }
}