@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._1054

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertEquals(2, solution.bitwiseComplement(5))
        assertEquals(0, solution.bitwiseComplement(7))
        assertEquals(5, solution.bitwiseComplement(10))
        assertEquals(1, solution.bitwiseComplement(0))
    }
}