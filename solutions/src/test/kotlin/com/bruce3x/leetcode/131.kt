@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._131

import org.junit.Assert.assertTrue
import org.junit.Test


private inline fun <reified T> List<List<T>>.contains_(list: List<T>): Boolean {
    return firstOrNull { it.toTypedArray() contentEquals list.toTypedArray() } != null
}

private inline fun <reified T> List<List<T>>.equals_(other: List<List<T>>): Boolean {
    return other.all { this.contains_(it) } && this.size == other.size
}

class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertTrue(
            solution.partition("aab").equals_(
                listOf(
                    listOf("aa", "b"),
                    listOf("a", "a", "b")
                )
            )
        )
        println("--")
        assertTrue(
            solution.partition("efe").equals_(
                listOf(
                    listOf("efe"),
                    listOf("e", "f", "e")
                )
            )
        )

        println("--")
        assertTrue(
            solution.partition("abbab").equals_(
                listOf(
                    listOf("a", "b", "b", "a", "b"),
                    listOf("a", "b", "bab"),
                    listOf("a", "bb", "a", "b"),
                    listOf("abba", "b")
                )
            )
        )
    }
}