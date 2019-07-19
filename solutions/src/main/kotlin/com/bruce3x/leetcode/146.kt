/**
 * [146] LRU Cache
 *
 * https://leetcode-cn.com/problems/lru-cache/description/
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 *
 * LRUCache cache = new LRUCache( 2 /* capacity */ );
 *
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1); // returns 1
 * cache.put(3, 3); // evicts key 2
 * cache.get(2); // returns -1 (not found)
 * cache.put(4, 4); // evicts key 1
 * cache.get(1); // returns -1 (not found)
 * cache.get(3); // returns 3
 * cache.get(4); // returns 4
 *
 *
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       ["LRUCache","put","put","get","put","get","put","get","get","get"], [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._146

import java.util.*

class LRUCache(private val capacity: Int) {
    private val cache: Deque<Node> = ArrayDeque()
    private val map: MutableMap<Int, Node> = HashMap()

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        cache.remove(node)
        cache.addFirst(node)
        return node.v
    }

    fun put(key: Int, value: Int) {
        map.remove(key)?.let(cache::remove)
        while (cache.size >= capacity) {
            if (cache.isEmpty()) return
            cache.removeLast().run { map.remove(k) }
        }

        Node(key, value).let {
            cache.addFirst(it)
            map[key] = it
        }
    }

    private class Node(val k: Int, val v: Int)
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */