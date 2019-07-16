@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._21

import com.bruce3x.leetcode.ListNode
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test


class SolutionTest {
    @Test
    fun mergeTwoLists() {
        val solution = Solution()

        assertEquals(
            ListNode.create(1, 1, 2, 3, 4, 4),
            solution.mergeTwoLists(
                ListNode.create(1, 2, 4),
                ListNode.create(1, 3, 4)
            )
        )

        assertEquals(
            ListNode.create(1, 2, 4),
            solution.mergeTwoLists(
                ListNode.create(1, 2, 4),
                null
            )
        )

        assertNull(solution.mergeTwoLists(null, null))
    }
}