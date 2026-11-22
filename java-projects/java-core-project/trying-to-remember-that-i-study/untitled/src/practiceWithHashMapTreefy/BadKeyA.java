package practiceWithHashMapTreefy;

public class BadKeyA {
    final int id;
    BadKeyA(int id) { this.id = id; }
    @Override public int hashCode() { return 1; }
    @Override public boolean equals(Object o) {
        return o instanceof BadKeyA k && k.id == id;
    }
}
