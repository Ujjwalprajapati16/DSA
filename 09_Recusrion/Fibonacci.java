public class Fibonacci {
    public static int fibonacci(int n) {
        // base case
        if(n == 0 || n == 1){
            return n;
        }

        // call
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(fibonacci(n));
    }
}
