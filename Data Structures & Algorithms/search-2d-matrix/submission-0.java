class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int end = rows * cols - 1;

        while(start <= end){
            int mid = start +(end - start)/2;

            int row = mid / cols;
            int col = mid % cols;

            int midval = matrix[row][col];

            if(midval == target){
                return true;
            } else if(target < midval){
                end = mid-1;
            } else{
                start = mid+1;
            }
        }
        return false;
    }
}
