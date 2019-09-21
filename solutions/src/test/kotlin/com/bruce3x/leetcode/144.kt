@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._144

import com.bruce3x.leetcode.TreeNode
import org.junit.Assert.assertArrayEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        assertArrayEquals(
            intArrayOf(1, 2, 3),
            Solution().preorderTraversal(TreeNode.create(1, null, 2, 3)).toIntArray()
        )
    }
}