/**
 * [590] N-ary Tree Postorder Traversal
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 *
 * For example, given a 3-ary tree:
 *
 *
 *
 *
 *
 *
 *
 * Return its postorder traversal as: [5,6,3,2,4,1].
 *
 *
 * Note:
 *
 * Recursive solution is trivial, could you do it iteratively?
 *
 *
 * Difficulty:     Easy
 * Acceptance:     69.8 %
 * TestCase:       {"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._590

import java.util.*


class Node(var value: Int) {
    var children: MutableList<Node>? = null
}

class Solution {
    fun postorder(root: Node?): List<Int> {
        val result = LinkedList<Int>()
        if (root == null) return result
        val stack = Stack<Node>()
        stack.push(root)

        while (stack.isNotEmpty()) {
            val node = stack.pop()
            result.addFirst(node.value)
            node.children?.forEach {
                stack.push(it)
            }
        }
        return result
    }
}