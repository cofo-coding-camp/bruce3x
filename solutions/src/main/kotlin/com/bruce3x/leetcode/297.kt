/**
 * [297] Serialize and Deserialize Binary Tree
 *
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example:
 *
 *
 * You may serialize the following tree:
 *
 * 1
 * / \
 * 2 3
 * / \
 * 4 5
 *
 * as "[1,2,3,null,null,4,5]"
 *
 *
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 *
 *
 * Difficulty:     Hard
 * TestCase:       [1,2,3,null,null,4,5]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._297

import com.bruce3x.leetcode.TreeNode
import java.util.*

class Codec {

    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String? {
        val sb = StringBuilder()
        serialize(root, sb)
        return sb.deleteCharAt(sb.length - 1).toString()
    }

    private fun serialize(node: TreeNode?, sb: StringBuilder) {
        sb.append(node?.value ?: "null").append(",")
        node?.run {
            serialize(left, sb)
            serialize(right, sb)
        }
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String?): TreeNode? {
        if (data.isNullOrBlank()) return null
        val values = LinkedList(data.split(","))
        return deserialize(values)
    }

    private fun deserialize(values: LinkedList<String>): TreeNode? {
        if (values.isEmpty()) return null
        val value = values.removeAt(0).toIntOrNull() ?: return null

        val node = TreeNode(value)
        node.left = deserialize(values)
        node.right = deserialize(values)
        return node
    }
}