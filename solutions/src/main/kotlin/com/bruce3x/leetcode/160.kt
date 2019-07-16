/**
 * [160] Intersection of Two Linked Lists
 *
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 *
 * begin to intersect at node c1.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 *
 *
 *
 * Example 2:
 *
 *
 *
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 *
 *
 *
 *
 * Example 3:
 *
 *
 *
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 *
 *
 *
 *
 * Notes:
 *
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 *
 *
 * Difficulty:     Easy
 * TestCase:       8, [4,1,8,4,5], [5,0,1,8,4,5], 2, 3
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._160

import com.bruce3x.leetcode.ListNode


class Solution {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var m = headA
        var n: ListNode?
        while (m != null) {
            n = headB
            while (n != null) {
                if (m === n) return m
                n = n.next
            }
            m = m.next
        }

        return null
    }

    /**
     * m 从 A 遍历到 B 尾
     * n 从 B 遍历到 A 尾
     *
     * 故遍历长度相同(lenA + lenB)，如果相交，则有 m === n，否则遍历结束时 m === n === null
     */
    fun getIntersectionNode2(headA: ListNode?, headB: ListNode?): ListNode? {
        var m = headA
        var n = headB
        while (m !== n) {
            m = if (m == null) headB else m.next
            n = if (n == null) headA else n.next
        }

        return m
    }
}