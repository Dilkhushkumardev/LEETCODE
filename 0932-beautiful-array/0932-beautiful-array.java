class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        while(list.size() < n){
            List<Integer> next = new ArrayList<>();

            for(int num : list){
                int odd = num * 2 -1;
                if(odd <= n){
                    next.add(odd);
                }
            }
            for(int num : list){
                int even = num * 2;
                if(even <= n){
                    next.add(even);
                }
            }
            list = next;
        }
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            result[i] = list.get(i);
        }
        return result;
    }
}