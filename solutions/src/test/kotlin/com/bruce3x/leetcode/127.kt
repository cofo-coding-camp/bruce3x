@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._127

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals(
            5,
            solution.ladderLength2("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog"))
        )

        assertEquals(
            0,
            solution.ladderLength2("hit", "cog", listOf("hot", "dot", "dog", "lot", "log"))
        )
    }
}