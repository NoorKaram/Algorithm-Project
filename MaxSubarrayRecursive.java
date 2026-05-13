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

        Scanner scanner = new Scanner(System.in);

        String input;

        int index;

        while (true) {

            System.out.print("Enter number of elements: ");

            input = scanner.next();

            boolean valid = true;

            for (int i = 0; i < input.length(); i++) {

                char c = input.charAt(i);

                if (c < '0' || c > '9') {
                    valid = false;
                    break;
                }
            }

            if (valid) {

                index = Integer.parseInt(input);

                break;

            } else {

                System.out.println("Please enter a valid number:");
            }
        }

        int[] nums = new int[index];

        System.out.println("Enter the elements:");

        for (int i = 0; i < index; i++) {

            nums[i] = scanner.nextInt();
        }

        int result = maxSubArray(nums);

        System.out.println("Maximum Subarray Sum = " + result);

        scanner.close();
    }
}
