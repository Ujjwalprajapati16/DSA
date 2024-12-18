public class Trapped_Rainwater {
    public static int trappedWater(int heights[]) {
        int n = heights.length;
        // calculate left max boundary
        int leftMax[] = new int[n];
        leftMax[0] = heights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }

        // calculate right max boundary
        int rightMax[] = new int[n];
        rightMax[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }

        int trappedWater = 0;
        // loop
        for (int i = 0; i < n; i++) {
            // waterlevel = min(leftmax, rightmax)
            int waterlevel = Math.min(leftMax[i], rightMax[i]);
            // tarpped water = waterlevel - height
            trappedWater += waterlevel - heights[i];
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int heights[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println(trappedWater(heights));
    }
}
