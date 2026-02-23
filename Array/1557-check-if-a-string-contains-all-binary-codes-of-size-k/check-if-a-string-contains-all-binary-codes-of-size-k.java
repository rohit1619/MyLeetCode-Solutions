class Solution {

    public boolean hasAllCodes(String s, int k) {

        int needed = 1 << k;  // 2^k
        boolean[] seen = new boolean[needed];

        int count = 0;
        int mask = 0;

        for (int i = 0; i < s.length(); i++) {

            // Shift left and add current bit
            mask = ((mask << 1) & (needed - 1)) 
                    | (s.charAt(i) - '0');

            // Start checking after first k-1 characters
            if (i >= k - 1) {

                if (!seen[mask]) {
                    seen[mask] = true;
                    count++;
                }

                if (count == needed)
                    return true;
            }
        }

        return false;
    }
}