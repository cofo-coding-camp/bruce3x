@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._86

import com.bruce3x.leetcode.ListNode
import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun partition() {
        val s = Solution()

        assertEquals(
            ListNode.create(1, 2, 2, 4, 3, 5),
            s.partition(ListNode.create(1, 4, 3, 2, 5, 2), 3)
        )
    }
}