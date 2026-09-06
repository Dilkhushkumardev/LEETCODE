class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        long base = 131;
        long[] hash = new long[n + 1];
        long[] power = new long[n + 1];

        hash[0] = 0;
        power[0] = 1;

        for(int i = 1; i <= n; i++){
            hash[i] = hash[i - 1] * base + s.charAt(i - 1);
            power[i] = power[i - 1] * base;
        }
        for(int len = n - 1; len >= 1; len--){
            long prefixHash = hash[len];

            long suffixHash = hash[n] - hash[n - len] * power[len];

            if(prefixHash == suffixHash){
                return s.substring(0, len);
            }
        }
        return "";
    }
}