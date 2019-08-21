@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._996

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertEquals(2, solution.numSquarefulPerms(intArrayOf(1, 17, 8)))
        assertEquals(1, solution.numSquarefulPerms(intArrayOf(2, 2, 2)))
        assertEquals(1, solution.numSquarefulPerms(intArrayOf(1, 1, 8, 1, 8)))
    }
}