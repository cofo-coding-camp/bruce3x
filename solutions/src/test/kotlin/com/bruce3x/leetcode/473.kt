@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._473

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertTrue(solution.makesquare2(intArrayOf(1, 1, 2, 2, 2)))
        assertFalse(solution.makesquare2(intArrayOf(3, 3, 3, 3, 4)))
    }
}