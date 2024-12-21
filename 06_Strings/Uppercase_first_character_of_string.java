public class Uppercase_first_character_of_string {
    public static String ConvertToUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                ch = Character.toUpperCase(str.charAt(i + 1));
                sb.append(ch);
                i++;
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "hi, i'm pikachu";
        System.out.println(ConvertToUpperCase(str));
    }
}
