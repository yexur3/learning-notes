public class SimpleHashMap<K, V> {

    @SuppressWarnings("unchecked")
    private Node<K, V>[] buckets = (Node<K, V>[]) new Node[16];

    private int size = 0;

    public static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value){
        int index = Math.abs(key.hashCode()) % buckets.length;

        Node<K, V> current = buckets[index];

        while(current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }

            current = current.next;
        }

        var newNode = new Node<>(key, value);

        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }

}
