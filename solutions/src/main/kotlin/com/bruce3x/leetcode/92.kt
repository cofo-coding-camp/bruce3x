/**
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       [1,2,3,4,5], 2, 4
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._92

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
    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        if (head == null || m >= n) return head

        val leftHead = ListNode(0)
        leftHead.next = head
        val leftTail = findNodeAt(leftHead, m - 1)
        val midTail = findNodeAt(leftHead, n)

        var midHead = leftTail?.next
        var rightHead = midTail?.next

        if (leftTail == null || midTail == null || midHead == null ) {
            throw IllegalArgumentException("invalid arguments")
        }

        leftTail.next = null
        midTail.next = null

        var node: ListNode
        while (midHead != null) {
            node = midHead
            midHead = midHead.next

            node.next = rightHead
            rightHead = node
        }

        leftTail.next = rightHead

        return leftHead.next
    }

    private fun findNodeAt(head: ListNode, position: Int): ListNode? {
        var node: ListNode = head
        repeat(position) {
            val next = node.next
            if (next == null) {
                return null
            } else {
                node = next
            }
        }
        return node
    }
}