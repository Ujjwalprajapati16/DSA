public class Decreasing_order {
    public static void printDecreasing(int n) {
        // base case
        if(n == 0){
            return;
        }

        // work
        System.out.println(n);

        // inner call
        printDecreasing(n-1);
    }
    public static void main(String[] args) {
        int n = 5;
        printDecreasing(n);
    }
}