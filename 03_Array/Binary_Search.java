public class Binary_Search {
    public static int BinarySearch(int arr[], int key) {
        int left = 0;
        int right = arr.length;

        while (left <= right) {
            int mid = (left + right) / 2;

            // comparisons
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8, 10, 12, 16 };
        int key = 6;

        int index = BinarySearch(arr, key);
        if (index == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + index);
        }
    }
}
