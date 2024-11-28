package Lab7.leetcode.TastScheduler;

public class Solution {
  public int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> taskCount = new HashMap<>();
    for (char task : tasks) {
      taskCount.put(task, taskCount.getOrDefault(task, 0) + 1);
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    maxHeap.addAll(taskCount.values());

    int totalIntervals = 0;
    Queue<int[]> cooldownQueue = new LinkedList<>();

    while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
      totalIntervals++;

      if (!maxHeap.isEmpty()) {
        int currentTaskCount = maxHeap.poll();
        if (currentTaskCount > 1) {
          cooldownQueue.offer(new int[] { currentTaskCount - 1, totalIntervals + n });
        }
      }

      if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == totalIntervals) {
        maxHeap.offer(cooldownQueue.poll()[0]);
      }
    }

    return totalIntervals;
  }
}
