/**
 * [147] Insertion Sort List
 *
 * https://leetcode-cn.com/problems/insertion-sort-list/description/
 *
 * Sort a linked list using insertion sort.
 *
 *
 *
 *
 *
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 *
 *
 *
 *
 *
 * Algorithm of Insertion Sort:
 *
 *
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 *
 * Example 2:
 *
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       [4,2,1,3]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._147

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
    fun insertionSortList(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var node = head
        var next: ListNode?
        while (node != null) {
            next = node.next
            insert(dummy, node)
            node = next
        }

        return dummy.next
    }

    private fun insert(head: ListNode, node: ListNode) {
        var prev = head
        var next = prev.next
        while (next != null && node.value > next.value) {
            prev = next
            next = prev.next
        }


        prev.next = node
        node.next = next
    }
}