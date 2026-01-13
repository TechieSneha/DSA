class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        // Step 1: Compute total area and search range
        for (int[] sq : squares) {
            int y = sq[1];
            int side = sq[2];
            totalArea += (double) side * side;
            low = Math.min(low, y);
            high = Math.max(high, y + side);
        }

        double target = totalArea / 2.0;

        // Step 2: Binary search
        for (int i = 0; i < 100; i++) { // precision loop
            double mid = (low + high) / 2.0;

            if (areaBelow(squares, mid) < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low; 
    }
    private double areaBelow(int[][] squares, double h) {
        double area = 0;

        for (int[] sq : squares) {
            double y = sq[1];
            double side = sq[2];

            if (h <= y) {
                continue;
            } else if (h >= y + side) {
                area += side * side;
            } else {
                area += (h - y) * side;
            }
        }

        return area;
    }
}