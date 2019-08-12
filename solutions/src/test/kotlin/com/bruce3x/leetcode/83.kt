@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._83

import com.bruce3x.leetcode.ListNode
import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertEquals(
            ListNode.create(1, 2),
            solution.deleteDuplicates2(ListNode.create(1, 1, 2))
        )

        assertEquals(
            ListNode.create(1, 2, 3),
            solution.deleteDuplicates2(ListNode.create(1, 1, 2, 3, 3))
        )

        assertEquals(
            null, solution.deleteDuplicates2(null)
        )

        assertEquals(
            ListNode.create(1, 2, 3, 4, 5),
            solution.deleteDuplicates2(ListNode.create(1, 2, 3, 4, 5))
        )
    }
}