/**
 * [111] Minimum Depth of Binary Tree
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *
 * 3
 * / \
 * 9 20
 * / \
 * 15 7
 *
 * return its minimum depth = 2.
 *
 *
 * Difficulty:     Easy
 * TestCase:       [3,9,20,null,null,15,7]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._111

import com.bruce3x.leetcode.TreeNode
import kotlin.math.min

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
    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val left = minDepth(root.left)
        val right = minDepth(root.right)
        return 1 + if (left == 0 && right == 0) {
            0
        } else if (left == 0) {
            right
        } else if (right == 0) {
            left
        } else {
            min(left, right)
        }
    }

}