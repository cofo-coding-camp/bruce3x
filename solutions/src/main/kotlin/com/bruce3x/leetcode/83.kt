/**
 * [83] Remove Duplicates from Sorted List
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 *
 * Input: 1->1->2
 * Output: 1->2
 *
 *
 * Example 2:
 *
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 *
 *
 * Difficulty:     Easy
 * TestCase:       [1,1,2]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._83

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
        var p: ListNode? = head
        var q: ListNode? = p?.next
        while (p != null && q != null) {
            if (p.value == q.value) {
                p.next = q.next
                q = q.next
            } else {
                p = p.next
                q = p?.next
            }
        }

        return head
    }

    fun deleteDuplicates2(head: ListNode?): ListNode? {
        val set = HashSet<Int>()
        var p = head

        val dummy = ListNode(-1)
        var q = dummy

        while (p != null) {
            val v = p.value
            if (set.contains(v).not()) {
                set.add(v)
                val node = ListNode(v)
                q.next = node
                q = node
            }
            p = p.next
        }

        return dummy.next
    }
}