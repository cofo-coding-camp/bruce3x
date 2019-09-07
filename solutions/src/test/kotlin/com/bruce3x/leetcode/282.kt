@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._282

import org.junit.Assert.assertTrue
import org.junit.Test

private fun List<String>._equals(other: List<String>): Boolean {
    return this.size == other.size && all { it in other }
}

class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertTrue(
            solution.addOperators("123", target = 6)._equals(
                listOf(
                    "1+2+3",
                    "1*2*3"
                )
            )
        )

        assertTrue(
            solution.addOperators("232", target = 8)._equals(
                listOf(
                    "2*3+2",
                    "2+3*2"
                )
            )
        )

        assertTrue(
            solution.addOperators("105", target = 5)._equals(
                listOf(
                    "1*0+5",
                    "10-5"
                )
            )
        )

        assertTrue(
            solution.addOperators("00", target = 0)._equals(
                listOf(
                    "0+0",
                    "0-0",
                    "0*0"
                )
            )
        )

        assertTrue(
            solution.addOperators("3456237490", target = 9191)._equals(
                listOf(
                )
            )
        )

        assertTrue(
            solution.addOperators("2147483648", target = -2147483648)._equals(
                listOf()
            )
        )
        assertTrue(
            solution.addOperators("2147483647", target = 2147483647)._equals(
                listOf("2147483647")
            )
        )
    }
}