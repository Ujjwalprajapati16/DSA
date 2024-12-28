public class Quick_Sort {
    public static void quickSort(int[] arr, int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }

        // parition index
        int pIdx = partition(arr, si, ei);

        // recursive calls
        quickSort(arr, si, pIdx - 1);
        quickSort(arr, pIdx + 1, ei);
    }

    private static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei];
        int pIdx = si;

        for (int i = si; i < ei; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, pIdx);
                pIdx++;
            }
        }
        swap(arr, pIdx, ei);
        return pIdx;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 2, 5, 3, 8, 9, -2 };
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
