/**
 * [77] Combinations
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       4, 2
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._77

import java.util.*

class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val results = LinkedList<List<Int>>()
        dfs(n, k, 1, results, LinkedList())
        return results
    }

    private fun dfs(n: Int, k: Int, start: Int, results: LinkedList<List<Int>>, tmp: LinkedList<Int>) {
        if (tmp.size == k) {
            results.add(tmp.toList())
            return
        }
        for (i in start..n) {
            tmp.addLast(i)
            dfs(n, k, i + 1, results, tmp)
            tmp.removeLast()
        }
    }
}