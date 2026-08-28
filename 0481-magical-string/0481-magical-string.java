class Solution {
    public int magicalString(int n) {
        if(n <= 0)
        {
            return 0;
        }
        if(n <= 3)
        {
            return 1;
        }
        int[] magic = new int[n];
        magic[0] = 1;
        magic[1] = 2;
        magic[2] = 2;

        int head = 2;
        int tail = 3;
        int currentNum = 1;
        int onesCount = 1;

        while(tail < n){
            int count = magic[head];
            for(int i = 0; i < count && tail < n; i++){
                magic[tail] = currentNum;
                if(currentNum == 1){
                    onesCount++;
                }tail++;
            }
            currentNum = 3 - currentNum;
            head++;
        }
        return onesCount;
    }
}