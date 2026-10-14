class Solution {
    private static final boolean[] IS_VOWEL = new boolean[26];
    static{
        IS_VOWEL['a' - 'a'] = true;
        IS_VOWEL['e' - 'a'] = true;
        IS_VOWEL['i' - 'a'] = true;
        IS_VOWEL['o' - 'a'] = true;
        IS_VOWEL['u' - 'a'] = true;
    }
    public int vowelConsonantScore(String s) {
        int v = 0, c = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                if(IS_VOWEL[ch - 'a']){
                    v++;
                }else{
                    c++;
                }
            }
        }
        return c == 0 ? 0 : v / c;
    }
}