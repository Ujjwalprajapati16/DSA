public class Subarrays {
    public static void printSubarrays(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println(" ");
            }
            System.out.println();
        }
        int totalSubarrays = (arr.length * (arr.length + 1)) / 2;
        System.out.println("Total number of subarrays: " + totalSubarrays);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8, 10 };
        printSubarrays(arr);
    }
}

/*
 * 2
 * 2 4
 * 2 4 6
 * 2 4 6 8
 * 2 4 6 8 10
 * 
 * 4
 * 4 6
 * 4 6 8
 * 4 6 8 10
 * 
 * 6
 * 6 8
 * 6 8 10
 * 
 * 8
 * 8 10
 * 
 * 10
 * 
 * Total number of subarrays: 15
 */