class Solution {
    public int myAtoi(String s) {
        int index = 0;
        int sign = 1;
        int result = 0;
        int n = s.length();
        
        // 1. Skip leading whitespace
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        
        // 2. Check for sign
        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }
        
        // 3. Process digits
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            
            // 4. Check for integer overflow
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            index++;
        }
        
        return result * sign;
    }
}