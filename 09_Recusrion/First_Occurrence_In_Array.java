public class First_Occurrence_In_Array {
    public static int firstOccurrence(int[] arr, int key, int i) {
        // base case
        if (i == arr.length) {
            // not found
            return -1;
        }

        // work
        if (arr[i] == key) {
            return i;
        }

        // recursive call
        return firstOccurrence(arr, key, i + 1);
    }

    public static int lastOccurrence(int[] arr, int key, int i) {
        // base case
        if (i == arr.length) {
            // not found
            return -1;
        }

        // recursive call
        int index = lastOccurrence(arr, key, i + 1);

        // work
        if (index == -1 && arr[i] == key) {
            return i;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 5, 6, 2, 3 };
        System.out.println(firstOccurrence(arr, 7, 0));
        System.out.println(firstOccurrence(arr, 9, 0));
        System.out.println(lastOccurrence(arr, 6, 0));
    }
}
