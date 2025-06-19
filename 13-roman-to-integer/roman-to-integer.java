class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        int sum = 0;
        int prev = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int current = 0;
            switch (ch) {
                case 'I': current = 1; break;
                case 'V': current = 5; break;
                case 'X': current = 10; break;
                case 'L': current = 50; break;
                case 'C': current = 100; break;
                case 'D': current = 500; break;
                case 'M': current = 1000; break;
            }
            if (current < prev) {
                sum -= current;
            } else {
                sum += current;
            }
            prev = current;
        }
        return sum;
    }
}