/**
 * [90] Subsets II
 *
 * https://leetcode-cn.com/problems/subsets-ii/description/
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 *
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       [1,2,2]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._90

import java.util.LinkedList

class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        val subsets = LinkedList<List<Int>>()
        dfs(nums, 0, subsets, LinkedList())
        return subsets
    }

    private fun dfs(nums: IntArray, start: Int, subsets: LinkedList<List<Int>>, tmp: LinkedList<Int>) {
        subsets.add(tmp.toList())

        for (i in start until nums.size) {
            if (i > start && nums[i] == nums[i - 1]) continue
            tmp.addLast(nums[i])
            dfs(nums, i + 1, subsets, tmp)
            tmp.removeLast()
        }
    }
}