package com.example.design.LRU;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {
    private LRUCache cache;

    @BeforeEach
    void setUp() {
        cache = new LRUCache(2); // Initialize with capacity 2 for each test
    }

    @Test
    void testGetNonExistentKey() {
        assertEquals(-1, cache.get(1), "Should return -1 for non-existent key");
    }

    @Test
    void testPutAndGetSingleItem() {
        cache.put(1, 1);
        assertEquals(1, cache.get(1), "Should return the value for key 1");
    }

    @Test
    void testPutMultipleItemsWithinCapacity() {
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1), "Should return 1 for key 1");
        assertEquals(2, cache.get(2), "Should return 2 for key 2");
    }

    @Test
    void testPutExceedsCapacityEvictsLRU() {
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3); // This should evict key 1 (LRU)
        assertEquals(-1, cache.get(1), "Key 1 should be evicted");
        assertEquals(2, cache.get(2), "Key 2 should still be present");
        assertEquals(3, cache.get(3), "Key 3 should be present");
    }

    @Test
    void testUpdateExistingKeyMovesToMRU() {
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 10); // Update key 1, should move to MRU
        cache.put(3, 3); // Should evict key 2 (now LRU)
        assertEquals(10, cache.get(1), "Updated value for key 1 should be 10");
        assertEquals(-1, cache.get(2), "Key 2 should be evicted");
        assertEquals(3, cache.get(3), "Key 3 should be present");
    }

    @Test
    void testEmptyCache() {
        assertEquals(-1, cache.get(1), "Empty cache should return -1");
    }

    @Test
    void testCapacityZero() {
        LRUCache zeroCapacityCache = new LRUCache(0);
        zeroCapacityCache.put(1, 1);
        assertEquals(-1, zeroCapacityCache.get(1), "Cache with capacity 0 should not store any item");
    }
}