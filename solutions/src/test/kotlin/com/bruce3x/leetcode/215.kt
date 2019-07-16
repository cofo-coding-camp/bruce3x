@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._215

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {

    @Test
    fun findKthLargest() {
        val solution = Solution()

        assertEquals(
            5, solution.findKthLargest(
                intArrayOf(3, 2, 1, 5, 6, 4), 2
            )
        )

        assertEquals(
            4, solution.findKthLargest(
                intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4
            )
        )
        assertEquals(
            1, solution.findKthLargest(
                intArrayOf(1), 1
            )
        )
    }
}