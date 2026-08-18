class Solution {
    public int[] sortArray(int[] nums) {
        int MIN = -50000, MAX = 50000;
        int OFFSET = 50000;
        int RANGE = MAX - MIN + 1;

        int [] freq = new int[RANGE];
        for(int num : nums){
            freq[num + OFFSET]++;
        }
        int index = 0;
        for(int i = 0; i < RANGE; i++){
            int num = i - OFFSET;
            int count = freq[i];

            for(int j = 0; j < count; j++){
                nums[index++] = num;
            }
        }
        return nums;
    }
}