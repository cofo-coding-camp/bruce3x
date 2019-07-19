@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._15

import org.junit.Assert
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        val result = solution.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))

        println("> " + result.joinToString(separator = "|") { it.joinToString() })
        Assert.assertNotEquals(-1, result.indexOfFirst { it contentEquals listOf(-1, 0, 1) })
        Assert.assertNotEquals(-1, result.indexOfFirst { it contentEquals listOf(-1, -1, 2) })

    }

    private infix fun List<Int>.contentEquals(other: List<Int>): Boolean {
        if (size != other.size) return false

        for (i in 0 until size) {
            if (this[i] != other[i]) return false
        }
        return true
    }
}