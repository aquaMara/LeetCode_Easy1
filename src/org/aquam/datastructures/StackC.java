package org.aquam.datastructures;

import java.util.Stack;

public class StackC {

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        System.out.println(stringStack.empty());
        stringStack.push("Minecraft");
        stringStack.push("Skyrim");
        stringStack.push("DOOM");
        stringStack.push("Borderlands");
        System.out.println(stringStack.empty());
        System.out.println(stringStack);
        stringStack.pop();
        String game = stringStack.pop();
        System.out.println(stringStack);
        System.out.println(game);

        System.out.println(stringStack.peek()); // shows top most item

        System.out.println(stringStack.search("Minecraft"));
        System.out.println(stringStack.search("Borderlands"));
    }
}
