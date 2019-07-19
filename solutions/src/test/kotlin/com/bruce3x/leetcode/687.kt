@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._687

import com.bruce3x.leetcode.TreeNode
import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals(2, solution.longestUnivaluePath(TreeNode.create(5, 4, 5, 1, 1, null, 5)))
        assertEquals(2, solution.longestUnivaluePath(TreeNode.create(1, 4, 5, 4, 4, null, 5)))
        assertEquals(0, solution.longestUnivaluePath(null))
        assertEquals(0, solution.longestUnivaluePath(TreeNode(0)))
        assertEquals(1, solution.longestUnivaluePath(TreeNode.create(0, 0)))
        assertEquals(2, solution.longestUnivaluePath(TreeNode.create(1, 1, 1)))
        assertEquals(4, solution.longestUnivaluePath(TreeNode.create(1, null, 1, 1, 1, 1, 1, 1)))
        assertEquals(
            6,
            solution.longestUnivaluePath(
                TreeNode.create(
                    5,
                    4,
                    5,
                    4,
                    4,
                    5,
                    3,
                    4,
                    4,
                    null,
                    null,
                    null,
                    4,
                    null,
                    null,
                    4,
                    null,
                    null,
                    4,
                    null,
                    4,
                    4,
                    null,
                    null,
                    4,
                    4
                )
            )
        )
    }
}