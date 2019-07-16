/**
 * [142] Linked List Cycle II
 *
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/description/
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 *
 *
 * Example 2:
 *
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 *
 *
 * Example 3:
 *
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 *
 *
 *
 *
 *
 * Follow-up:
 * Can you solve it without using extra space?
 *
 *
 * Difficulty:     Medium
 * TestCase:       [3,2,0,-4], 1
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._142

import com.bruce3x.leetcode.ListNode


class Solution {
    fun detectCycle(head: ListNode?): ListNode? {
        val inter = intersection(head)

        var p1 = head
        var p2 = inter
        while (p1 != p2) {
            p1 = p1?.next
            p2 = p2?.next
        }
        return p1
    }

    private fun intersection(head: ListNode?): ListNode? {
        var fast = head
        var slow = head

        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
            if (fast === slow) return fast
        }

        return null
    }
}