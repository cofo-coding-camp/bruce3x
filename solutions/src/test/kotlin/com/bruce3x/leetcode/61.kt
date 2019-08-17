@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._61

import com.bruce3x.leetcode.ListNode
import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals(
            ListNode.create(4, 5, 1, 2, 3),
            solution.rotateRight(ListNode.create(1, 2, 3, 4, 5), k = 2)
        )

        assertEquals(
            ListNode.create(2, 0, 1),
            solution.rotateRight(ListNode.create(0, 1, 2), k = 4)
        )

        assertEquals(
            ListNode.create(1),
            solution.rotateRight(ListNode.create(1), k = 0)
        )
        assertEquals(
            ListNode.create(1, 2),
            solution.rotateRight(ListNode.create(1, 2), k = 2)
        )
    }
}