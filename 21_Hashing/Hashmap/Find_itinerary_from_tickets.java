import java.util.HashMap;

public class Find_itinerary_from_tickets {
    public static String getStart(HashMap<String, String> ticktes){
        HashMap<String, String> revMap = new HashMap<>();
        
        for (String key : ticktes.keySet()) {
            revMap.put(ticktes.get(key), key);
        }

        for (String key : ticktes.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }

        return null;
    }
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengalore");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");
        
        String start = getStart(tickets);

        System.out.print(start);
        for(int i = 0; i < tickets.keySet().size(); i++){
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }
    }
}
