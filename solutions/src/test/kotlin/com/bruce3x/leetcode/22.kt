@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._22

import org.junit.Assert.assertTrue
import org.junit.Test

private fun List<String>._equals(other: List<String>): Boolean {
    return this.size == other.size && this.all { it in other }
}

class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertTrue(
            solution.generateParenthesis(3)._equals(
                listOf(
                    "((()))",
                    "(()())",
                    "(())()",
                    "()(())",
                    "()()()"
                )
            )
        )
    }
}