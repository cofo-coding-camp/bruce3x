/**
 * [52] N-Queens II
 *
 * https://leetcode-cn.com/problems/n-queens-ii/description/
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example:
 *
 *
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 * [".Q..", // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 *
 * ["..Q.", // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 *
 *
 *
 * Difficulty:     Hard
 * TestCase:       4
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._52

class Solution {
    fun totalNQueens(n: Int): Int {
        val columns = BooleanArray(n)
        val mainDiagonal = BooleanArray(2 * n - 1)
        val minorDiagonal = BooleanArray(2 * n - 1)

        return backtrack(n, 0, columns, mainDiagonal, minorDiagonal, 0)
    }

    private fun backtrack(
        n: Int,
        row: Int,
        columns: BooleanArray,
        diag1: BooleanArray,
        diag2: BooleanArray,
        count: Int
    ): Int {
        var total = count
        if (n == row) {
            total++
        } else {
            for (col in 0 until n) {
                if (columns[col] || diag1[col - row + n - 1] || diag2[col + row]) continue
                updateBoard(n, row, col, columns, diag1, diag2, true)
                total = backtrack(n, row + 1, columns, diag1, diag2, total)
                updateBoard(n, row, col, columns, diag1, diag2, false)
            }
        }
        return total
    }

    private fun updateBoard(
        n: Int,
        row: Int,
        col: Int,
        columns: BooleanArray,
        diag1: BooleanArray,
        diag2: BooleanArray,
        putQueen: Boolean
    ) {
        columns[col] = putQueen
        diag1[col - row + n - 1] = putQueen
        diag2[col + row] = putQueen
    }

}