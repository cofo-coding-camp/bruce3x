/**
 * [39] Combination Sum
 *
 * https://leetcode-cn.com/problems/combination-sum/description/
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
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
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 *
 *
 * Example 2:
 *
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       [2,3,6,7], 7
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._39

import java.util.LinkedList

class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val results = LinkedList<List<Int>>()
        candidates.sort()
        backtracking(candidates, target, results, 0, LinkedList())
        return results
    }

    private fun backtracking(
        candidates: IntArray,
        target: Int,
        results: LinkedList<List<Int>>,
        pos: Int,
        tmp: LinkedList<Int>
    ) {
        if (target < 0) return
        if (target == 0) {
            results.add(tmp.toList())
            return
        }

        for (i in pos until candidates.size) {
            println("> tmp=${tmp.joinToString()}")
            if (target < candidates[i]) break
            tmp.add(candidates[i])
            backtracking(candidates, target - candidates[i], results, i, tmp)
            tmp.removeLast()
        }
    }
}