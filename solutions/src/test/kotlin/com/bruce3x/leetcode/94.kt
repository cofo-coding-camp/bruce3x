@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._94

import com.bruce3x.leetcode.TreeNode
import org.junit.Assert.assertArrayEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertArrayEquals(
            intArrayOf(1, 3, 2),
            solution.inorderTraversal(TreeNode.create(1, null, 2, 3)).toIntArray()
        )
    }
}