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
        int current = Math.max(prev + nums[index], nums[index]);
        maxSum[0] = Math.max(maxSum[0], current);

        return current;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = maxSubArray(nums);
        System.out.println(result);

        sc.close();
    }
}