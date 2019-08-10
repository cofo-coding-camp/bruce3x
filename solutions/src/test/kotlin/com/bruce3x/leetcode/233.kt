@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._233

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals(6, solution.countDigitOne(13))
        assertEquals(689, solution.countDigitOne(1234))
        assertEquals(1737167499, solution.countDigitOne(1410065408))
    }
}