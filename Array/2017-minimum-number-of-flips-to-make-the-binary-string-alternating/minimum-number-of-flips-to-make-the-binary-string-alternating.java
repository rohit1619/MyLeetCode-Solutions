class Solution {
    public int minFlips(String s) {

        int n = s.length();
        String s2 = s + s;

        int diff1 = 0, diff2 = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < s2.length(); i++) {

            char expected1 = (i % 2 == 0) ? '0' : '1';
            char expected2 = (i % 2 == 0) ? '1' : '0';

            if (s2.charAt(i) != expected1) diff1++;
            if (s2.charAt(i) != expected2) diff2++;

            if (i >= n) {

                char prev = s2.charAt(i - n);

                char prevExp1 = ((i - n) % 2 == 0) ? '0' : '1';
                char prevExp2 = ((i - n) % 2 == 0) ? '1' : '0';

                if (prev != prevExp1) diff1--;
                if (prev != prevExp2) diff2--;
            }

            if (i >= n - 1) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
}