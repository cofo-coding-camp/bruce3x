@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._113

import com.bruce3x.leetcode.TreeNode
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        val results = solution.pathSum(
            TreeNode.create(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22
        ).map { it.joinToString() }.also { println(it.joinToString(separator = "\n")) }

        assertEquals(2, results.size)
        assertTrue(results.contains("5, 4, 11, 2"))
        assertTrue(results.contains("5, 8, 4, 5"))

    }
}