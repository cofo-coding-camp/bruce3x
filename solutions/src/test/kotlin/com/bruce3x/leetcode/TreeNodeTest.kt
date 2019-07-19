package com.bruce3x.leetcode

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class TreeNodeTest {
    @Test
    fun testCreate() {
        val root = TreeNode.create(1, 2, 3, null, 4, 5)
        assertEquals(1, root.value)
        assertEquals(2, root.left?.value)
        assertEquals(3, root.right?.value)
        assertEquals(null, root.left?.left?.value)
        assertEquals(4, root.left?.right?.value)
        assertEquals(5, root.right?.left?.value)
        assertEquals(null, root.right?.right?.value)
    }

    @Test
    fun testToString() {
        assertEquals(
            "[1, 2, 3, 4, 5, 6, 7]",
            TreeNode.create(1, 2, 3, 4, 5, 6, 7).toString()
        )

        assertEquals(
            "[1, 2, 3, null, 4, 5, null]",
            TreeNode.create(1, 2, 3, null, 4, 5).toString()
        )
    }

    @Test
    fun testEquals() {
        val node1 = TreeNode(1)
        val node2 = TreeNode(2)
        val node3 = TreeNode(3)
        val node4 = TreeNode(4)
        val node5 = TreeNode(5)
        val node6 = TreeNode(6)
        val node7 = TreeNode(7)

        node1.left = node2
        node1.right = node3
        node2.left = null
        node2.right = null
        node3.left = node6
        node3.right = node7

        assertEquals(node1, TreeNode.create(1, 2, 3, null, null, 6, 7))

        node2.left = node4
        node2.right = node5

        assertEquals(node1, TreeNode.create(1, 2, 3, 4, 5, 6, 7))

        assertTrue(
            TreeNode.create(1, 2, 3, null, 4, 5) == TreeNode.create(1, 2, 3, null, 4, 5)
        )
    }
}