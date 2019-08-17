@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._120

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertEquals(
            11, solution.minimumTotal(
                listOf(
                    listOf(2),
                    listOf(3, 4),
                    listOf(6, 5, 7),
                    listOf(4, 1, 8, 3)
                )
            )
        )
    }
}