/**
 * [996] Number of Squareful Arrays
 *
 * https://leetcode-cn.com/problems/number-of-squareful-arrays/description/
 *
 * Given an array A of non-negative integers, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.
 *
 * Return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].
 *
 *
 *
 * Example 1:
 *
 *
 * Input: [1,17,8]
 * Output: 2
 * Explanation:
 * [1,8,17] and [17,8,1] are the valid permutations.
 *
 *
 * Example 2:
 *
 *
 * Input: [2,2,2]
 * Output: 1
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= A.length <= 12
 * 0 <= A[i] <= 1e9
 *
 *
 * Difficulty:     Hard
 * Acceptance:     5.1 %
 * TestCase:       [1,17,8]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._996

import java.util.*
import kotlin.math.sqrt

class Solution {
    fun numSquarefulPerms(A: IntArray): Int {
        A.sort()
        val visited = BooleanArray(A.size)
        return backtracking(A, visited, LinkedList())
    }

    private fun backtracking(
        A: IntArray,
        visited: BooleanArray,
        tmp: LinkedList<Int>
    ): Int {
        if (tmp.size == A.size) {
            return 1
        }

        var count = 0
        for (i in 0 until A.size) {
            val v = A[i]
            if (visited[i]) continue
            if (i > 0 && v == A[i - 1] && visited[i - 1].not()) continue
            if (tmp.isNotEmpty() && isSquare(tmp.last, v).not()) continue

            visited[i] = true
            tmp.addLast(v)
            count += backtracking(A, visited, tmp)
            visited[i] = false
            tmp.removeLast()
        }
        return count
    }

    private fun isSquare(a: Int, b: Int): Boolean {
        val s = sqrt((a + b).toFloat()).toInt()
        return s * s == a + b
    }
}