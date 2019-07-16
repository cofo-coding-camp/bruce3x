/**
 * [141] Linked List Cycle
 *
 * https://leetcode.com/problems/linked-list-cycle/description/
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 *
 *
 *
 *
 * Example 2:
 *
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 *
 *
 *
 *
 * Example 3:
 *
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 *
 *
 *
 *
 *
 *
 * Follow up:
 *
 * Can you solve it using O(1) (i.e. constant) memory?
 *
 *
 * Difficulty:     Easy
 * TestCase:       [3,2,0,-4], 1
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._141

import com.bruce3x.leetcode.ListNode


class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var fast: ListNode? = head?.next?.next
        var slow: ListNode? = head?.next

        while (fast != null && slow != null) {
            if (fast === slow) return true
            fast = fast.next?.next
            slow = slow.next
        }

        return false
    }
}