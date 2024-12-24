public class Fast_Exponention {
    public static int fastExpo(int a, int n){
        int ans = 1;
        while(n > 0){
            if((n & 1) == 1){
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int base = 3;
        int power = 5;
        System.out.println(fastExpo(base, power));

        base = 5;
        power = 3;
        System.out.println(fastExpo(base, power));
    }
}
