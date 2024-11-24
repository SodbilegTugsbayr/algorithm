public class GreedyBST {
    static class KeyFrequency {
        int key;
        int frequency;

        public KeyFrequency(int key, int frequency) {
            this.key = key;
            this.frequency = frequency;
        }
    }

    public int minSearchCost(int[] k, int[] f) {
        int n = k.length;

        KeyFrequency[] keyFreqPairs = new KeyFrequency[n];
        for (int i = 0; i < n; i++) {
            keyFreqPairs[i] = new KeyFrequency(k[i], f[i]);
        }

        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            totalCost += keyFreqPairs[n-i-1].frequency * (i + 1);
        }

        return totalCost;
    }
}
