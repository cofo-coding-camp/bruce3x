@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._392

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertTrue(solution.isSubsequence("abc", "ahbgdc"))
        assertFalse(solution.isSubsequence("axc", "ahbgdc"))
        assertTrue(solution.isSubsequence("", "ahbgdc"))
    }
}