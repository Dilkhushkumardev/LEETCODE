class Solution {
    public char findKthBit(int n, int k){
        return findKthBitHelper(n,k);
    }
    private char findKthBitHelper(int n, int k) {
        if(n == 1){
            return '0';
        }
        int mid = 1 << (n - 1);
        if(k == mid){
            return '1';
        }else if(k < mid){
            return findKthBitHelper(n - 1, k);
        }else{
            int symetricPos = 2 * mid - k;
            char bit = findKthBitHelper(n - 1, symetricPos);
            return bit == '0' ? '1' : '0';
        }
    }
}