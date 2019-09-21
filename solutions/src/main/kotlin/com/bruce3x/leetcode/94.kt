/**
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
 * Output: [1,3,2]
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 *
 * Difficulty:     Medium
 * Acceptance:     68.0 %
 * TestCase:       [1,null,2,3]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._94

import com.bruce3x.leetcode.TreeNode
import java.util.Stack

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
    fun inorderTraversal(root: TreeNode?): List<Int> {
        return inorderIteratively(root)
    }

    private fun inorderRecursively(root: TreeNode?): List<Int> {
        val r = arrayListOf<Int>()
        recursively(root, r)
        return r
    }

    private fun recursively(root: TreeNode?, result: ArrayList<Int>) {
        if (root == null) return
        recursively(root.left, result)
        result.add(root.value)
        recursively(root.right, result)
    }

    private fun inorderIteratively(root: TreeNode?): List<Int> {
        val result = arrayListOf<Int>()
        val stack = Stack<TreeNode>()
        var node = root
        while (node != null || stack.isNotEmpty()) {
            while (node != null) {
                stack.push(node)
                node = node.left
            }

            node = stack.pop()
            result.add(node.value)
            node = node.right
        }
        return result
    }
}