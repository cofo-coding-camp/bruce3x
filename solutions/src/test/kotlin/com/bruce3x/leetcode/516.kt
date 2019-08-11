@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._516

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals(4, solution.longestPalindromeSubseq2("bbbab"))
        assertEquals(2, solution.longestPalindromeSubseq2("cbbd"))
        assertEquals(1, solution.longestPalindromeSubseq2("a"))
        assertEquals(3, solution.longestPalindromeSubseq2("aaa"))
        assertEquals(3, solution.longestPalindromeSubseq2("ava"))
    }
}