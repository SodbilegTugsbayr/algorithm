class Solution
{
public:
  int leastInterval(vector<char> &tasks, int n)
  {
    unordered_map<char, int> taskCount;
    for (char task : tasks)
    {
      taskCount[task]++;
    }

    priority_queue<int> maxHeap;
    for (const auto &entry : taskCount)
    {
      maxHeap.push(entry.second);
    }

    int totalIntervals = 0;
    queue<pair<int, int>> cooldownQueue;
    while (!maxHeap.empty() || !cooldownQueue.empty())
    {
      totalIntervals++;
      if (!maxHeap.empty())
      {
        int currentTaskCount = maxHeap.top();
        maxHeap.pop();
        if (currentTaskCount > 1)
        {
          cooldownQueue.push({currentTaskCount - 1, totalIntervals + n});
        }
      }

      if (!cooldownQueue.empty() && cooldownQueue.front().second == totalIntervals)
      {
        maxHeap.push(cooldownQueue.front().first);
        cooldownQueue.pop();
      }
    }

    return totalIntervals;
  }
};
