@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._396

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals(26, solution.maxRotateFunction(intArrayOf(4, 3, 2, 6)))
    }
}