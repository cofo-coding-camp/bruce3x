/**
 * [687] Longest Univalue Path
 *
 * https://leetcode-cn.com/problems/longest-univalue-path/description/
 *
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 *
 * The length of path between two nodes is represented by the number of edges between them.
 *
 *
 *
 * Example 1:
 *
 * Input:
 *
 *
 * 5
 * / \
 * 4 5
 * / \ \
 * 1 1 5
 *
 *
 * Output: 2
 *
 *
 *
 * Example 2:
 *
 * Input:
 *
 *
 * 1
 * / \
 * 4 5
 * / \ \
 * 4 4 5
 *
 *
 * Output: 2
 *
 *
 *
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 *
 *
 * Difficulty:     Easy
 * TestCase:       [5,4,5,1,1,5]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._687

import com.bruce3x.leetcode.TreeNode
import kotlin.math.max

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

    private var longest = 0

    fun longestUnivaluePath(root: TreeNode?): Int {
        longest = 0
        find(root)
        return longest
    }

    private fun find(root: TreeNode?): Int {
        if (root == null) return 0

        // find longest in left
        var leftLength = find(root.left)
        // find longest in right
        var rightLength = find(root.right)

        leftLength = if (root.left?.value == root.value) 1 + leftLength else 0
        rightLength = if (root.right?.value == root.value) 1 + rightLength else 0

        // longest maybe left-root-right
        longest = max(longest, leftLength + rightLength)
        return max(leftLength, rightLength)
    }
}