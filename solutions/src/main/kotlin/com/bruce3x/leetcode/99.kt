/**
 * [99] Recover Binary Search Tree
 *
 * https://leetcode-cn.com/problems/recover-binary-search-tree/description/
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Example 1:
 *
 *
 * Input: [1,3,null,null,2]
 *
 *   1
 *  /
 * 3
 *  \
 *   2
 *
 * Output: [3,1,null,null,2]
 *
 *   3
 *  /
 * 1
 *  \
 *   2
 *
 *
 * Example 2:
 *
 *
 * Input: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * Output: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 *
 *
 * Follow up:
 *
 *
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 *
 *
 *
 * Difficulty:     Hard
 * TestCase:       [1,3,null,null,2]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._99

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
    /**
     * 二叉搜索树的中序遍历是有序的
     */
    fun recoverTree(root: TreeNode?) {
        if (root == null) return

        val orders = arrayListOf<TreeNode>()
        inorder(root, orders)

        var i = 0
        var j = orders.size - 1
        while (i < orders.size - 1 && orders[i].value < orders[i + 1].value) i++
        while (j >= 1 && orders[j - 1].value < orders[j].value) j--

        if (i<j){
            val tmp = orders[j].value
            orders[j].value = orders[i].value
            orders[i].value = tmp
        }
    }

    private fun inorder(node: TreeNode, orders: ArrayList<TreeNode>) {
        node.left?.let { inorder(it, orders) }
        orders.add(node)
        node.right?.let { inorder(it, orders) }
    }
}