@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._145

import com.bruce3x.leetcode.TreeNode
import org.junit.Assert.assertArrayEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        assertArrayEquals(
            intArrayOf(3, 2, 1),
            solution.postorderTraversal(TreeNode.create(1, null, 2, 3)).toIntArray()
        )
    }
}