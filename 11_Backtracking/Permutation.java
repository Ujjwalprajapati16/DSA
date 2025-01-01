public class Permutation {
    public static void findPermutations(String str, String ans) {
        // base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        // rec case
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i+1);
            findPermutations(ros, ans + ch);
        }
    }
    public static void main(String[] args) {
        String str = "abc";
        findPermutations(str, "");
    }
}
