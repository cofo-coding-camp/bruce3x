/**
 * [53] Maximum Subarray
 *
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 *
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 *
 * Difficulty:     Easy
 * TestCase:       [-2,1,-3,4,-1,2,1,-5,4]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._53

import kotlin.math.max

class Solution {
    fun maxSubArray(nums: IntArray?): Int {
        if (nums == null || nums.isEmpty()) return 0
        var sum = 0
        var ans = nums[0]

        for (n in nums) {
            if (sum > 0) {
                sum += n
            } else {
                sum = n
            }

            ans = max(sum, ans)
        }

        return ans
    }
}