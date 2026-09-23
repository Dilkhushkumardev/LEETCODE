class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12){
            return result;
        }
        restore(result, s, new char[s.length() + 3], 0, 0, 0);
        return result;
    }
    private void restore(List<String> result, String s,char[] ip, int idx,
    int start, int segment){
        if(segment == 4){
            if(start == s.length()){
                result.add(new String(ip));
            }
            return;
        }
        if(segment > 0 ){
            ip[idx++] = '.';
        }
        int num = 0;
        for(int i = 0; i < 3 && start + i < s.length(); i++){
            num = num * 10 + (s.charAt(start + i) - '0');
            if(num > 255 || (i > 0 && s.charAt(start) == '0')){
                break;
            }
            ip[idx + i] = s.charAt(start + i);
            restore(result, s, ip, idx + i + 1, start + i + 1, segment + 1);
        }
    }
}