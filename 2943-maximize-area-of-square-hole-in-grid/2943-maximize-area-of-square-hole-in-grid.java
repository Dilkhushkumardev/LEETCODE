import java.util.Arrays;
class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = getMaxGap(hBars);
        int maxV = getMaxGap(vBars);
        int side = Math.min(maxH, maxV);
        return side* side;
    }
    private int getMaxGap(int[] bars){
        if(bars.length == 0 ){
            return 1;
        }
        Arrays.sort(bars);
        int maxLen = 1;
        int currLen = 1;
        for(int i = 1; i < bars.length; i++){
            if(bars[i] == bars[i - 1] + 1){
                currLen++;
            }else{
                currLen = 1;
            }
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen + 1;
    }
}