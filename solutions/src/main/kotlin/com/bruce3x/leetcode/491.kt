/**
 * [491] Increasing Subsequences
 *
 * https://leetcode-cn.com/problems/increasing-subsequences/description/
 *
 *
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .
 *
 *
 * Example:
 *
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *
 *
 *
 * Note:
 *
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       [4,6,7,7]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._491

import java.util.HashSet
import java.util.LinkedList

class Solution {
    fun findSubsequences(nums: IntArray?): List<List<Int>> {
        if (nums == null || nums.isEmpty()) return emptyList()
        val results = hashSetOf<List<Int>>()
        dfs(nums, LinkedList(), results, 0)
        return results.toList()
    }

    private fun dfs(nums: IntArray, subsequence: LinkedList<Int>, results: HashSet<List<Int>>, start: Int) {
        if (subsequence.size > 1) results.add(subsequence.toList())

        for (i in start until nums.size) {
            if (subsequence.isNotEmpty() && subsequence.last > nums[i]) continue
            subsequence.add(nums[i])
            dfs(nums, subsequence, results, i + 1)
            subsequence.removeLast()
        }
    }
}