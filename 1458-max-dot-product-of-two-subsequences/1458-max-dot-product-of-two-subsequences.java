import java.util.Arrays;
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= m; i++){
            int prevRow_j_1 = dp[0];
            dp[0] = Integer.MIN_VALUE;
            for(int j = 1; j <= n; j++){
                int old_dp_j = dp[j];
                int take = nums1[i - 1] * nums2[j - 1] + Math.max(0, prevRow_j_1);
                int skip1 = old_dp_j;
                int skip2 = dp[j - 1];
                dp[j] = Math.max(take, Math.max(skip1, skip2));
                prevRow_j_1 = old_dp_j;
            }
        }
        return dp[n];
    }
}