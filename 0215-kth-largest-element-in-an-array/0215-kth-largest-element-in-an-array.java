class Solution {
    public int findKthLargest(int[] nums, int k) {
        int MIN = -10000, MAX = 10000;
        int OFFSET = 10000;
        int RANGE = MAX - MIN + 1;

        int[] freq = new int[RANGE];
        for(int num : nums){
            freq[num + OFFSET]++;
        }

        int count = 0;
        for(int i = RANGE - 1; i >= 0; i--){
            count += freq[i];
            if(count >= k){
                return i - OFFSET;
            }
        }
        return 0;
    }
}