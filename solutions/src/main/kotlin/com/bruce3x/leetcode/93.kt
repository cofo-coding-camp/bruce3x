/**
 * [93] Restore IP Addresses
 *
 * https://leetcode-cn.com/problems/restore-ip-addresses/description/
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * Example:
 *
 *
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 *
 *
 *
 * Difficulty:     Medium
 * Acceptance:     45.1 %
 * TestCase:       "25525511135"
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._93

class Solution {
    fun restoreIpAddresses(s: String): List<String> {
        val results = mutableListOf<String>()
        backtracking(s, 0, results, mutableListOf())
        return results
    }

    private fun backtracking(s: String, start: Int, results: MutableList<String>, tmp: MutableList<Int>) {
        if (tmp.size == 4 && start == s.length) {
            results.add(tmp.joinToString(separator = "."))
            return
        }
        if (tmp.size >= 4) return
        if (start >= s.length) return

        if (s[start] == '0') {
            // 首位为 0，那这一段肯定只能为 .0，没有 .022 这种格式
            tmp.add(0)
            backtracking(s, start + 1, results, tmp)
            tmp.removeAt(tmp.size - 1)
            return
        }

        // 尝试 1-3 位数字
        for (digit in 1..3) {
            if (start + digit > s.length) return

            val value = s.substring(start, start + digit).toInt()
            if (value > 255) return

            tmp.add(value)
            backtracking(s, start + digit, results, tmp)
            tmp.removeAt(tmp.size - 1)
        }
    }
}