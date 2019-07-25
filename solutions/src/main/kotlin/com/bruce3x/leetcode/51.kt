/**
 * [51] N-Queens
 *
 * https://leetcode-cn.com/problems/n-queens/description/
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Example:
 *
 *
 * Input: 4
 * Output: [
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
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 *
 *
 *
 * Difficulty:     Hard
 * TestCase:       4
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._51

class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        val columns = BooleanArray(n)
        val mainDiagonal = BooleanArray(2 * n - 1)
        val minorDiagonal = BooleanArray(2 * n - 1)
        val board = Array(n) { CharArray(n) { '.' } }
        val results = mutableListOf<List<String>>()

        backtrack(n, 0, columns, mainDiagonal, minorDiagonal, board, results)

        return results
    }

    private fun backtrack(
        n: Int,
        row: Int,
        columns: BooleanArray,
        diag1: BooleanArray,
        diag2: BooleanArray,
        board: Array<CharArray>,
        results: MutableList<List<String>>
    ) {
        if (n == row) {
            results.add(board.map { String(it) }.toList())
            return
        }

        for (col in 0 until n) {
            if (columns[col] || diag1[col - row + n - 1] || diag2[col + row]) continue
            updateBoard(n, row, col, board, columns, diag1, diag2, true)
            backtrack(n, row + 1, columns, diag1, diag2, board, results)
            updateBoard(n, row, col, board, columns, diag1, diag2, false)
        }
    }

    private fun updateBoard(
        n: Int,
        row: Int,
        col: Int,
        board: Array<CharArray>,
        columns: BooleanArray,
        diag1: BooleanArray,
        diag2: BooleanArray,
        putQueen: Boolean
    ) {
        board[row][col] = if (putQueen) 'Q' else '.'
        columns[col] = putQueen
        diag1[col - row + n - 1] = putQueen
        diag2[col + row] = putQueen
    }

    @Deprecated("")
    private fun printBoard(
        n: Int,
        row: Int,
        col: Int,
        board: Array<CharArray>,
        columns: BooleanArray,
        diag1: BooleanArray,
        diag2: BooleanArray
    ) {
        val debugBoard = Array(n) { CharArray(n) }

        for (i in 0 until board.size) {
            for (j in 0 until board[i].size) {
                debugBoard[i][j] = board[i][j]
            }
        }

        for (i in 0 until debugBoard.size) {
            for (j in 0 until debugBoard[i].size) {
                if (debugBoard[i][j] != 'Q') {
                    if (i < row || columns[j] || diag1[j - i + n - 1] || diag2[j + i]) {
                        debugBoard[i][j] = 'X'
                    }
                }
            }
        }

        debugBoard.joinToString(separator = "\n") { it.joinToString(separator = " ") }.also {
            println("> n=$n row=$row col=$col")
            println(it)
            println()
        }
    }
}