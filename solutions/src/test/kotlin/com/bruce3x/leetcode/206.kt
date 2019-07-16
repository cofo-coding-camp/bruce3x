@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._206

import com.bruce3x.leetcode.ListNode
import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun reverseList() {
        val solution = Solution()

        assertEquals(
            ListNode.create(5, 4, 3, 2, 1),
            solution.reverseRecursively(ListNode.create(1, 2, 3, 4, 5))
        )

        assertEquals(
            ListNode.create(5, 4, 3, 2, 1),
            solution.reverseIteratively(ListNode.create(1, 2, 3, 4, 5))
        )

        assertEquals(
            ListNode.create(1),
            solution.reverseList(ListNode.create(1))
        )
    }
}