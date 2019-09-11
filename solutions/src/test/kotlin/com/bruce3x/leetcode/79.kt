@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._79

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertTrue(
            solution.exist(
                arrayOf(
                    charArrayOf('A', 'B', 'C', 'E'),
                    charArrayOf('S', 'F', 'C', 'S'),
                    charArrayOf('A', 'D', 'E', 'E')
                ),
                word = "ABCCED"
            )
        )

        assertTrue(
            solution.exist(
                arrayOf(
                    charArrayOf('A', 'B', 'C', 'E'),
                    charArrayOf('S', 'F', 'C', 'S'),
                    charArrayOf('A', 'D', 'E', 'E')
                ),
                word = "SEE"
            )
        )

        assertFalse(
            solution.exist(
                arrayOf(
                    charArrayOf('A', 'B', 'C', 'E'),
                    charArrayOf('S', 'F', 'C', 'S'),
                    charArrayOf('A', 'D', 'E', 'E')
                ),
                word = "ABCB"
            )
        )
        assertTrue(
            solution.exist(
                arrayOf(
                    charArrayOf('a', 'b'),
                    charArrayOf('c', 'd')
                ),
                word = "cdba"
            )
        )
    }
}