class Solution {
    public int totalNumbers(int[] digits) {
        // Step 1: Digits ki frequency count karo
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        int count = 0;

        // Step 2: Hundreds digit (1 to 9, non-zero)
        for (int h = 1; h <= 9; h++) {
            if (freq[h] == 0) continue;
            freq[h]--; // Temporary use karo

            // Step 3: Tens digit (0 to 9)
            for (int t = 0; t <= 9; t++) {
                if (freq[t] == 0) continue;
                freq[t]--; // Temporary use karo

                // Step 4: Units digit (0, 2, 4, 6, 8 - strictly even)
                for (int u = 0; u <= 8; u += 2) {
                    if (freq[u] > 0) {
                        count++;
                    }
                }

                freq[t]++; // Backtrack
            }

            freq[h]++; // Backtrack
        }

        return count;
    }
}