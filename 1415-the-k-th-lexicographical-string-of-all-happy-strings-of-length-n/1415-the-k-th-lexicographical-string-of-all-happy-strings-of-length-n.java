class Solution {
    public String getHappyString(int n, int k) {
        int total = 3 * ( 1 << (n - 1));
        if(k > total){
            return "";
        }
        StringBuilder result = new StringBuilder();
        char prev = ' ';
        for(int pos = 0; pos < n; pos++){
            int remaining = n - pos - 1;
            int subCount = 1 << remaining;

            for(char c = 'a'; c <= 'c'; c++){
                if(c == prev){
                    continue;
                }
                if(k > subCount){
                    k -= subCount;
                }else{
                    result.append(c);
                    prev = c;
                    break;
                }
            }
        }
        return result.toString();
    }
}