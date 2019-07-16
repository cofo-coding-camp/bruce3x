@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._23

import com.bruce3x.leetcode.ListNode
import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun mergeKLists() {
        val solution = Solution()

        assertEquals(
            ListNode.create(1, 1, 2, 3, 4, 4, 5, 6),
            solution.mergeKLists(
                arrayOf(
                    ListNode.create(1, 4, 5),
                    ListNode.create(1, 3, 4),
                    ListNode.create(2, 6)
                )
            )
        )

        assertEquals(
            ListNode.create(1, 4, 5),
            solution.mergeKLists(
                arrayOf(
                    ListNode.create(1, 4, 5),
                    null
                )
            )
        )

        assertEquals(
            ListNode.create(1, 4, 5),
            solution.mergeKLists(
                arrayOf(
                    ListNode.create(1, 4, 5)
                )
            )
        )
    }
}