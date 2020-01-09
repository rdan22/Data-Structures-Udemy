package StacksChallenge;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
	}
	//checks for palindrome function
	public static boolean checkForPalindrome(String string) {

		//created stack backed by linked list 
        LinkedList<Character> stack = new LinkedList<Character>();
		//StringBuilder used to build original string without punctuation, spaces, and all lower case
        //reads left to right
        StringBuilder stringNoPunctuation = new StringBuilder(string.length());
        String lowerCase = string.toLowerCase();

        //loop through string character by character
        for (int i = 0; i < lowerCase.length(); i++) {
        	//gets us the char in string at position i
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {
            	//push values which have char a to z onto the stack
            	//also append them to the no punctuation StringBuilder
            	//so in the end will have stack with just the letters
            	//but also a StringBuilder containing original punctuation
                stringNoPunctuation.append(c);
                stack.push(c);
            }
        }
       
        //create a reversedString
        StringBuilder reversedString = new StringBuilder(stack.size());
        //now pop them into the new reversedString StringBuilder 
        //reads right to left
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }
        //if reversedString equals stringNoPunctuation, then it is a palindrome
        return reversedString.toString().equals(stringNoPunctuation.toString());
    }
	
}
