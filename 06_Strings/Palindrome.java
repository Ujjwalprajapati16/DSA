public class Palindrome {
    public static boolean isPalindrome(String str){
        int N = str.length();
        for(int i=0; i<N/2; i++){
            if(str.charAt(i) != str.charAt(N-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "malayalam";
        System.out.println(isPalindrome(str));

        str = "hello";
        System.out.println(isPalindrome(str));
    }
}
