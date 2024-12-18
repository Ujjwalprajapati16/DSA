public class Pairs {
    public static void printPairs(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
            }
            System.out.println();
        }
        int totalPairs = (arr.length * (arr.length - 1)) / 2;
        System.out.println("Total number of pairs: " + totalPairs);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8, 10 };
        printPairs(arr);
    }
}

/*
 * (2,4) (2,6) (2,8) (2,10)
 * (4,6) (4,8) (4,10)
 * (6,8) (6,10)
 * (8,10)
 * 
 * Total number of pairs: 10
 */