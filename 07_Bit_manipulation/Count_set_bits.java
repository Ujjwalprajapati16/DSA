public class Count_set_bits {
    public static int countSetBits(int n){
        int count = 0;
        while(n > 0){
            if((n & 1) == 1){
                count++;
            }
            n = n>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 10;
        int result = countSetBits(n);
        System.out.println("Number of set bits: " + result);
    }
}
