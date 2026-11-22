package practiceWithHashMapTreefy;

public class BadKeyB implements Comparable<BadKeyB>{
    final int id;
    BadKeyB(int id) { this.id = id; }
    @Override public int hashCode() { return 1; }
    @Override public boolean equals(Object o) {
        return o instanceof BadKeyB k && k.id == id;
    }
    @Override public int compareTo(BadKeyB o) { return Integer.compare(id, o.id); }
}
