class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int even = 0, odd = 0;

        for(int i = 0; i < n; i++){
            if((i & 1) == 0){
                even += nums[i];
            }else{
                odd +=nums[i];
            }
        }
        int leftEven = 0 , leftOdd = 0,res = 0;
        for(int i = 0; i < n; i++){
            if((i & 1) == 0){
                if(leftEven + (odd - leftOdd) == leftOdd + (even - leftEven - nums[i])){
                    res++;
                }
                leftEven += nums[i];
            }else{
                if(leftEven + (odd - leftOdd - nums[i]) == leftOdd + (even - leftEven)){
                    res++;
                }
                leftOdd += nums[i];
            }
        }
        return res;
    }
}