import java.util.Arrays;
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int maxSum = 0;
        for(int i = 0; i < n/2; i++){
            int pairSum = nums[i] + nums[n - 1 - i];
            if(pairSum > maxSum){
                maxSum = pairSum;
            }
        }
        return maxSum;
    }
}