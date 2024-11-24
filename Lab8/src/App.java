import java.util.*;

public class App {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>();
        int result = coinChangeHelper(coins, amount, coins.length - 1, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int coinChangeHelper(int[] coins, int amount, int index, Map<Integer, Integer> memo) {
        if (amount == 0) return 0;
        if (index < 0 || amount < 0) return Integer.MAX_VALUE;
        
        if (memo.containsKey(amount)) return memo.get(amount);

        int includeCoin = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            int next = coinChangeHelper(coins, amount - coins[index], index, memo);
            if (next != Integer.MAX_VALUE) {
                includeCoin = next + 1;
            }
        }

        int excludeCoin = coinChangeHelper(coins, amount, index - 1, memo);

        int result = Math.min(includeCoin, excludeCoin);
        memo.put(amount, result);
        return result;
    }

    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; 

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int primeCount = 0;
        for (boolean prime : isPrime) {
            if (prime) primeCount++;
        }

        return primeCount;
    }

    public int[] assignBikes(int[][] students, int[][] bikes) {
        int n = students.length;
        int m = bikes.length;
        List<int[]> distances = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int dist = Math.abs(students[i][0] - bikes[j][0]) + Math.abs(students[i][1] - bikes[j][1]);
                distances.add(new int[]{dist, i, j});
            }
        }

        distances.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        int[] result = new int[n];
        Arrays.fill(result, -1);

        Set<Integer> assignedBikes = new HashSet<>();

        for (int[] distance : distances) {
            int student = distance[1];
            int bike = distance[2];

            if (result[student] == -1 && !assignedBikes.contains(bike)) {
                result[student] = bike;
                assignedBikes.add(bike);
            }
        }

        return result;
    }
}