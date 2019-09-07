@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._842

import org.junit.Assert.assertTrue
import org.junit.Test


private fun List<Int>._equals(other: List<Int>): Boolean {
    return this.size == other.size && all { it in other }
}

class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertTrue(
            solution.splitIntoFibonacci("123456579")._equals(
                listOf(123, 456, 579)
            )
        )

        assertTrue(
            solution.splitIntoFibonacci("11235813")._equals(
                listOf(1, 1, 2, 3, 5, 8, 13)
            )
        )

        assertTrue(
            solution.splitIntoFibonacci("112358130")._equals(
                listOf()
            )
        )

        assertTrue(
            solution.splitIntoFibonacci("0123")._equals(
                listOf()
            )
        )

        assertTrue(
            solution.splitIntoFibonacci("1101111")._equals(
                listOf(110, 1, 111)
            ) ||
                    solution.splitIntoFibonacci("1101111")._equals(
                        listOf(11, 0, 11, 11)
                    )
        )

        assertTrue(
            solution.splitIntoFibonacci("5511816597")._equals(
                listOf()
            )
        )
    }

    @Test(timeout = 500L)
    fun testLongInput() {
        val solution = Solution()
        assertTrue(
            solution.splitIntoFibonacci("539834657215398346785398346991079669377")._equals(
                listOf(539834657, 21, 539834678, 539834699, 1079669377)
            )
        )
    }
}