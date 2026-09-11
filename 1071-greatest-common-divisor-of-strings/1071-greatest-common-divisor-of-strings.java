class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // Step 1: Check if str1 and str2 share a common base string
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        
        // Step 2: Find the GCD of the lengths of both strings
        int gcdLength = gcd(str1.length(), str2.length());
        
        // Step 3: Return the prefix of length gcdLength
        return str1.substring(0, gcdLength);
    }
    
    // Euclidean algorithm to calculate GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna