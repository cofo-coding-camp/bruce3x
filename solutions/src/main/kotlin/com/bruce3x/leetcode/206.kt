/**
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 *
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 *
 * Difficulty:     Easy
 * TestCase:       [1,2,3,4,5]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._206

import com.bruce3x.leetcode.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? = reverseIteratively(head)

    fun reverseRecursively(head: ListNode?): ListNode? {
        if (head == null) return head

        var tail: ListNode = head
        var next = tail.next
        while (next != null) {
            tail = next
            next = next.next
        }
        return reverseRecursively(head, tail)
    }

    private fun reverseRecursively(head: ListNode, tail: ListNode): ListNode {
        if (head == tail) return head
        val next = head.next ?: return head
        val ret = reverseRecursively(next, tail)
        next.next = head
        head.next = null
        return ret
    }

    fun reverseIteratively(head: ListNode?): ListNode? {
        val dummy = ListNode(0)

        var cur: ListNode? = head
        while (cur != null) {
            val next = cur.next

            cur.next = dummy.next
            dummy.next = cur

            cur = next
        }

        return dummy.next
    }
}