/**
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple"); // returns true
 * trie.search("app"); // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app"); // returns true
 *
 *
 * Note:
 *
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       ["Trie","insert","search","search","startsWith","insert","search"], [[],["apple"],["apple"],["app"],["app"],["app"],["app"]]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._208

class Trie() {

    /** Initialize your data structure here. */

    private val root = TrieNode(' ')

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var currentRoot = root
        word.forEach {
            val index = it - 'a'
            val trieNode = currentRoot.children[index] ?: TrieNode(it)
            currentRoot.children[index] = trieNode
            currentRoot = trieNode
        }
        currentRoot.count++
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        var currentRoot = root
        word.forEach {
            val index = it - 'a'
            val trieNode = currentRoot.children[index] ?: return false
            currentRoot = trieNode
        }
        return currentRoot.count > 0
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        var currentRoot = root
        prefix.forEach {
            val index = it - 'a'
            val trieNode = currentRoot.children[index] ?: return false
            currentRoot = trieNode
        }
        return true
    }

    private class TrieNode(var char: Char) {
        var children = Array<TrieNode?>(26) { null }
        var count = 0
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */