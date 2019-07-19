@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._297

import com.bruce3x.leetcode.TreeNode
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotSame
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val tree = TreeNode.create(1, 2, 3, null, 4, 5)

        val codec = Codec()

        assertEquals(tree, codec.deserialize(codec.serialize(tree)))
        assertNotSame(tree, codec.deserialize(codec.serialize(tree)))

        assertEquals(null, codec.deserialize(codec.serialize(null)))
    }
}