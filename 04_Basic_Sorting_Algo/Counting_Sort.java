public class Counting_Sort {
    public static void countingSort(int arr[]){
        int N = arr.length;
        // find the largest element for range of count array
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            largest = Math.max(largest, arr[i]);
        }

        // creating the count array and filling with frequency
        int[] count = new int[largest+1];
        for(int i=0; i<N; i++){
            count[arr[i]]++;
        }

        // Sorting the original array
        int j = 0;
        for(int i=0; i<count.length; i++){
            while(count[i] > 0){
                arr[j++] = i;
                count[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 5, 6, 2, 8, 2, 5, 9};
        countingSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
