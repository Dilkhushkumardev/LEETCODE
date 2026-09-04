class Solution {
    private static final int BASE = 131;
    private static final long MOD = 1_000_000_007L;

    public String shortestPalindrome(String s) {
        int n = s.length();
        if(n == 0){
            return "";
        }
        long[] pow = new long[n + 1];
        pow[0] = 1;
        for(int i = 1; i <= n; i++){
            pow[i] = (pow[i - 1] * BASE) % MOD;
        }
        long hashForward = 0, hashReverse = 0;
        int longestPalPrefix = 0;

        for(int i = 0; i < n; i++){
            int c = s.charAt(i) - 'a' + 1;

            hashForward = (hashForward * BASE + c) % MOD;
            hashReverse = (hashReverse + c * pow[i]) % MOD;

            if(hashForward == hashReverse){
                longestPalPrefix = i + 1;
            }
        }
        String toAdd = s.substring(longestPalPrefix);
        String reversedToAdd = new StringBuilder(toAdd).reverse().toString();
        return reversedToAdd + s;
    }
}