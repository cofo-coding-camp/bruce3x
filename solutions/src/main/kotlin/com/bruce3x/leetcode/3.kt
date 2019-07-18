/**
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 *
 * Example 1:
 *
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 *
 *
 * Example 2:
 *
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 *
 *
 * Example 3:
 *
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 *
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       "abcabcbb"
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._3

import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String?): Int {
        val str = s.orEmpty()

        val window: MutableSet<Char> = HashSet()

        var i = 0
        var j = 0
        var ans = 0

        while (j < str.length) {
            // hash set check and remove O(1)
            if (window.contains(str[j])) {
                window.remove(str[i++])
            } else {
                window.add(str[j++])
                ans = max(j - i, ans)
            }
        }

        return ans
    }
}