/**
 * [152] Maximum Product Subarray
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 *
 * Example 2:
 *
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 *
 * Difficulty:     Medium
 * TestCase:       [2,3,-2,4]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._152

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxProduct(nums: IntArray?): Int {
        if (nums == null || nums.isEmpty()) return 0

        var maxValue = Int.MIN_VALUE
        var imax = 1
        var imin = 1

        nums.forEach {
            if (it < 0) {
                val tmp = imax
                imax = imin
                imin = tmp
            }

            imax = max(imax * it, it)
            imin = min(imin * it, it)

            maxValue = max(maxValue, imax)
        }

        return maxValue
    }
}