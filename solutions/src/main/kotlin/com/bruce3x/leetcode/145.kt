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
 *  \
 *   2
 *  /
 * 3
 *
 * Output: [3,2,1]
 *
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 *
 * Difficulty:     Hard
 * Acceptance:     67.6 %
 * TestCase:       [1,null,2,3]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._145

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
    fun postorderTraversal(root: TreeNode?): List<Int> {
        return postorderIteratively_reversePreOrder(root)
    }

    private fun postorderRecursively(root: TreeNode?): List<Int> {
        return arrayListOf<Int>().also { recursively(root, it) }
    }

    private fun recursively(root: TreeNode?, result: ArrayList<Int>) {
        root?.apply {
            recursively(left, result)
            recursively(right, result)
            result.add(value)
        }
    }

    /**
     * 相当于仿前序遍历，反转结果
     * 仿前序遍历：root->right->left
     * 后序遍历：left->right->root
     */
    private fun postorderIteratively_reversePreOrder(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val r = LinkedList<Int>()
        val s = Stack<TreeNode>()
        s.push(root)
        while (s.isNotEmpty()) {
            val node = s.pop()
            r.addFirst(node.value)
            node.left?.let(s::push)
            node.right?.let(s::push)
        }
        return r
    }
}