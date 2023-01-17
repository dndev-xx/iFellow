package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(isValid("(()")); // 2 - ()
        System.out.println(isValid(")()())")); // 4 - ()()
        System.out.println(isValid(")(()())")); // 6 - (()())
        System.out.println(isValid(")(")); // 0
        System.out.println(isValid("())(()())(()")); // 10 - ()(()())()
    }

    public static Map<Integer, StringBuilder> isValid(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder rsl = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(c);
            } else if (c == ')' && !st.isEmpty() && st.peek() == '(') {
                st.pop();
            } else {
                if (i == 0) {
                    rsl.deleteCharAt(i);
                } else {
                    rsl.deleteCharAt(i - 1);
                }
            }
        }
        while (!st.isEmpty()) {
            char x = st.pop();
            for (int i = rsl.length() - 1; i >= 0; i--) {
                if (x == rsl.charAt(i)) {
                    rsl.deleteCharAt(i);
                    break;
                }
            }
        }
        return new HashMap<>() {{
            put(rsl.length(), rsl);
        }};
    }
}