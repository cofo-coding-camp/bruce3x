@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._583

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun minDistance() {
        val solution = Solution()

        assertEquals(
            2,
            solution.minDistance("sea", "eat")
        )

        assertEquals(
            5,
            solution.minDistance("ABCBDAB", "BDCABA")
        )

        assertEquals(
            3,
            solution.minDistance("", "abc")
        )
    }
}