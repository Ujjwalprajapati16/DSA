public class Insertion_Sort {
    public static void insertionSort(int arr[]) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            int curr = arr[i];
            int prev = i - 1;

            // finding the correct position
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }

            // placing
            arr[prev + 1] = curr;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 1, 3, 2 };
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
