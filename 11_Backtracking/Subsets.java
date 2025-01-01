public class Subsets {
    public static void findSubsets(String str, String ans, int idx) {
        // base case
        if (idx == str.length()) {
            System.out.println(ans);
            return;
        }

        // Yes
        findSubsets(str, ans + str.charAt(idx), idx + 1);

        // No
        findSubsets(str, ans, idx + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        findSubsets(str, "", 0);
    }
}
