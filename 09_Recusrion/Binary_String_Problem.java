public class Binary_String_Problem {
    // they should not have cosecutive ones
    public static void binaryString(int n, int lastPlace, String str) {
        // base case
        if (n == 0) {
            System.out.println(str);
            return;
        }

        // recursive call
        binaryString(n - 1, 0, str + "0");
        if (lastPlace == 0) {
            binaryString(n - 1, 1, str + "1");
        }
    }

    public static void main(String[] args) {
        int n = 3;
        binaryString(n, 0, "");
    }
}