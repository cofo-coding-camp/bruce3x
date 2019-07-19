@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._222

import com.bruce3x.leetcode.TreeNode
import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals(
            6,
            solution.countNodes(TreeNode.create(1, 2, 3, 4, 5, 6, null))
        )
    }
}