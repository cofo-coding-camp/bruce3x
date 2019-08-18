/**
 * [47] Permutations II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 *
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       [1,1,2]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._47

import java.util.LinkedList

class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        nums.sort()
        val results = LinkedList<List<Int>>()
        val visited = BooleanArray(nums.size)
        dfs(nums, results, LinkedList(), visited)
        return results
    }

    private fun dfs(
        nums: IntArray,
        results: LinkedList<List<Int>>,
        tmp: LinkedList<Int>,
        visited: BooleanArray
    ) {
        if (tmp.size == nums.size) {
            results.add(tmp.toList())
            return
        }

        for (i in 0 until nums.size) {
            if (visited[i]) continue
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1].not()) continue
            tmp.addLast(nums[i])
            visited[i] = true
            dfs(nums, results, tmp, visited)
            tmp.removeLast()
            visited[i] = false
        }
    }
}