@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._216

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test


private fun List<List<Int>>.contains_(list: List<Int>): Boolean {
    return firstOrNull { it.toIntArray() contentEquals list.toIntArray() } != null
}

class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        solution.combinationSum3(k = 3, n = 7).let { results ->
            assertEquals(1, results.size)
            assertTrue(results.contains_(listOf(1, 2, 4)))
        }

        solution.combinationSum3(k = 3, n = 9).let { results ->
            assertEquals(3, results.size)

            assertTrue(results.contains_(listOf(1, 2, 6)))
            assertTrue(results.contains_(listOf(1, 3, 5)))
            assertTrue(results.contains_(listOf(2, 3, 4)))
        }

    }
}