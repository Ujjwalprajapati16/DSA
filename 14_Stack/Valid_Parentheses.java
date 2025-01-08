import java.util.Stack;

public class Valid_Parentheses {
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Push opening brackets onto the stack
            if (ch == '(' || ch == '[' || ch == '{') {
                s.push(ch); // This should work with autoboxing
            } else {
                // If stack is empty, no matching opening bracket exists
                if (s.isEmpty()) {
                    return false;
                }
                // Pop from the stack and check for a matching pair
                char top = s.pop();
                if ((top == '(' && ch == ')') ||
                        (top == '[' && ch == ']') ||
                        (top == '{' && ch == '}')) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        // If the stack is empty, all parentheses matched
        return s.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s)); // Expected: true

        String s2 = "([)]";
        System.out.println(isValid(s2)); // Expected: false

        String s3 = "{[]}";
        System.out.println(isValid(s3)); // Expected: true
    }
}
