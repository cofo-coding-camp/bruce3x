@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._111

import com.bruce3x.leetcode.TreeNode
import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals(
            2, solution.minDepth(
                TreeNode.create(3, 9, 20, null, null, 15, 7)
            )
        )

        assertEquals(
            2, solution.minDepth(
                TreeNode.create(1, 2)
            )
        )

        assertEquals(
            3, solution.minDepth(
                TreeNode.create(1, null, 2, 3)
            )
        )
    }
}