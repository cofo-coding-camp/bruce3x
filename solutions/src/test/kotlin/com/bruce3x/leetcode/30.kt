@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._30

import org.junit.Assert.assertArrayEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertArrayEquals(
            intArrayOf(0, 9),
            solution.findSubstring("barfoothefoobarman", arrayOf("foo", "bar")).toIntArray()
        )

        assertArrayEquals(
            intArrayOf(),
            solution.findSubstring("wordgoodgoodgoodbestword", arrayOf("word", "good", "best", "word")).toIntArray()
        )

        assertArrayEquals(
            intArrayOf(8),
            solution.findSubstring("wordgoodgoodgoodbestword", arrayOf("word", "good", "best", "good")).toIntArray()
        )
    }
}