/**
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 *
 * Example 2:
 *
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       [1,2,3,3,4,4,5]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._82

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
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val dummy = ListNode(-1)
        dummy.next = head

        var p: ListNode = dummy
        var m: ListNode? = p.next
        var n: ListNode? = m?.next
        var deleteM = false
        while (m != null && n != null) {
            when {
                m.value == n.value -> {
                    m.next = n.next
                    n = n.next
                    deleteM = true
                }
                deleteM -> {
                    deleteM = false
                    p.next = m.next
                    m = m.next
                    n = m?.next
                }
                else -> {
                    p = m
                    m = n
                    n = n.next
                }
            }
        }

        if (deleteM) {
            p.next = m?.next
        }

        return dummy.next
    }

}