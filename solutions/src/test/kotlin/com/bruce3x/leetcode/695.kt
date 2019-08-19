@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._695

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {

    private fun buildInput(array: Array<String>): Array<IntArray> {
        return array.map { it.split(",").map { it.toInt() }.toIntArray() }
            .toTypedArray()
    }

    @Test
    fun test() {
        val solution = Solution()
        solution.maxAreaOfIsland(
            arrayOf(
                "0,0,1,0,0,0,0,1,0,0,0,0,0",
                "0,0,0,0,0,0,0,1,1,1,0,0,0",
                "0,1,1,0,1,0,0,0,0,0,0,0,0",
                "0,1,0,0,1,1,0,0,1,0,1,0,0",
                "0,1,0,0,1,1,0,0,1,1,1,0,0",
                "0,0,0,0,0,0,0,0,0,0,1,0,0",
                "0,0,0,0,0,0,0,1,1,1,0,0,0",
                "0,0,0,0,0,0,0,1,1,0,0,0,0"
            ).let(this::buildInput)
        ).let {
            assertEquals(6, it)
        }

        solution.maxAreaOfIsland(
            arrayOf("0,0,0,0,0,0,0,0").let(this::buildInput)
        ).let {
            assertEquals(0, it)
        }
    }
}