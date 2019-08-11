@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._451

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals("eert", solution.frequencySort("tree"))
        assertTrue(solution.frequencySort("cccaaa") in listOf("cccaaa", "aaaccc"))
        assertTrue(solution.frequencySort("Aabb") in listOf("bbAa", "bbaA"))
    }
}