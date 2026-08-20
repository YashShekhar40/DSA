class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int penalty = 0;
        int maxLight = 0;

        for (int light : lights) {
            maxLight = Math.max(maxLight, light);
        }

        for (int time : arrivalTime) {
            if (time >= maxLight) {
                time %= period;

                if (time >= maxLight) {
                    penalty = Math.max(penalty, period - time);
                }
            }
        }

        return penalty;
    }
}