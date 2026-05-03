import java.util.Scanner;

public class MaxSubarrayRecursive {

    public static int maxSubArray(int[] nums) {
        int[] maxSum = {nums[0]};
        helper(nums, nums.length - 1, maxSum);
        return maxSum[0];
    }

    private static int helper(int[] nums, int index, int[] maxSum) {
        if (index == 0) {
            return nums[0];
        }

        int prev = helper(nums, index - 1, maxSum);

        int current;
        if (prev + nums[index] > nums[index]) {
            current = prev + nums[index];
        } else {
            current = nums[index];
        }

        if (current > maxSum[0]) {
            maxSum[0] = current;
        }

        return current;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = maxSubArray(nums);
        System.out.println(result);

        sc.close();
    }
}
