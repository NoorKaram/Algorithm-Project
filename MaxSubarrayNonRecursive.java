import java.util.Scanner;

public class  MaxSubarrayNonRecursive {

    public static int maxSubarray(int[] nums, int index) {

        if (index == 0) {
            return 0;
        }

        int current = nums[0];
        int maxsum = nums[0];

        for (int i = 1; i < index ; i++) {

            if (nums[i] > current + nums[i]) {
                current = nums[i];
            } else {
                current = current + nums[i];
            }

            if (current > maxsum) {
                maxsum = current;
            }
        }

        return maxsum;
    }
     public static int readInt(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.print("Please enter a valid number: ");
                scanner.next();  
            }
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int index = readInt(scanner);

        int[] nums = new int[index];

        System.out.println("Enter the elements:");

        for (int i = 0; i < index ; i++) {
            nums[i] = readInt(scanner);
        }

        int result = maxSubarray(nums, index );

        System.out.println("Maximum Subarray Sum = " + result);

        scanner.close();
    }
}