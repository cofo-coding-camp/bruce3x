@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._589

import org.junit.Assert.assertArrayEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        val tree = Node(1)
        tree.children = mutableListOf(
            Node(3).apply {
                children = mutableListOf(Node(5), Node(6))
            },
            Node(2),
            Node(4)
        )
        assertArrayEquals(
            intArrayOf(1, 3, 5, 6, 2, 4),
            solution.preorder(tree).toIntArray()
        )
    }
}