/**
 * [295] Find Median from Data Stream
 *
 * https://leetcode-cn.com/problems/find-median-from-data-stream/description/
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * For example,
 *
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 *
 *
 *
 * Example:
 *
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 *
 *
 *
 * Follow up:
 *
 *
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 *
 *
 *
 * Difficulty:     Hard
 * TestCase:       ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"], [[],[1],[2],[],[3],[]]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._295

class MedianFinder() {

    /** initialize your data structure here. */

    private val numbers = arrayListOf<Int>()

    fun addNum(num: Int) {
        val insert = numbers.indexOfFirst { it > num }
        if (insert < 0) {
            numbers.add(num)
        } else {
            numbers.add(insert, num)
        }
    }

    fun findMedian(): Double {
        val size = numbers.size
        return if (size % 2 == 0) {
            (numbers[size / 2 - 1] + numbers[size / 2]) / 2.0
        } else {
            numbers[size / 2] * 1.0
        }
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */