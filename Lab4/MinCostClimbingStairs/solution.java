package Lab4.MinCostClimbingStairs;

class Solution {
  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;

    if (n == 0)
      return 0;
    else if (n == 1)
      return cost[0];

    int[] dp = new int[n];

    dp[0] = cost[0];
    dp[1] = cost[1];

    for (int i = 2; i < n; i++) {
      if (dp[i - 1] > dp[i - 2])
        dp[i] = dp[i - 2] + cost[i];
      else
        dp[i] = dp[i - 1] + cost[i];
    }

    if (dp[n - 2] > dp[n - 1])
      return dp[n - 1];
    else
      return dp[n - 2];
  }
}