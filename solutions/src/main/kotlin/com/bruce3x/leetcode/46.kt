/**
 * [46] Permutations
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 *
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       [1,2,3]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._46

import java.util.LinkedList

class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
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
            tmp.addLast(nums[i])
            visited[i] = true
            dfs(nums, results, tmp, visited)
            tmp.removeLast()
            visited[i] = false
        }
    }
}