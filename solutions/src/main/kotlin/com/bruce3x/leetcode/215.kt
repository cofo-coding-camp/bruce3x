/**
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 *
 * Example 2:
 *
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 *
 * Difficulty:     Medium
 * TestCase:       [3,2,1,5,6,4], 2
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._215

class Solution {
    fun findKthLargest(nums: IntArray?, k: Int): Int {
        if (nums == null || nums.isEmpty() || k < 1 || k > nums.size) return 0

        var left = 0
        var right = nums.size - 1

        while (true) {
            val position = partition(nums, left, right)
            when {
                position + 1 == k -> return nums[position]
                position + 1 < k -> left = position + 1
                else -> right = position - 1
            }
        }
    }

    private fun partition(nums: IntArray, left: Int, right: Int): Int {
        if (left >= right) return left
        val pivot = nums[left]
        var i = left
        var j = right + 1
        while (true) {
            // find first smaller than pivot from left
            while (nums[++i] > pivot) if (i == right) break
            // find first greater than pivot from right
            while (nums[--j] < pivot) if (j == left) break

            if (i >= j) break
            swap(nums, i, j)
        }

        swap(nums, left, j)
        return j
    }

    private fun swap(nums: IntArray, a: Int, b: Int) {
        val tmp = nums[a]
        nums[a] = nums[b]
        nums[b] = tmp
    }
}