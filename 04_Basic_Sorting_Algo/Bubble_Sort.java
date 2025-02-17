public class Bubble_Sort {
    public static void BubbleSort(int arr[]) {
        int N = arr.length;
        for (int turns = 0; turns < N - 1; turns++) {
            for (int j = 0; j < N - 1 - turns; j++) {
                // swapping
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 1, 3, 2 };
        BubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
