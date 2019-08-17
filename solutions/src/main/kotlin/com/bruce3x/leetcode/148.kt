/**
 * [148] Sort List
 *
 * https://leetcode-cn.com/problems/sort-list/description/
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
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
 * Difficulty:     Medium
 * TestCase:       [4,2,1,3]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._148

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
    /**
     * 归并排序 bottom to top
     *
     * 时间复杂度 O(nlogn)
     * 空间复杂度 O(1)
     *
     * 第 i 轮合并，每组 2^(i-1) 个元素，每两组合并
     */
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        val dummy = ListNode(-1)
        dummy.next = head
        val len = length(head)

        var cur: ListNode?
        var l: ListNode?
        var r: ListNode?
        var tail: ListNode?

        var n = 1
        while (n < len) {
            cur = dummy.next
            tail = dummy

            while (cur != null) {
                l = cur
                r = spilt(l, n)
                cur = spilt(r, n)
                val merged = merge(l, r)
                tail?.next = merged.first
                tail = merged.second
            }
            n *= 2
        }
        return dummy.next
    }

    private fun length(head: ListNode?): Int {
        var len = 0
        var node = head
        while (node != null) {
            len++
            node = node.next
        }
        return len
    }

    private fun spilt(head: ListNode?, n: Int): ListNode? {
        var node: ListNode? = head
        var i = n
        while (--i > 0 && node != null) {
            node = node.next
        }
        val rest = node?.next
        node?.next = null
        return rest
    }

    /**
     * 归并排序 top to bottom 递归
     * O(nlogn) 时间复杂度
     * O(logn)  空间复杂度
     */
    fun sortList2(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        var slow: ListNode? = head
        var fast: ListNode? = slow?.next

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        val mid = slow?.next;
        slow?.next = null
        return merge(sortList(head), sortList(mid)).first
    }

    private fun merge(head1: ListNode?, head2: ListNode?): Pair<ListNode?, ListNode?> {
        val dummy = ListNode(-1)
        var tail: ListNode = dummy

        var p: ListNode? = head1
        var q: ListNode? = head2

        while (p != null && q != null) {
            if (p.value < q.value) {
                tail.next = p
                tail = p
                p = p.next
            } else {
                tail.next = q
                tail = q
                q = q.next
            }
        }

        if (p != null) tail.next = p
        if (q != null) tail.next = q

        while (tail.next != null) {
            tail = tail.next!!
        }
        return dummy.next to tail
    }
}