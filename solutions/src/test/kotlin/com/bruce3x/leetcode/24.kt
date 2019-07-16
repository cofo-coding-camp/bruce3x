@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._24

import com.bruce3x.leetcode.ListNode
import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun swapPairs() {
        val s = Solution()

        assertEquals(
            ListNode.create(2, 1, 4, 3),
            s.swapPairs(ListNode.create(1, 2, 3, 4))
        )

        assertEquals(
            ListNode.create(2, 1, 4, 3, 5),
            s.swapPairs(ListNode.create(1, 2, 3, 4, 5))
        )

        assertEquals(
            null,
            s.swapPairs(null)
        )
    }
}