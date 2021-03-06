/**
 * [216] Combination Sum III
 *
 * https://leetcode-cn.com/problems/combination-sum-iii/description/
 *
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 *
 * Example 1:
 *
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 *
 *
 * Example 2:
 *
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       3, 7
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._216

import java.util.*

class Solution {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val results = LinkedList<List<Int>>()
        dfs(k, n, 1, results, LinkedList())
        return results
    }

    private fun dfs(k: Int, target: Int, start: Int, results: LinkedList<List<Int>>, tmp: LinkedList<Int>) {
        if (tmp.size == k) {
            if (target == 0) results.add(tmp.toList())
            return
        }

        for (i in start..9) {
            if (target < i) return
            tmp.addLast(i)
            dfs(k, target - i, i + 1, results, tmp)
            tmp.removeLast()
        }
    }
}