class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][]  prefix = new int[m + 1][n + 1];
        int maxLen = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                prefix[i][j] = mat[i - 1][j - 1] 
                             + prefix[i - 1][j]
                             +prefix[i][j - 1]
                             -prefix[i - 1][j - 1];
                if(i > maxLen && j > maxLen){
                    int len = maxLen + 1;
                    int sum = prefix[i][j]
                            - prefix[i - len][j]
                            -prefix[i][j - len]
                            +prefix[i - len][j - len];
                    
                    if(sum <= threshold){
                        maxLen = len;
                    }
                }
            }
        }
        return maxLen;
    }
}