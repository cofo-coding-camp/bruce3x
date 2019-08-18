@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._90

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
        val results = solution.subsetsWithDup(intArrayOf(1, 2, 2))
        println(results.joinToString(separator = "\n"){it.joinToString()}+ "\n\n")

        assertEquals(6, results.size)
        assertTrue(results.contains_(listOf(2)))
        assertTrue(results.contains_(listOf(1)))
        assertTrue(results.contains_(listOf(1, 2, 2)))
        assertTrue(results.contains_(listOf(2, 2)))
        assertTrue(results.contains_(listOf(1, 2)))
        assertTrue(results.contains_(listOf()))
    }
}