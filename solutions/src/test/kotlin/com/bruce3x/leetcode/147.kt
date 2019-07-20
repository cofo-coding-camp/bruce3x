@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._147

import com.bruce3x.leetcode.ListNode
import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals(
            ListNode.create(1, 2, 3, 4),
            solution.insertionSortList(ListNode.create(4, 2, 1, 3))
        )

        assertEquals(
            ListNode.create(-1, 0, 3, 4, 5),
            solution.insertionSortList(ListNode.create(-1, 0, 3, 4, 5))
        )

        assertEquals(null, solution.insertionSortList(null))
    }
}