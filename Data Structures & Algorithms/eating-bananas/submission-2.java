class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;

        // Find maximum pile
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        // Try every possible speed
        for (int k = 1; k <= max; k++) {

            int hours = 0;

            for (int pile : piles) {
                hours += (pile + k - 1) / k;
            }

            // This speed is enough
            if (hours <= h) {
                return k;
            }
        }

        return -1;
    }
}