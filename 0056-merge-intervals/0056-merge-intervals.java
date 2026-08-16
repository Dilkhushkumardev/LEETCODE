class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }

        int[][] starts = new int[10001][];
        for(int[] interval : intervals){
            int start = interval[0];
            if(starts[start] == null || starts[start][1] < interval[1]){
                starts[start] = interval;
            }
        }
        List<int[]> result = new ArrayList<>();
        int[] current = null;

        for(int i = 0; i <= 10000; i++){
            if(starts[i] != null){
                if(current == null){
                    current = starts[i];
                }else if(starts[i][0] <= current[1]){
                    current[1] = Math.max(current[1], starts[i][1]);
                }else{
                    result.add(current);
                    current = starts[i];
                }
            }
        } 
        if(current != null){
            result.add(current);
        }
        return result.toArray(new int[result.size()][]);
    }
}