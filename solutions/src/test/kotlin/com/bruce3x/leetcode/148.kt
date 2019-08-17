@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._148

import com.bruce3x.leetcode.ListNode
import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals(
            ListNode.create(1, 2, 3, 4),
            solution.sortList(ListNode.create(4, 2, 1, 3))
        )

        assertEquals(
            ListNode.create(-1, 0, 3, 4, 5),
            solution.sortList(ListNode.create(-1, 5, 3, 4, 0))
        )
    }
}