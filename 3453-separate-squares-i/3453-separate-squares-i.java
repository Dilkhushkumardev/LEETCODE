class Solution {
    public double separateSquares(int[][] squares) {
        int n = squares.length;

        double minY = Double.MAX_VALUE;
        double maxY = Double.MIN_VALUE;

        for(int[] square : squares){
            double y = square[1];
            double l = square[2];
            minY = Math.min(minY,y);
            maxY = Math.max(maxY, y + l);
        }
        double totalArea = 0;
        for(int[] square : squares){
            double l = square[2];
            totalArea += l * l;
        }
        double target = totalArea / 2.0;
        
        double left = minY;
        double right = maxY;

        for(int i = 0; i < 60; i++){
            double mid = left + (right - left) / 2;

            double areaAbove = 0.0;
            for(int[] square : squares){
                double y = square[1];
                double l = square[2];
                double top = y + l;

                if(mid <= y){
                    areaAbove += l * l;
                }else if(mid < top){
                    areaAbove += l * (top - mid);
                }
            }
            if(areaAbove > target){
                left = mid;
            }else{
                right = mid;
            }
        }
        return left;
    }
}