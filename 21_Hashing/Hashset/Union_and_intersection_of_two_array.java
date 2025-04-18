import java.util.HashSet;

public class Union_and_intersection_of_two_array {
    public static int union(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        return set.size();
    }

    public static int intersection(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr1){
            set.add(i);
        }
        
        int count = 0;
        for(int i : arr2){
            if(set.contains(i)){
                count++;
                set.remove(i);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 2, 9, 4};

        System.out.println("Union = " + union(arr1, arr2));
        System.out.println("Intersection = " + intersection(arr1, arr2));
    }
}
