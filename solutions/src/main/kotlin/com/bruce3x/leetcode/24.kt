/**
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *
 *
 * Example:
 *
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       [1,2,3,4]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._24

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
    fun swapPairs(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head

        var prev: ListNode = dummy
        var next: ListNode? = prev.next

        while (next?.next != null) {
            prev.next = next.next
            next.next = prev.next?.next
            prev.next?.next = next

            prev = next
            next = prev.next
        }

        return dummy.next
    }
}