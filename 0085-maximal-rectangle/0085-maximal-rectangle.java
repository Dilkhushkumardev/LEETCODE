class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;

        int[] heights = new int[cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '1'){
                    heights[j] += 1;
                }else{
                    heights[j ] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
    private int largestRectangleArea(int[] heights){
        int n = heights.length;
        if(n == 0){
            return 0;
        }
        int maxArea = 0;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];

        for(int i = 0; i < n; i++){
            rightSmaller[i] = n;
        }
        int[] stack = new int[n];
        int stackIndex = -1;

        for(int i = 0; i < n; i++){
            while(stackIndex >= 0 && heights[stack[stackIndex]] >= heights[i]){
                rightSmaller[stack[stackIndex]] = i;
                stackIndex--;
            }
            leftSmaller[i] = (stackIndex >= 0) ? stack[stackIndex] : -1;
            stack[++stackIndex] = i;
        }
        for(int i = 0; i < n; i++){
            int width = rightSmaller[i] - leftSmaller[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return  maxArea;
    }
}