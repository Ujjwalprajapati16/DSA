import java.util.HashMap;

public class Valid_anagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (map.get(ch) != null) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }

        return map.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("care", "race"));
        System.out.println(isAnagram("heart", "earth"));
        System.out.println(isAnagram("tulip", "lipid"));
    }
}
