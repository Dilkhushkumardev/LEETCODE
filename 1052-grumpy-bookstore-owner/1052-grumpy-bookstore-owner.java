class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int baseSatisfied = 0;
        int currentExtra = 0;

        for(int i = 0; i < n; i++){
            if(grumpy[i] == 0){
                baseSatisfied += customers[i];
            }else if(i < minutes){
                currentExtra += customers[i];
            }
        }
        int maxExtra = currentExtra;
        for(int i = minutes; i < n; i++){
            if(grumpy[i] == 1){
                currentExtra += customers[i];
            }
            if(grumpy[i - minutes] == 1){
                currentExtra -= customers[i - minutes];
            }
            maxExtra = Math.max(maxExtra,currentExtra);
        }
        return baseSatisfied + maxExtra;
    }
}