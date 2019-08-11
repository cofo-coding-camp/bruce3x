/**
 * [547] Friend Circles
 *
 * https://leetcode-cn.com/problems/friend-circles/description/
 *
 *
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 *
 *
 *
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
 *
 *
 * Example 1:
 *
 * Input:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. The 2nd student himself is in a friend circle. So return 2.
 *
 *
 *
 * Example 2:
 *
 * Input:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 *
 *
 *
 *
 * Note:
 *
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       [[1,1,0],[1,1,0],[0,0,1]]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._547

class Solution {
    fun findCircleNum(M: Array<IntArray>?): Int {
        if (M.isNullOrEmpty()) return 0
        val visited = BooleanArray(M.size) { false }
        var count = 0
        for (i in 0 until M.size) {
            if (visited[i].not()) {
                dfs(M, i, visited)
                count++
            }
        }

        return count
    }

    private fun dfs(M: Array<IntArray>, i: Int, visited: BooleanArray) {
        visited[i] = true
        for (j in 0 until M[i].size) {
            if (M[i][j] == 1 && visited[j].not()) {
                dfs(M, j, visited)
            }
        }
    }
}