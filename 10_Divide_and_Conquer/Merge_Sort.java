public class Merge_Sort {
    public static void mergeSort(int arr[], int si, int ei){
        // base case 
        if(si >= ei){
            return;
        }

        // recursive call
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei); // Corrected the parameters
    }

    public static void merge(int arr[], int si, int mid, int ei){
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        // merging
        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // remaining left elements
        while(i <= mid){
            temp[k++] = arr[i++];
        }

        // remianing right elements
        while(j <= ei){
            temp[k++] = arr[j++];
        }

        // copy elements to original array
        k = 0;
        for(int idx = si; idx <= ei; idx++){
            arr[idx] = temp[k++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8, -2};
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
