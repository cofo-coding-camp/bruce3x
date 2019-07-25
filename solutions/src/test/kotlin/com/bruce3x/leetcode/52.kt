@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._52

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {

        val solution = Solution()
        assertEquals(2, solution.totalNQueens(4))
        assertEquals(10, solution.totalNQueens(5))
        assertEquals(4, solution.totalNQueens(6))
        assertEquals(40, solution.totalNQueens(7))
        assertEquals(92, solution.totalNQueens(8))
    }
}