class Solution {
    private int index = 0;

    public String decodeString(String s) {
        return decodeStringHelper(s);
    }
    private String decodeStringHelper(String s){
        StringBuilder result = new StringBuilder();

        while(index < s.length() && s.charAt(index) != ']'){
            if(!Character.isDigit(s.charAt(index))){
                result.append(s.charAt(index));
                index++;
            }else{
                int count = 0;
                while(index < s.length() && Character.isDigit(s.charAt(index))){
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                index++;

                String decodeSubstring = decodeStringHelper(s);
                index++;

                for(int i = 0; i < count; i++){
                    result.append(decodeSubstring);
                }
            }
        }
        return result.toString();
    }
}