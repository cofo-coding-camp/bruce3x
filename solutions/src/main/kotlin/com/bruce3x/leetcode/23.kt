/**
 * [23] Merge k Sorted Lists
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 *
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 *
 *
 * Difficulty:     Hard
 * TestCase:       [[1,4,5],[1,3,4],[2,6]]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._23

import com.bruce3x.leetcode.ListNode
import kotlin.math.ceil

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
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {

        var size = lists.size
        while (size > 1) {
            merge(lists, size - 1)
            size = ceil(size / 2f).toInt()
        }

        return lists.getOrNull(0)
    }

    private fun merge(lists: Array<ListNode?>, end: Int) {
        var left = 0
        var right = end
        while (left < right) {
            lists[left] = mergeTwoLists(lists[left], lists[right])
            left++
            right--
        }
    }

    private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
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