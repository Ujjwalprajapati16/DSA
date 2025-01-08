import java.util.Stack;

public class Reverse_a_string_using_a_stack {
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();

        for (int idx = 0; idx < str.length(); idx++) {
            s.push(str.charAt(idx));
        }

        StringBuilder res = new StringBuilder();

        while (!s.isEmpty()) {
            res.append(s.pop());
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String str = "hello world";
        String reversed = reverseString(str);
        System.out.println(reversed);
    }
}
