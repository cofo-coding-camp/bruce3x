@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._241

import org.junit.Assert.assertArrayEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertArrayEquals(
            intArrayOf(0, 2),
            solution.diffWaysToCompute("2-1-1").toIntArray()
        )

        assertArrayEquals(
            intArrayOf(-34, -14, -10, -10, 10),
            solution.diffWaysToCompute("2*3-4*5").toIntArray()
        )
    }
}