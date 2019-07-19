/**
 * [222] Count Complete Tree Nodes
 *
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/description/
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 *
 * Input:
 * 1
 * / \
 * 2 3
 * / \ /
 * 4 5 6
 *
 * Output: 6
 *
 *
 * Difficulty:     Medium
 * TestCase:       [1,2,3,4,5,6]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._222

import com.bruce3x.leetcode.TreeNode

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
    fun countNodes(root: TreeNode?): Int {
        if (root == null) return 0
        return countNodes(root.left) + countNodes(root.right) + 1
    }

}