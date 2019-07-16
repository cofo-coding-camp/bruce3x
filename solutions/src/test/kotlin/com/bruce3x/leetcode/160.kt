@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._160

import com.bruce3x.leetcode.ListNode
import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun getIntersectionNode() {
        val solution = Solution()

        val s = ListNode.create(1, 8, 4, 5)
        val s1 = ListNode(4).apply { next = s }
        val s2 = ListNode(5).apply { next = ListNode(0).apply { next = s } }
        assertEquals(s, solution.getIntersectionNode2(s1, s2))

        assertEquals(
            null,
            solution.getIntersectionNode2(
                ListNode.create(2, 6, 4),
                ListNode.create(1, 5)
            )?.value
        )
    }
}