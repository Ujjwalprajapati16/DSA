public class Remove_duplicate_in_a_string {
    public static void removeDuplicate(String str, StringBuilder sb, int i, boolean[] arr) {
        if (i == str.length()) {
            System.out.println(sb);
            return;
        }
        char ch = str.charAt(i);
        if (arr[ch - 'a'] == true) {
            // duplicate
            removeDuplicate(str, sb, i + 1, arr);
        } else {
            arr[ch - 'a'] = true;
            sb.append(ch);
            removeDuplicate(str, sb, i + 1, arr);
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String str = "pikachupikapikachu";
        boolean arr[] = new boolean[26];
        removeDuplicate(str, sb, 0, arr);
        System.out.println(sb);
    }
}
