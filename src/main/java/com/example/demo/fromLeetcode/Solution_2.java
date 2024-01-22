package com.example.demo.fromLeetcode;

import java.util.Stack;

// 7 ЗАДАЧА ИЗ СПИСКА BLIND CURATED 75
public class Solution_2 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>(); // Создали стек
        for (char c : s.toCharArray()) { // Превращаем строку в массив и перебираем его
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
