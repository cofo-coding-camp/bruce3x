/**
 * [22] Generate Parentheses
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * For example, given n = 3, a solution set is:
 *
 *
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 *
 * Difficulty:     Medium
 * Acceptance:     71.8 %
 * TestCase:       3
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._22

class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val results = arrayListOf<String>()
        dfs(n, n, java.lang.StringBuilder(), results)
        return results
    }

    /**
     * 重点是 左边括号数量不能小于右边括号数量
     */
    private fun dfs(left: Int, right: Int, tmp: StringBuilder, results: ArrayList<String>) {
        if (left > right) return
        if (left == 0 && right == 0) {
            results.add(tmp.toString())
            return
        }
        if (left > 0) {
            tmp.append('(')
            dfs(left - 1, right, tmp, results)
            tmp.deleteLast()
        }
        if (right > 0) {
            tmp.append(')')
            dfs(left, right - 1, tmp, results)
            tmp.deleteLast()
        }
    }

    private fun StringBuilder.deleteLast() {
        if (isNotEmpty()) deleteCharAt(length - 1)
    }
}