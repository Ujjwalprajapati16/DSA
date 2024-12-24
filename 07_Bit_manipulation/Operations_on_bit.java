public class Operations_on_bit {
    public static void GetIthbit(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) != 0) {
            System.out.println(i + "th bit of " + n + " is " + "1");
        } else {
            System.out.println(i + "th bit of " + n + " is " + "0");
        }
    }

    public static void SetIthBit(int n, int i){
        int bitMask = 1 << i;
        System.out.println("The value of " + n + " after setting " + i + "th bit to 1 is " + (n | bitMask));
    }

    public static void ClearIthBit(int n, int i){
        int bitMask = ~(1 << i);
        System.out.println("The value of " + n + " after setting " + i + "th bit to 0 is " + (n & bitMask));
    }

    public static void updateIthBit(int n, int i, int newBit){
        int bitMask = ~(1 << i);
        System.out.println("The value of " + n + " after updating " + i + "th bit to " + newBit + " is " + ((n & bitMask) | (newBit << i)));
    }

    public static void clearIthBits(int n, int i){
        int bitMask = (~0) << i;
        System.out.println("The value of " + n + " after clearing " + i + "th bits is " + (n & bitMask));
    }

    public static void isPowerOf2(int n){
        int bitMask = (n & (n-1));
        if(bitMask == 0){
            System.out.println(n + " is a power of 2");
        } else {
            System.out.println(n + " is not a power of 2");
        }
    }

    public static void main(String[] args) {
        GetIthbit(5, 1);
        GetIthbit(5, 2);
        SetIthBit(5, 1);
        ClearIthBit(5, 2);
        updateIthBit(5, 3, 1);
        clearIthBits(15, 2);
        isPowerOf2(16);
    }
}
