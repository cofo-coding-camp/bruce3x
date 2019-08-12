@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._82

import com.bruce3x.leetcode.ListNode
import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertEquals(
            ListNode.create(1, 2, 5),
            solution.deleteDuplicates(ListNode.create(1, 2, 3, 3, 4, 4, 5))
        )

        assertEquals(
            ListNode.create(2, 3),
            solution.deleteDuplicates(ListNode.create(1, 1, 1, 2, 3))
        )

        assertEquals(
            null, solution.deleteDuplicates(null)
        )

        assertEquals(
            ListNode.create(1, 2, 3, 4, 5),
            solution.deleteDuplicates(ListNode.create(1, 2, 3, 4, 5))
        )

        assertEquals(
            null,
            solution.deleteDuplicates(ListNode.create(1, 1))
        )
    }
}