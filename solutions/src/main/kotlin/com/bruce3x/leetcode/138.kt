/**
 * [138] Copy List with Random Pointer
 *
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/description/
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 *
 *
 * Example 1:
 *
 *
 *
 *
 * Input:
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 *
 *
 *
 *
 * Note:
 *
 *
 * You must return the copy of the given head as a reference to the cloned list.
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._138


class Node {
    var value: Int = 0
    var next: Node? = null
    var random: Node? = null
}

class Solution {
    fun copyRandomList(head: Node?): Node? {
        if (head == null) return head

        var current: Node? = head
        // copy nodes
        while (current != null) {
            val node = Node()
            node.value = current.value
            node.next = current.next

            current.next = node
            current = node.next
        }

        current = head

        // copy random point
        while (current != null) {
            current.next?.random = current.random?.next
            current = current.next?.next
        }

        current = head
        var next: Node? = head.next
        val ret = next
        while (current != null) {
            current.next = current.next?.next
            current = current.next

            next?.next = next?.next?.next
            next = next?.next
        }

        return ret
    }
}

