class Solution {
    public boolean canPartition(int[] nums) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        // Total sum must be even
        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;

        // dp[i] = can we make sum i?
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for (int num : nums) {

            // Go backwards so each number is used only once
            for (int i = target; i >= num; i--) {

                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];
    }
}