class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }
        
        int negatives = 0;
        if (dividend > 0) {
            dividend = -dividend;
            negatives++;
        }
        if (divisor > 0) {
            divisor = -divisor;
            negatives++;
        }
        
        int quotient = 0;
        while (dividend <= divisor) {
            int power = 1;
            int temp = divisor;
            while (temp >= dividend - temp) {
                temp += temp;
                power += power;
            }
            dividend -= temp;
            quotient += power;
        }
        
        if (negatives == 1) {
            return -quotient;
        }
        return quotient;
    }
}