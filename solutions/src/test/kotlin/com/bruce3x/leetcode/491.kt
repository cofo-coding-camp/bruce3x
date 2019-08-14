@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._491

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

private fun List<Int>.contentEquals(other: List<Int>): Boolean = toIntArray() contentEquals other.toIntArray()
private fun List<List<Int>>.contains2(e: List<Int>): Boolean = firstOrNull { it.contentEquals(e) } != null

class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        val results = solution.findSubsequences(intArrayOf(4, 6, 7, 7))
        assertEquals(8, results.size)
        assertTrue(results.contains2(listOf(4, 6)))
        assertTrue(results.contains2(listOf(4, 7)))
        assertTrue(results.contains2(listOf(4, 6, 7)))
        assertTrue(results.contains2(listOf(4, 6, 7, 7)))
        assertTrue(results.contains2(listOf(6, 7)))
        assertTrue(results.contains2(listOf(6, 7, 7)))
        assertTrue(results.contains2(listOf(7, 7)))
        assertTrue(results.contains2(listOf(4, 7, 7)))
    }
}