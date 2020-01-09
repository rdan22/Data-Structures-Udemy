package QueuesChallenge;

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

	//check for palindrome function
	public static boolean checkForPalindrome(String string) {

		//stack and queue backed by a linked list
		LinkedList<Character> stack = new LinkedList<Character>();
		LinkedList<Character> queue = new LinkedList<Character>();
		//lowercase the string now 
		String lowerCase = string.toLowerCase();
		
		//check whether each char is between a and z
		//then we do a loop, pull one character off queue and pop one character off the stack
		for (int i = 0; i < lowerCase.length(); i++) {
			//get the char 
			char c = lowerCase.charAt(i);
			//for the queue: left to right, stack: right to left
			//if we loop through string, pushing items to stack and adding items to queue, because one is LIFO and other is FIFO
			//if on each iteration we pop one item from stack and remove one item from queue, queue reads string from left to right
			//and stack reads string from right to left
			//if it reads the same, then on each iteration, the characters should equal each other and we have a palindrome
			if (c >= 'a' && c <= 'z') {
				queue.addLast(c);
				stack.push(c);
			}
		}
		//iterate through the stack until it is empty
		while (!stack.isEmpty()) {
			//on each iteration remove one from queue and pop one from stack and compare them 
			if (!stack.pop().equals(queue.removeFirst())) 
			{
				//if not equal, not palindrome
				return false;
			}
		}
		//else equal and is a palindrome
		return true;
	}
}

