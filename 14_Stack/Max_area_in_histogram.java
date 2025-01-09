import java.util.Stack;

public class Max_area_in_histogram {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int[] nsr = new int[height.length];
        int[] nsl = new int[height.length];

        // Next smaller right
        Stack<Integer> s = new Stack<>();

        for (int i = height.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsr[i] = height.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // Next smaller left
        s = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // current area
        for (int i = 0; i < height.length; i++) {
            int ht = height[i];
            int wt = nsr[i] - nsl[i] - 1;
            int currentArea = ht * wt;
            maxArea = Math.max(maxArea, currentArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 6, 2, 3 }; // heights of histogram

        System.out.println("Maximum area is " + maxArea(arr));
    }
}
