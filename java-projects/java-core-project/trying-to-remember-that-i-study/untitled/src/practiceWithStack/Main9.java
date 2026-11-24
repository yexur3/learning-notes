package practiceWithStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main9 {
    public static void main(String[] args){
        System.out.println(reverse("hello"));
    }

    public static String reverse(String s){
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (var ch : s.toCharArray()) {
            stack.push(ch);
        }

        while(stack.peek() != null) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
