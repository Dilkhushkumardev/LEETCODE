class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long total = 0;
        for(int num : nums){
            total +=  num;
        }
        int target = (int)(total % p);

        if(target == 0){
            return 0;
        }

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        
        long prefixsum = 0;
        int minLength = n;

        for(int i = 0; i < n; i++){
            prefixsum += nums[i];
            int currentMod = (int)(prefixsum % p);
            
            int needed = (currentMod - target + p) % p;

            if(map.containsKey(needed)){
                int length = i - map.get(needed);
                if(length < n){
                    minLength = Math.min(minLength,length);
                    if(minLength == 1){
                        return 1;
                    }
                }
            }
            map.put(currentMod,i);
        }
        return minLength == n ? -1 : minLength;
    }
}