public class Array_Sorted_check {
    public static boolean isSorted(int[] arr, int i) {
        //base case
        if(i == arr.length-1){
            return true;
        }

        //work
        if(arr[i] > arr[i+1]){
            return false;
        }

        // recursive call
        return isSorted(arr, i+1);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(isSorted(arr, 0));

        int[] arr2 = {1, 2, 3, 4, 6, 5};
        System.out.println(isSorted(arr2, 0));
    }
}
