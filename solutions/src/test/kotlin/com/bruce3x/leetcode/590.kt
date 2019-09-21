@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._590

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
            intArrayOf(5, 6, 3, 2, 4, 1),
            solution.postorder(tree).toIntArray()
        )
    }
}