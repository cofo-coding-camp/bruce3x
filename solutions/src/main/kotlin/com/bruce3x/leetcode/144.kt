/**
 * [144] Binary Tree Preorder Traversal
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example:
 *
 *
 * Input: [1,null,2,3]
 * 1
 *  \
 *   2
 *  /
 * 3
 *
 * Output: [1,2,3]
 *
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 *
 * Difficulty:     Medium
 * Acceptance:     61.7 %
 * TestCase:       [1,null,2,3]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._144

import com.bruce3x.leetcode.TreeNode
import java.util.*

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        return preorderIteratively2(root)
    }

    private fun preorderRecursively(root: TreeNode?): List<Int> {
        return arrayListOf<Int>().also { recursively(root, it) }
    }

    private fun recursively(root: TreeNode?, result: ArrayList<Int>) {
        root?.apply {
            result.add(value)
            recursively(left, result)
            recursively(right, result)
        }
    }

    private fun preorderIteratively(root: TreeNode?): List<Int> {
        val r = arrayListOf<Int>()
        val s = Stack<TreeNode>()
        var node = root

        while (node != null || s.isNotEmpty()) {
            while (node != null) {
                r.add(node.value)
                s.push(node)
                node = node.left
            }

            node = s.pop()
            node = node.right
        }
        return r
    }

    private fun preorderIteratively2(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val r = arrayListOf<Int>()
        val s = Stack<TreeNode>()
        s.push(root)
        while (s.isNotEmpty()) {
            val node = s.pop()
            r.add(node.value)
            node.right?.let(s::push)
            node.left?.let(s::push)
        }
        return r
    }
}