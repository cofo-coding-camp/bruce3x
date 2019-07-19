/**
 * [15] 3Sum
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       [-1,0,1,2,-1,-4]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._15

import java.util.*

class Solution {
    fun threeSum(nums: IntArray?): List<List<Int>> {
        if (nums == null || nums.size < 3) return emptyList()

        Arrays.sort(nums)
        if (nums[0] * nums[nums.size - 1] > 0) return emptyList()

        val results = mutableListOf<List<Int>>()
        for (i in 0 until nums.size) {
            if (nums[i] > 0) break
            if (i > 0 && nums[i] == nums[i - 1]) continue

            var left = i + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                when {
                    sum == 0 -> {
                        results.add(listOf(nums[i], nums[left], nums[right]))
                        while (left < right && nums[left] == nums[left + 1]) left++
                        while (left < right && nums[right - 1] == nums[right]) right--

                        left++
                        right--
                    }
                    sum > 0 -> right--
                    else -> left++
                }
            }

        }

        return results
    }
}