class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int [][] rowPref = new int[m][n];
        int [][] colPref = new int[m][n];

        int [][] mainDiag = new int[m][n];
        int [][] antiDiag = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                rowPref[i][j] = grid[i][j] + (j > 0 ? rowPref[i][j - 1] : 0);
                colPref[i][j] = grid[i][j] + (i > 0 ? colPref[i - 1][j] : 0);
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                mainDiag[i][j] = grid[i][j];
                if(i > 0 && j > 0){
                    mainDiag[i][j] += mainDiag[i - 1][j - 1];
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                antiDiag[i][j] = grid[i][j];
                if(i > 0 && j < n-1){
                    antiDiag[i][j] += antiDiag[i - 1][j + 1];
                }
            }
        }
        for(int k = Math.min(m,n); k >= 2; k--){
            for(int r = 0; r + k <= m; r++){
                for(int c = 0; c + k <= n; c++){
                    int target = rowPref[r][c+k-1] - (c > 0 ? rowPref[r][c-1] : 0);
                    boolean valid = true;
                    for(int i = 0; i < k; i++){
                        int rowSum = rowPref[r+i][c+k-1] - (c > 0 ? rowPref[r+i][c-1] : 0);
                        if(rowSum != target){
                            valid = false;
                            break;
                        }
                    }
                    if(!valid){
                        continue;
                    }
                    for(int j = 0; j < k; j++){
                        int colSum = colPref[r+k-1][c+j] - (r  > 0 ? colPref[r-1][c+j] : 0);
                        if(colSum != target){
                            valid = false;
                            break;
                        }
                    }
                    if(!valid){
                        continue;
                    }
                    int mainSum = mainDiag[r+k-1][c+k-1];
                    if(r > 0 && c > 0) mainSum -= mainDiag[r-1][c-1];
                    if(mainSum != target) continue;

                    int antiSum = antiDiag[r+k-1][c];
                    if(r > 0 && c + k < n ) antiSum -= antiDiag[r-1][c+k];
                    if(antiSum != target) continue;
                    return k;
                }
            }
        }
        return 1;
    }
}