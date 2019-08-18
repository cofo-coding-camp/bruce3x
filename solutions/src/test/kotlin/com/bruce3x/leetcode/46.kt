@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._46

import org.junit.Assert.assertTrue
import org.junit.Test


private fun List<List<Int>>.contains_(list: List<Int>): Boolean {
    return firstOrNull { it.toIntArray() contentEquals list.toIntArray() } != null
}

private fun List<List<Int>>.equals_(other: List<List<Int>>): Boolean {
    return other.all { this.contains_(it) } && this.size == other.size
}

class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertTrue(
            solution.permute(intArrayOf(1, 2, 3)).equals_(
                listOf(
                    listOf(1, 2, 3),
                    listOf(1, 3, 2),
                    listOf(2, 1, 3),
                    listOf(2, 3, 1),
                    listOf(3, 1, 2),
                    listOf(3, 2, 1)
                )
            )
        )
    }
}