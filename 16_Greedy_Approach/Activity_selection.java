
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Activity_selection {
    public static void printMaxActivities(int start[], int end[]) {
        int maxAct = 0;
        ArrayList<Integer> list = new ArrayList<>();

        // sorting the activities according to finish time
        int activities[][] = new int[start.length][3];

        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i; // index
            activities[i][1] = start[i]; // start
            activities[i][2] = end[i]; // end
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // choose first activity
        list.add(activities[0][0]);
        maxAct = 1;

        int lastEnd = activities[0][2];

        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) {
                list.add(activities[i][0]);
                lastEnd = activities[i][2];
                maxAct++;
            }
        }

        System.out.println("Maximum number of activities: " + maxAct);

        for (int i = 0; i < list.size(); i++) {
            System.out.print("A" + list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        printMaxActivities(start, end);

        // Time Complexity: O(nlogn)
        // Auxiliary Space: O(n)

        start = new int[] { 10, 12, 20 };
        end = new int[] { 20, 25, 30 };

        printMaxActivities(start, end);

        start = new int[] { 1, 2, 3, 4, 5 };
        end = new int[] { 3, 4, 6, 7, 8 };

        printMaxActivities(start, end);
    }
}
