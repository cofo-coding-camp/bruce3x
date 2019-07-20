@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._236

import com.bruce3x.leetcode.TreeNode
import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        val root = TreeNode.create(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        assertEquals(
            3,
            solution.lowestCommonAncestor(
                root, TreeNode(5), TreeNode(1)
            )?.value
        )

        assertEquals(
            5,
            solution.lowestCommonAncestor(
                root, TreeNode(5), TreeNode(4)
            )?.value
        )
    }
}