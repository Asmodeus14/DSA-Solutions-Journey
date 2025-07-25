class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers and non-zero numbers ending with 0 are not palindromes
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        
        int reversed = 0;
        // Reverse only half of the number
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        
        // Check for palindrome (even and odd length cases)
        return x == reversed || x == reversed / 10;
    }
}