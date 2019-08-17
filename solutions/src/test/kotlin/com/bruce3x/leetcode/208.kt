@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._208

import org.junit.Assert.*
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val trie = Trie()
        trie.insert("apple")
        assertTrue(trie.search("apple"))
        assertFalse(trie.search("app"))
        assertTrue(trie.startsWith("app"))
        trie.insert("app")
        assertTrue(trie.search("app"))
    }
}