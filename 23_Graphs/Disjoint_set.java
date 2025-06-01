public class Disjoint_set {
    static int n = 9;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for(int i=0; i<n; i++){
            par[i] = i;
        }
    }

    public static int find(int x){
        if(par[x] == x){
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int x, int y){
        int parX = find(x);
        int parY = find(y);

        if(parX != parY){
            if(rank[parX] > rank[parY]){
                par[parY] = parX;
            } else if(rank[parX] < rank[parY]){
                par[parX] = parY;
            } else {
                par[parY] = parX;
                rank[parX]++;
            }
        }
    }

    public static void main(String[] args) {
        init();
        union(1, 2);
        union(2, 3);
        union(4, 5);
        union(6, 8);
        union(5, 6);

        if(find(1) == find(3)){
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }
}
