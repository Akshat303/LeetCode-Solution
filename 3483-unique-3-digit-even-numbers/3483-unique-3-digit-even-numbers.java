class Solution {
    public int totalNumbers(int[] digits) {
        // Step 1: Count digit frequencies in the input array
        int[] available = new int[10];
        for (int d : digits) {
            available[d]++;
        }

        int count = 0;

        // Step 2: Iterate through all 3-digit even numbers
        for (int num = 100; num <= 998; num += 2) {
            int hundreds = num / 100;
            int tens = (num / 10) % 10;
            int units = num % 10;

            // Step 3: Count digits needed for this candidate
            int[] needed = new int[10];
            needed[hundreds]++;
            needed[tens]++;
            needed[units]++;

            // Step 4: Verify if we have enough copies of each digit
            if (available[hundreds] >= needed[hundreds] &&
                available[tens] >= needed[tens] &&
                available[units] >= needed[units]) {
                count++;
            }
        }

        return count;
    }
}