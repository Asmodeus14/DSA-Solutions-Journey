class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String current = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int count = 1;
            char prev = current.charAt(0);
            for (int j = 1; j < current.length(); j++) {
                char c = current.charAt(j);
                if (c == prev) {
                    count++;
                } else {
                    next.append(count).append(prev);
                    count = 1;
                    prev = c;
                }
            }
            next.append(count).append(prev);
            current = next.toString();
        }
        return current;
    }
}