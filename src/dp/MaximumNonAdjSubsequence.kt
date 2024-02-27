package dp

import java.util.*
import kotlin.math.max


class MaximumNonAdjSubsequence {
    fun maximumNonAdjacentSum(nums: ArrayList<Int>): Int {
        val dp = IntArray(nums.size + 1)
        Arrays.fill(dp, -1)
        return maximumNonAdjacentSumOpt(nums)
    }
    private fun maximumNonAdjacentSumRec(nums: ArrayList<Int>, `in`: Int): Int {
        if (`in` == 0) return nums[`in`]
        if (`in` < 0) return 0
        val pick = nums[`in`] + maximumNonAdjacentSumRec(nums, `in` - 2)
        val notPick = 0 + maximumNonAdjacentSumRec(nums, `in` - 1)
        return max(pick.toDouble(), notPick.toDouble()).toInt()
    }
    // memoization
    private fun maximumNonAdjacentSumMem(nums: ArrayList<Int>, `in`: Int, dp: IntArray): Int {
        if (`in` == 0) return nums[`in`]
        if (`in` < 0) return 0
        if (dp[`in`] != -1) return dp[`in`]
        val pick = nums[`in`] + maximumNonAdjacentSumRec(nums, `in` - 2)
        val notPick = 0 + maximumNonAdjacentSumRec(nums, `in` - 1)
        dp[`in`] = max(pick.toDouble(), notPick.toDouble()).toInt()
        return dp[`in`]
    }
    // Tabulation
    private fun maximumNonAdjacentSumTab(nums: ArrayList<Int>, dp: IntArray): Int {
        val n = nums.size
        dp[0] = nums[0]
        for (i in 1 until n) {
            var pick = nums[i]
            if (i > 1) pick += dp[i - 2]
            val notPick = 0 + dp[i - 1]
            dp[i] = max(pick.toDouble(), notPick.toDouble()).toInt()
        }
        return dp[n - 1]
    }
    // space optimization
    private fun maximumNonAdjacentSumOpt(nums: ArrayList<Int>): Int {
        val n = nums.size
        var prev = nums[0]
        var prev2 = 0
        for (i in 1 until n) {
            val pick = nums[i] + prev2
            val notPick = prev
            val curr = max(pick.toDouble(), notPick.toDouble()).toInt()
            prev2 = prev
            prev = curr
        }
        return prev
    }
}