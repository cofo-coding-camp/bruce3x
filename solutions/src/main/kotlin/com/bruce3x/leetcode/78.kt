/**
 * [78] Subsets
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 *
 * Difficulty:     Medium
 * TestCase:       [1,2,3]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._78

import java.util.*

class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val results = LinkedList<List<Int>>()
        dfs(nums, 0, results, LinkedList())
        return results
    }

    private fun dfs(nums: IntArray, start: Int, results: LinkedList<List<Int>>, tmp: LinkedList<Int>) {
        results.add(tmp.toList())
        for (i in start until nums.size) {
            tmp.addLast(nums[i])
            dfs(nums, i + 1, results, tmp)
            tmp.removeLast()
        }
    }

    /**
     * 空集的幂集只有空集，每增加一个元素，都再已有的子集上追加此元素形成新的子集
     */
    fun subsets2(nums: IntArray): List<List<Int>> {
        val results = LinkedList<LinkedList<Int>>()
        results.add(LinkedList())
        for (n in nums) {
            for (i in 0 until results.size) {
                val newList = LinkedList(results[i])
                newList.add(n)
                results.addLast(newList)
            }
        }
        return results
    }
}