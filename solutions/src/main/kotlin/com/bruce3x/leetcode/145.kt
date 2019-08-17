/**
 * [145] Binary Tree Postorder Traversal
 *
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/description/
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example:
 *
 *
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 *
 * Output: [3,2,1]
 *
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 *
 * Difficulty:     Hard
 * TestCase:       [1,null,2,3]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._145

import com.bruce3x.leetcode.TreeNode
import java.util.LinkedList

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
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val results = LinkedList<Int>()
        dfs(root, results)
        return results
    }

    private fun dfs(node: TreeNode?, results: LinkedList<Int>) {
        if (node == null) return
        dfs(node.left, results)
        dfs(node.right, results)
        results.add(node.value)
    }

    fun postorderTraversal2(root: TreeNode?): List<Int> {
        val stack = LinkedList<TreeNode>()
        val results = LinkedList<Int>()
        if (root == null) return results

        stack.addLast(root)
        while (true) {
            val node = stack.pollLast() ?: break
            results.addFirst(node.value)
            node.left?.let(stack::addLast)
            node.right?.let(stack::addLast)
        }

        return results
    }
}