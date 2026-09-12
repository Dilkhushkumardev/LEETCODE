class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if(m < n){
            return minimumDeleteSum(s2, s1);
        }
        int[] dp = new int[n+1];

        for(int j = 1; j <= n; j++){
            dp[j] = dp[j - 1] + s2.charAt(j - 1);
        }
        for(int i = 1; i <= m; i++){
            int prev = dp[0];
            dp[0] += s1.charAt(i - 1);

            for(int j = 1; j <= n; j++){
                int temp = dp[j];

                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[j] = prev;
                }else{
                    int deleteFromS1 = dp[j] + s1.charAt(i - 1);
                    int deleteFromS2 = dp[j - 1] + s2.charAt(j - 1);
                    dp[j] = Math.min(deleteFromS1, deleteFromS2);
                }
                prev = temp;
            }
        }
        return dp[n];
    }
}