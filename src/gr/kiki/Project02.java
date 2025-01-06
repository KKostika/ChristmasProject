package gr.kiki;

public class Project02 {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubArraySum(arr);
        System.out.println("Το μέγιστο άθροισμα υποπίνακα είναι: " + maxSum);
    }

        public static int maxSubArraySum(int[] arr) {
            int maxSoFar = arr[0];
            int maxEnd = arr[0];

            for (int i = 1; i < arr.length; i++) {
                maxEnd = Math.max(arr[i], maxEnd + arr[i]);
                maxSoFar = Math.max(maxSoFar, maxEnd);
            }
            return maxSoFar;
        }


    }

