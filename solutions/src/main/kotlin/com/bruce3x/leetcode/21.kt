/**
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 *
 *
 * Difficulty:     Easy
 * TestCase:       [1,2,4], [1,3,4]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._21

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
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var p1 = l1
        var p2 = l2
        var tail = dummy
        while (p1 != null && p2 != null) {
            val next: ListNode
            if (p1.value <= p2.value) {
                next = p1
                p1 = p1.next
            } else {
                next = p2
                p2 = p2.next
            }

            tail.next = next
            tail = next
        }

        if (p1 != null) {
            tail.next = p1
        }
        if (p2 != null) {
            tail.next = p2
        }

        return dummy.next
    }
}