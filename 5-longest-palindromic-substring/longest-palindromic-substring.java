class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        
        // Preprocess the string to handle even-length palindromes uniformly
        char[] T = preprocess(s);
        int n = T.length;
        int[] P = new int[n];  // P[i] = radius of longest palindrome centered at i
        int C = 0;  // Center of the current rightmost palindrome
        int R = 0;  // Right boundary of the current rightmost palindrome

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * C - i;  // Mirror of i around center C
            
            // Initialize P[i] using symmetry within the current palindrome
            if (i < R) 
                P[i] = Math.min(R - i, P[mirror]);
            
            // Expand around center i beyond the mirrored palindrome
            while (T[i + P[i] + 1] == T[i - P[i] - 1]) 
                P[i]++;
            
            // Update center and right boundary if palindrome centered at i expands beyond R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }
        
        // Find the longest palindrome in P[]
        int maxLen = 0;
        int center = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                center = i;
            }
        }
        
        // Extract and return the longest palindrome from original string
        int start = (center - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
    
    // Preprocess the string: ^#a#b#c#$
    private char[] preprocess(String s) {
        char[] T = new char[s.length() * 2 + 3];
        T[0] = '^';
        T[1] = '#';
        int idx = 2;
        for (char c : s.toCharArray()) {
            T[idx++] = c;
            T[idx++] = '#';
        }
        T[idx] = '$';
        return T;
    }
}