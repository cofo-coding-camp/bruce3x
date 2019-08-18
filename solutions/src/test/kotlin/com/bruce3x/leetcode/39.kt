@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._39

import org.junit.Assert.assertNotNull
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        solution.combinationSum(intArrayOf(2, 3, 6, 7), target = 7).let { results ->

            assertNotNull(
                results.firstOrNull { it.toIntArray() contentEquals intArrayOf(7) }
            )

            assertNotNull(
                results.firstOrNull { it.toIntArray() contentEquals intArrayOf(2, 2, 3) }
            )
        }

        solution.combinationSum(intArrayOf(2, 3, 5), target = 8).let { results ->
            assertNotNull(
                results.firstOrNull { it.toIntArray() contentEquals intArrayOf(2, 2, 2, 2) }
            )
            assertNotNull(
                results.firstOrNull { it.toIntArray() contentEquals intArrayOf(2, 3, 3) }
            )
            assertNotNull(
                results.firstOrNull { it.toIntArray() contentEquals intArrayOf(3, 5) }
            )
        }
    }
}