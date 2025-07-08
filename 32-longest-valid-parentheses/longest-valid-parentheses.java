class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxLen = 0;
        int n = s.length();
        
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }
        
        left = 0;
        right = 0;
        
        
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                right++;
            } else {
                left++;
            }
            
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        
        return maxLen;
    }
}