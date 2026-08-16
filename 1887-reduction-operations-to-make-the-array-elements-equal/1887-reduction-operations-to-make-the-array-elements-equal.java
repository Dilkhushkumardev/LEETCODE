class Solution {
    public int reductionOperations(int[] nums) {
        int max = 0;
        for(int num : nums){
            if(num > max){
                max = num;
            }
        }
        int[] freq = new int[max + 1];
        for(int num : nums){
            freq[num]++;
        }
        int steps = 0;
        int result = 0;

        for(int i = 1; i <= max; i++){
            if(freq[i] > 0){
                result += freq[i] * steps;
                steps++;
            }
        }
        return result;
    }
}