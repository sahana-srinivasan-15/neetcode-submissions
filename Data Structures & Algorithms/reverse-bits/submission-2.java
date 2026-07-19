class Solution {
    int[] table = new int[256];

    public Solution() {
        solve();      // initialize lookup table
    }

    public int reverseBits(int n) {
        return (table[n & 0xFF] << 24)
             | (table[(n >>> 8) & 0xFF] << 16)
             | (table[(n >>> 16) & 0xFF] << 8)
             | table[(n >>> 24) & 0xFF];
    }

    private void solve() {
        for (int i = 0; i < 256; i++) {
            int rev = 0;
            int num = i;

            for (int j = 0; j < 8; j++) {
                rev = (rev << 1) | (num & 1);
                num >>= 1;
            }

            table[i] = rev;
        }
    }
}