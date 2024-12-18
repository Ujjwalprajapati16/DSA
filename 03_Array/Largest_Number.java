public class Largest_Number {
    public static int LargestNumber(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int idx = 0; idx < arr.length; idx++) {
            if (max < arr[idx]) {
                max = arr[idx];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 6, 8, 1, 5, 9 };
        System.out.println(LargestNumber(arr));
    }
}
