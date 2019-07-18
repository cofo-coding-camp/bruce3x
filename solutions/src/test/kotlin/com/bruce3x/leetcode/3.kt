@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._3

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"))
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"))
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"))
        assertEquals(0, solution.lengthOfLongestSubstring(""))
    }
}