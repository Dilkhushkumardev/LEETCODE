class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] last = {-1, -1, -1};

        int result = 0;
        for(int i = 0; i < n; i++){
            last[s.charAt(i) - 'a'] = i;

            int minLast = Math.min(last[0],  Math.min(last[1], last[2]));

            if(minLast != -1){
                result += (minLast + 1);
            }
        }
        return result;
    }
}