import java.util.LinkedHashMap;

public class LHM {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("India", 500);
        map.put("China", 100);
        map.put("US", 100);
        map.put("UK", 100);
        map.put("Nepal", 100);
        map.put("China", 200);
        System.out.println(map); // {India=500, China=200, US=100, UK=100, Nepal=100}
    }
}
