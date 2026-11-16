public class SimpleHashMap<K, V> {


    public class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

}
