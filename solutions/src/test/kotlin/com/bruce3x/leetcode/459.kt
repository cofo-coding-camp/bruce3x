@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._459

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertTrue(solution.repeatedSubstringPattern("abab"))
        assertFalse(solution.repeatedSubstringPattern("aba"))
        assertTrue(solution.repeatedSubstringPattern("abcabcabcabc"))
        assertFalse(solution.repeatedSubstringPattern("a"))
        assertFalse(solution.repeatedSubstringPattern("ababba"))
    }
}