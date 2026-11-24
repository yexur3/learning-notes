package practiceWithSets;

import java.util.Set;
import java.util.TreeSet;

public class Main11 {

    public record Product(String name, double price) implements Comparable<Product> {

        @Override
        public int compareTo (Product o) {
            if (Double.compare(price, o.price) == 0) {
                return name.compareTo(o.name);
            } else {
                return Double.compare(price, o.price);
            }
        }

    }

    public static void main(String[] args) {
        Set<Product> tree = new TreeSet<>();

        tree.add(new Product("banana", 20.0));
        tree.add(new Product("apple", 20.0));
        System.out.println(tree.size());
        System.out.println(tree.add(new Product("cherry", 20.0)));
        System.out.println(tree);
    }
}
