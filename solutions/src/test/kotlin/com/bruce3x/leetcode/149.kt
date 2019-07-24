@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._149

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals(
            3,
            solution.maxPoints(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 2),
                    intArrayOf(3, 3)
                )
            )
        )

        assertEquals(
            4, solution.maxPoints(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(3, 2),
                    intArrayOf(5, 3),
                    intArrayOf(4, 1),
                    intArrayOf(2, 3),
                    intArrayOf(1, 4)
                )
            )
        )

        assertEquals(
            1, solution.maxPoints(
                arrayOf(intArrayOf(0, 0))
            )
        )

        assertEquals(
            3,
            solution.maxPoints(
                arrayOf(
                    intArrayOf(4, 0),
                    intArrayOf(4, -1),
                    intArrayOf(4, 5)
                )
            )
        )
        println("------------------------------------")
        assertEquals(
            3,
            solution.maxPoints(
                arrayOf(
                    intArrayOf(2, 3),
                    intArrayOf(3, 3),
                    intArrayOf(-5, 3)
                )
            )
        )
        assertEquals(2,
            solution.maxPoints(
                arrayOf(
                    intArrayOf(0,0),
                    intArrayOf(94911151, 94911150),
                    intArrayOf(94911152, 94911151)
                )
            ))
    }
}