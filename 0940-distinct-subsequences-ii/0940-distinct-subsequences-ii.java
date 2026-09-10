class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int[] endsWith = new int[26];
        long sum = 0; // Sum of all endsWith[k]

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            
            // New count ending with s.charAt(i) is (sum + 1)
            long newEndsWith = (sum + 1) % MOD;
            
            // Update sum: subtract the old endsWith[idx] and add the newEndsWith
            sum = (sum - endsWith[idx] + newEndsWith + MOD) % MOD;
            
            endsWith[idx] = (int) newEndsWith;
        }

        return (int) sum;
    }
}