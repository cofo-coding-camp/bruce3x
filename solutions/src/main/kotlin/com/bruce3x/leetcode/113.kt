/**
 * [113] Path Sum II
 *
 * https://leetcode-cn.com/problems/path-sum-ii/description/
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *
 * 5
 * / \
 * 4 8
 * / / \
 * 11 13 4
 * / \ / \
 * 7 2 5 1
 *
 *
 * Return:
 *
 *
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       [5,4,8,11,null,13,4,7,2,null,null,5,1], 22
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._113

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

    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        val results = LinkedList<List<Int>>()
        go(root, sum, LinkedList(), results)
        return results
    }

    private fun go(root: TreeNode?, sum: Int, path: LinkedList<Int>, results: MutableList<List<Int>>) {
        if (root == null) return

        val nextSum = sum - root.value
        path.add(root.value)

        if (root.left == null && root.right == null) {
            if (nextSum == 0) results.add(path.toMutableList())
        } else {
            go(root.left, nextSum, path, results)
            go(root.right, nextSum, path, results)
        }

        path.removeLast()
    }
}