/**
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 *
 * Difficulty:     Medium
 * TestCase:       [4,5,6,7,0,1,2], 0
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._33

class Solution {
    fun search(nums: IntArray?, target: Int): Int {
        if (nums == null || nums.isEmpty()) return -1
        var i = 0
        var j = nums.size - 1

        while (i < j) {
            val mid = (i + j) / 2
            if (nums[mid] == target) return mid
            if (nums[mid] > nums[j]) {
                // i ~ mid 有序
                if (nums[i] <= target && target < nums[mid]) {
                    j = mid - 1
                } else {
                    i = mid + 1
                }
            } else {
                // mid ~ j 有序
                if (nums[mid] < target && target <= nums[j]) {
                    i = mid + 1
                } else {
                    j = mid - 1
                }
            }
        }

        if (nums[i] == target) return i

        return -1
    }
}