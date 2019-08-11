/**
 * [162] Find Peak Element
 *
 * https://leetcode-cn.com/problems/find-peak-element/description/
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 *
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 *
 * Example 2:
 *
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 * or index number 5 where the peak element is 6.
 *
 *
 * Note:
 *
 * Your solution should be in logarithmic complexity.
 *
 *
 * Difficulty:     Medium
 * TestCase:       [1,2,3,1]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._162

class Solution {
    /**
     * 如果 nums[mid] < nums[mid+1] 成立，那么右边肯定存在峰值
     * 如果 nums[mid+2] < nums[mid+1] 峰值就是 mid+1
     * 否则右半边递增，峰值就是 nums.size -1
     */
    fun findPeakElement(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        while (l < r) {
            val mid = (l + r) / 2
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1
            } else {
                r = mid
            }
        }

        return l
    }
}