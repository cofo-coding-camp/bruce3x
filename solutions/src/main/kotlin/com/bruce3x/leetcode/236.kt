/**
 * [236] Lowest Common Ancestor of a Binary Tree
 *
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree: root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 *
 * Example 2:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 *
 *
 *
 * Note:
 *
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       [3,5,1,6,2,0,8,null,null,7,4], 5, 1
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._236

import com.bruce3x.leetcode.TreeNode

internal class Solution {

    private var lca: TreeNode? = null
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        lca = null
        if (root == null || p == null || q == null) return null
        findNode(root, p, q)
        return lca
    }

    private fun findNode(root: TreeNode?, p: TreeNode, q: TreeNode): Boolean {
        if (root == null) return false
        val left = if (findNode(root.left, p, q)) 1 else 0
        val right = if (findNode(root.right, p, q)) 1 else 0
        val mid = if (root.value == p.value || root.value == q.value) 1 else 0
        val sum = left + right + mid
        if (sum >= 2) {
            lca = root
        }

        return sum > 0
    }

}