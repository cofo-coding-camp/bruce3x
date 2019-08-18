/**
 * [784] Letter Case Permutation
 *
 * https://leetcode-cn.com/problems/letter-case-permutation/description/
 *
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string. Return a list of all possible strings we could create.
 *
 *
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 *
 * Input: S = "12345"
 * Output: ["12345"]
 *
 *
 * Note:
 *
 *
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 *
 *
 *
 * Difficulty:     Easy
 * Acceptance:     68.2 %
 * TestCase:       "a1b2"
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._784

import java.util.*

class Solution {
    fun letterCasePermutation(S: String): List<String> {
        val result = LinkedList<String>()
        dfs(S, 0, result, java.lang.StringBuilder())
        return result
    }

    private fun dfs(S: String, index: Int, result: LinkedList<String>, sb: StringBuilder) {
        if (sb.length == S.length) {
            result.add(sb.toString())
            return
        }

        val ch = S[index]
        sb.append(ch)
        dfs(S, index + 1, result, sb)
        sb.deleteCharAt(sb.length - 1)

        val newChar = when (ch) {
            in 'a'..'z' -> ch.toUpperCase()
            in 'A'..'Z' -> ch.toLowerCase()
            else -> ch
        }

        if (newChar != ch) {
            sb.append(newChar)
            dfs(S, index + 1, result, sb)
            sb.deleteCharAt(sb.length - 1)
        }
    }
}