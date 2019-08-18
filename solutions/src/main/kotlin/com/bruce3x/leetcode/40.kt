/**
 * [40] Combination Sum II
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/description/
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 *
 * Example 1:
 *
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 *
 *
 * Example 2:
 *
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       [10,1,2,7,6,1,5], 8
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._40

import java.util.LinkedList

class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val results = LinkedList<List<Int>>()
        candidates.sort()
        backtracking(candidates, target, 0, results, LinkedList())
        return results
    }

    private fun backtracking(
        candidates: IntArray,
        target: Int,
        start: Int,
        results: LinkedList<List<Int>>,
        tmp: LinkedList<Int>
    ) {
        if (target == 0) {
            results.add(tmp.toList())
            return
        }

        for (i in start until candidates.size) {
            val v = candidates[i]
            if (v > target) break
            if (i > start && candidates[i] == candidates[i - 1]) continue
            tmp.addLast(v)
            backtracking(candidates, target - v, i + 1, results, tmp)
            tmp.removeLast()
        }
    }
}