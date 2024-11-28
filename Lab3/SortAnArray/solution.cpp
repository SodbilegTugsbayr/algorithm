class Solution
{
public:
  std::vector<int> sortArray(std::vector<int> &nums)
  {
    mergeSort(nums, 0, nums.size() - 1);
    return nums;
  }

private:
  void mergeSort(std::vector<int> &array, int low, int high)
  {
    if (low >= high)
    {
      return;
    }
    int mid = low + (high - low) / 2;
    mergeSort(array, low, mid);
    mergeSort(array, mid + 1, high);
    merge(array, low, mid, high);
  }

  void merge(std::vector<int> &array, int low, int mid, int high)
  {
    int n1 = mid - low + 1;
    int n2 = high - mid;

    std::vector<int> leftPart(n1);
    std::vector<int> rightPart(n2);

    std::copy(array.begin() + low, array.begin() + mid + 1, leftPart.begin());
    std::copy(array.begin() + mid + 1, array.begin() + high + 1, rightPart.begin());

    int p1 = 0, p2 = 0, writeInd = low;
    while (p1 < n1 && p2 < n2)
    {
      if (leftPart[p1] <= rightPart[p2])
      {
        array[writeInd++] = leftPart[p1++];
      }
      else
      {
        array[writeInd++] = rightPart[p2++];
      }
    }

    while (p1 < n1)
    {
      array[writeInd++] = leftPart[p1++];
    }

    while (p2 < n2)
    {
      array[writeInd++] = rightPart[p2++];
    }
  }
};