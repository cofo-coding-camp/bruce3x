/**
 * [459] Repeated Substring Pattern
 *
 * https://leetcode-cn.com/problems/repeated-substring-pattern/description/
 *
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 *
 *
 * Example 2:
 *
 *
 * Input: "aba"
 * Output: False
 *
 *
 * Example 3:
 *
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 *
 *
 *
 * Difficulty:     Easy
 * TestCase:       "abab"
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._459

class Solution {
    // sub seq length = t  =>  s[i] = s[i+t]
    fun repeatedSubstringPattern(s: String?): Boolean {
        if (s == null || s.isEmpty()) return false

        for (t in 1..s.length / 2) {
            if (s.length % t != 0) continue

            var i = t
            while (i < s.length && s[i % t] == s[i]) i++
            if (i == s.length) return true
        }
        return false
    }
}