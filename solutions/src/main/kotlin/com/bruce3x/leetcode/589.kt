/**
 * [589] N-ary Tree Preorder Traversal
 *
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 *
 * For example, given a 3-ary tree:
 *
 *
 *
 *
 *
 *
 *
 * Return its preorder traversal as: [1,3,5,6,2,4].
 *
 *
 *
 * Note:
 *
 * Recursive solution is trivial, could you do it iteratively?
 *
 *
 * Difficulty:     Easy
 * Acceptance:     69.7 %
 * TestCase:       {"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._589

import java.util.*

class Node(var value: Int) {
    var children: MutableList<Node>? = null
}

class Solution {
    fun preorder(root: Node?): List<Int> {
        return preorderIteratively(root)
    }

    private fun preorderRecursively(root: Node?): List<Int> {
        return arrayListOf<Int>().also { recursively(root, it) }
    }

    private fun recursively(root: Node?, result: ArrayList<Int>) {
        root?.apply {
            result.add(value)
            children?.forEach {
                recursively(it, result)
            }
        }
    }

    private fun preorderIteratively(root: Node?): List<Int> {
        if (root == null) return emptyList()
        val r = arrayListOf<Int>()
        val stack = Stack<Node>()
        stack.add(root)
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            r.add(node.value)
            node.children?.let {
                for (i in it.size - 1 downTo 0) {
                    stack.push(it[i])
                }
            }
        }
        return r
    }
}