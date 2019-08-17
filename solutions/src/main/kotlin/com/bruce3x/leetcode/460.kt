/**
 * [460] LFU Cache
 *
 * https://leetcode-cn.com/problems/lfu-cache/description/
 *
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 *
 *
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 *
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LFUCache cache = new LFUCache( 2 /* capacity */ );
 *
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1); // returns 1
 * cache.put(3, 3); // evicts key 2
 * cache.get(2); // returns -1 (not found)
 * cache.get(3); // returns 3.
 * cache.put(4, 4); // evicts key 1.
 * cache.get(1); // returns -1 (not found)
 * cache.get(3); // returns 3
 * cache.get(4); // returns 4
 *
 *
 *
 * Difficulty:     Hard
 * TestCase:       ["LFUCache","put","put","get","put","get","get","put","get","get","get"], [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._460

class LFUCache(private val capacity: Int) {

    private val nodeCache = HashMap<Int, Node>(capacity)
    private val freqCache = HashMap<Int, FrequencyList>(capacity)
    private var minFreq = 1

    fun get(key: Int): Int {
        val node = nodeCache[key] ?: return -1
        touch(node)
        return node.v
    }

    private fun touch(node: Node) {
        val prevFreq = node.freq
        val freq = (++node.freq)

        freqCache[prevFreq]?.remove(node)
        if (freqCache[prevFreq]?.isEmpty() == true && minFreq == prevFreq) {
            freqCache.remove(prevFreq)
            minFreq++
        }
        val freqList = freqCache[freq] ?: FrequencyList()
        freqCache[freq] = freqList
        freqList.addFirst(node)
    }

    fun put(key: Int, value: Int) {
        if (capacity <= 0) return
        val node = nodeCache[key]
        if (node != null) {
            node.v = value
            touch(node)
            return
        }
        while (nodeCache.size >= capacity && capacity > 0) {
            val evict = freqCache[minFreq]?.removeLast() ?: break
            nodeCache.remove(evict.k)
        }

        val freq = 1
        minFreq = freq

        Node(key, value, freq).let {
            nodeCache[key] = it
            val freqList = (freqCache[freq] ?: FrequencyList())
            freqCache[freq] = freqList
            freqList.addFirst(it)
        }
    }

    private data class Node(val k: Int, var v: Int, var freq: Int) {
        var prev: Node? = null
        var next: Node? = null
    }

    /**
     * 实现双向链表，保证 FrequencyList.remove O(1) 复杂度
     */
    private class FrequencyList {
        private val head: Node = Node(-1, -1, -1)
        private val tail: Node = Node(-2, -2, -2)

        init {
            head.next = tail
            tail.prev = head
        }

        fun isEmpty(): Boolean = head.next == tail

        fun remove(node: Node) {
            val prev = node.prev
            val next = node.next
            node.prev = null
            node.next = null
            prev?.next = next
            next?.prev = prev
        }

        fun addFirst(node: Node) {
            val next = head.next
            next?.prev = node
            node.prev = head
            head.next = node
            node.next = next
        }

        fun removeLast(): Node? {
            if (isEmpty()) return null
            val evict = tail.prev
            val prev = evict?.prev
            prev?.next = tail
            tail.prev = prev
            evict?.prev = null
            evict?.next = null
            return evict
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * var obj = LFUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */