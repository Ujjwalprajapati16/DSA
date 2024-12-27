public class Sum_of_first_natural_numbers {
    public static int sum(int n){
        // base case
        if(n == 1){
            return 1;
        }
        return n + sum(n-1);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(sum(n));
    }
}
