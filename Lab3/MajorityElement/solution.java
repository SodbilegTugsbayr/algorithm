package Lab3.MajorityElement;

public class Solution {

  private int majorityElementRec(int[] nums, int left, int right) {
    if (left == right) {
      return nums[left];
    }

    int mid = left + (right - left) / 2;

    int leftMajority = majorityElementRec(nums, left, mid);
    int rightMajority = majorityElementRec(nums, mid + 1, right);

    if (leftMajority == rightMajority) {
      return leftMajority;
    }

    int leftCount = countInRange(nums, leftMajority, left, right);
    int rightCount = countInRange(nums, rightMajority, left, right);

    return leftCount > rightCount ? leftMajority : rightMajority;
  }

  private int countInRange(int[] nums, int val, int left, int right) {
    int count = 0;
    for (int i = left; i <= right; i++) {
      if (nums[i] == val) {
        count++;
      }
    }
    return count;
  }

  public int majorityElement(int[] nums) {
    return majorityElementRec(nums, 0, nums.length - 1);
  }
}