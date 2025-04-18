import java.util.ArrayList;
import java.util.LinkedList;

@SuppressWarnings("unused")
public class Implementation_of_Hashmap {
    static class Hashmap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList<Node>[] bucket; // N

        @SuppressWarnings("unchecked")
        public Hashmap() {
            this.size = 0;
            this.bucket = new LinkedList[10];

            for (int i = 0; i < 10; i++) {
                this.bucket[i] = new LinkedList<Node>();
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % this.bucket.length;
        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = bucket[bi];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key.equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] newBucket = new LinkedList[this.bucket.length * 2];
            for (int i = 0; i < newBucket.length; i++) {
                newBucket[i] = new LinkedList<Node>();
            }
            for (int i = 0; i < this.bucket.length; i++) {
                LinkedList<Node> ll = this.bucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    int bi = hashFunction(node.key);
                    newBucket[bi].add(node);
                }
            }
            this.bucket = newBucket;
        }

        public void put(K key, V value){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1){
                Node node = bucket[bi].get(di);
                node.value = value;
            } else {
                Node node = new Node(key, value);
                bucket[bi].add(node);
                size++;
            }

            double lambda = (double) size / bucket.length;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            return di != -1;
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1){
                Node node = bucket[bi].get(di);
                return node.value;
            }
            return null;
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1){
                Node node = bucket[bi].get(di);
                bucket[bi].remove(di);
                size--;
                return node.value;
            }
            return null;
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < bucket.length; i++) {
                LinkedList<Node> ll = bucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void clear() {
            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = new LinkedList<Node>();
            }
            size = 0;
        }

        public void display() {
            for (int i = 0; i < bucket.length; i++) {
                LinkedList<Node> ll = bucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    if(node.key.equals(null))
                        continue;
                    System.out.print(node.key + " -> " + node.value + " ");
                }
                if(!ll.isEmpty()){
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        Hashmap<String, Integer> map = new Hashmap<>();
        map.put("India", 500);
        map.put("China", 100);
        map.put("US", 100);
        map.put("UK", 100);
        map.put("Nepal", 100);
        map.put("China", 200);

        map.display();

        System.out.println(map.get("China"));
        map.remove("UK");

        System.out.println(map.containsKey("China"));
        System.out.println(map.size());

        map.clear();
        System.out.println(map.isEmpty());
        map.display();
    }
}

