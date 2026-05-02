public class MaxSubarrayRecursive {

    static int maxSum;

    public static int maxSubArray(int[] nums) {
        maxSum = nums[0];
        helper(nums, nums.length - 1);
        return maxSum;
    }

    private static int helper(int[] nums, int index) {
        if (index == 0) {
            return nums[0];
        }

        int prev = helper(nums, index - 1);

        int current;
        if (prev + nums[index] > nums[index]) {
            current = prev + nums[index];
        } else {
            current = nums[index];
        }

        if (current > maxSum) {
            maxSum = current;
        }

        return current;
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 4, -1};
        System.out.println(maxSubArray(nums));
    }
}