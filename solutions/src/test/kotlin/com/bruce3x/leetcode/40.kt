@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._40

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
        solution.combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), target = 8).let { results ->
//            println(results.joinToString(separator = "\n") {
//                it.joinToString()
//            })

            assertTrue(results.contains_(listOf(1, 7)))
            assertTrue(results.contains_(listOf(1, 2, 5)))
            assertTrue(results.contains_(listOf(2, 6)))
            assertTrue(results.contains_(listOf(1, 1, 6)))
            assertEquals(4, results.size)
        }

        println(">>>")

        solution.combinationSum2(intArrayOf(2, 5, 2, 1, 2), target = 5).let { results ->
            assertTrue(results.contains_(listOf(1, 2, 2)))
            assertTrue(results.contains_(listOf(5)))
            assertEquals(2, results.size)
        }
    }
}