public class Selection_Sort {
    public static void selectionSort(int arr[]) {
        int N = arr.length;
        for(int i=0; i<N-1; i++) {
            int minIndex = i;
            for(int j=i+1; j<N; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //swap
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 1, 3, 2 };
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
