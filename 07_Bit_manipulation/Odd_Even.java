public class Odd_Even {
    public static void isOddEven(int n){
        int bitMask = 1;
        if((n & bitMask) == 0){
            System.out.println(n + " is Even");
        } else {
            System.out.println(n + " is Odd");
        }
    }
    public static void main(String[] args) {
        isOddEven(5);
        isOddEven(6);
    }
}
