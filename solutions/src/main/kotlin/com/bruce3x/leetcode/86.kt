/**
 * [86] Partition List
 *
 * https://leetcode-cn.com/problems/partition-list/description/
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       [1,4,3,2,5,2], 3
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._86

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

    fun partition(head: ListNode?, x: Int): ListNode? {
        val dummy = ListNode(0)

        var insert: ListNode = dummy
        var tail: ListNode = insert
        var current: ListNode? = head
        var next: ListNode?

        while (current != null) {
            next = current.next

            if (current.value < x) {
                current.next = insert.next
                insert.next = current
                insert = current
                current = next
                if (insert.next == null) {
                    tail = insert
                }
            } else {
                current.next = tail.next
                tail.next = current
                tail = current
                current = next
            }
        }

        return dummy.next
    }
}