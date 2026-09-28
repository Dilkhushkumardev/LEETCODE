class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int MOD = 1_000_000_007;
        int[] hGaps = getAllGaps(m, hFences);
        int[] vGaps = getAllGaps(n, vFences);

        Arrays.sort(hGaps);
        Arrays.sort(vGaps);

        int i = hGaps.length - 1;
        int j = vGaps.length - 1;

        while(i >= 0 && j >= 0){
            if(hGaps[i] == vGaps[j]){
                long area = (long) hGaps[i] * vGaps[j];
                return (int)(area % MOD);
            }else if(hGaps[i] > vGaps[j]){
                i--;
            }else{
                j--;
            }
        }
        return -1;
    }
    private int[] getAllGaps(int boundary, int[] fences){
        Set<Integer> positions = new HashSet<>();
        positions.add(1);
        positions.add(boundary);
        for(int fence : fences){
            positions.add(fence);
        }
        int[] posArr = new int[positions.size()];
        int idx = 0;
        for(int pos : positions){
            posArr[idx++] = pos;
        }
        Arrays.sort(posArr);
        Set<Integer> gaps = new HashSet<>();
        for(int i = 0; i < posArr.length; i++){
            for(int j = i + 1; j < posArr.length; j++){
                gaps.add(posArr[j] - posArr[i]);
            }
        }
        int[] result = new int[gaps.size()];
        idx = 0;
        for(int gap : gaps){
            result[idx++] = gap;
        }
        return result;
    }
}