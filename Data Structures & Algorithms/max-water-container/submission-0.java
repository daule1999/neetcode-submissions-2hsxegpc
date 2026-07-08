class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            // Calculate the current width
            int width = right - left;
            
            // Find the limiting height
            int currentHeight = Math.min(height[left], height[right]);
            
            // Update max water if the current container holds more
            int currentWater = currentHeight * width;
            maxWater = Math.max(maxWater, currentWater);
            
            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
    }
}