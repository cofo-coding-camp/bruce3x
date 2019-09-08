/**
 * [698] Partition to K Equal Sum Subsets
 *
 * https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/description/
 *
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 *
 *
 *
 * Difficulty:     Medium
 * Acceptance:     40.0 %
 * TestCase:       [4,3,2,3,5,2,1], 4
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._698

class Solution {
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        if (nums.isEmpty()) return false

        nums.sort()
        val total = nums.sum()
        if (total % k != 0) return false

        val single = total / k
        if (nums.last() > single) return false


        return dfs(nums, k, single, 0, 0, BooleanArray(nums.size))
    }

    private fun dfs(nums: IntArray, k: Int, target: Int, start: Int, value: Int, visited: BooleanArray): Boolean {
        if (k == 0) return true
        if (value > target) return false
        if (value == target) {
            return dfs(nums, k - 1, target, 0, 0, visited)
        }

        for (i in start until nums.size) {
            if (visited[i]) continue

            val v = nums[i]
            if (v + value > target) break

            visited[i] = true
            if (dfs(nums, k, target, i + 1, v + value, visited)) {
                return true
            }

            visited[i] = false
        }
        return false
    }
}