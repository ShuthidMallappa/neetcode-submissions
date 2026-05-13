class Solution {
    public int maxArea(int[] heights) {
        
        int maxArea=0;
        int area = 0;
        int right=0;
        int left = heights.length-1;
        while (right<left){
            int height = Math.min(heights[right], heights[left]);
            int width = left - right;
            area = height * width;
            maxArea = Math.max(area, maxArea);
            if(heights[right]> heights[left]){
            left--;
        } else {
        right++;
        }
        }
        return maxArea;
    }
}
