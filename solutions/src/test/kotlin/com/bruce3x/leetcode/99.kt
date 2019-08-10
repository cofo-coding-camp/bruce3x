@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._99

import com.bruce3x.leetcode.TreeNode
import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals(
            TreeNode.create(3, 1, null, null, 2),
            TreeNode.create(1, 3, null, null, 2).also(solution::recoverTree)
        )

        assertEquals(
            TreeNode.create(2, 1, 4, null, null, 3),
            TreeNode.create(3, 1, 4, null, null, 2).also(solution::recoverTree)
        )
    }
}