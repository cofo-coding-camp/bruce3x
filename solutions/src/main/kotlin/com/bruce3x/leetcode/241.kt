/**
 * [241] Different Ways to Add Parentheses
 *
 * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/description/
 *
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 *
 * Example 1:
 *
 *
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * Example 2:
 *
 *
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 *
 * Difficulty:     Medium
 * Acceptance:     69.8 %
 * TestCase:       "2-1-1"
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._241

class Solution {
    fun diffWaysToCompute(input: String): List<Int> {
        return ways(input).sorted()
    }

    private fun ways(input: String): List<Int> {
        val results = mutableListOf<Int>()
        for (i in 0 until input.length) {
            val op = input[i]
            if (op == '+' || op == '-' || op == '*') {
                val left = input.substring(0, i)
                val right = input.substring(i + 1, input.length)

                for (l in ways(left)) {
                    for (r in ways(right)) {
                        when (op) {
                            '+' -> results.add(l + r)
                            '-' -> results.add(l - r)
                            '*' -> results.add(l * r)
                        }
                    }
                }
            }
        }

        if (results.isEmpty()) {
            results.add(input.toInt())
        }
        println(">>> " + results.joinToString())
        return results
    }

}