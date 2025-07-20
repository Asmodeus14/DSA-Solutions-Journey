class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        int total_water = 0;
        
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] > left_max) {
                    left_max = height[left];
                } else {
                    total_water += left_max - height[left];
                }
                left++;
            } else {
                if (height[right] > right_max) {
                    right_max = height[right];
                } else {
                    total_water += right_max - height[right];
                }
                right--;
            }
        }
        return total_water;
    }
}