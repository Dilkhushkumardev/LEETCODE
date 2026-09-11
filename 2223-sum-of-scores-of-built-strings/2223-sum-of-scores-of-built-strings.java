class Solution {
    public long sumScores(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] z = new int[n];

        int l = 0, r = 0;
        z[0] = n;
        for(int i = 1; i < n ; i++){
            if(i <= r){
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while(i + z[i] < n && chars[z[i]] == chars[i + z[i]]){
                z[i]++;
            }
            if(i + z[i] - 1 > r){
                l = i;
                r = i + z[i] - 1;
            }
        }
        long total = 0;
        for(int val : z){
            total += val;
        }
        return total;
    }
}