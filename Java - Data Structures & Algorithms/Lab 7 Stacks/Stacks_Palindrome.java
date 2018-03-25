/*This time the objective is to check whether the word is a palindrome or not. */
import java.util.*;

public class Stacks_Palindrome  
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter word to reverse:");
		String word = scan.nextLine();
		word = word.toLowerCase();
		Stack<Character> stack1 = new Stack<Character>();
		
		for(int i = 0;i<word.length();i++)
		{
			stack1.push(word.charAt(i));
		}
		String backwards = "";
		for(int i = 0;i<word.length();i++)
		{
			backwards += stack1.pop();
		}
		System.out.println("Reversed: " + backwards);
		
		if(word.equals(backwards)) 
			System.out.println(word + " is a palindrome.");
		else 
			System.out.println(word + " is not a palindrome.");
			scan.close();
	}
}

/*class Stack
{
    private int maxsize;
    private int[] stackArray;
    private int top;

    public Stack(int size){
        maxsize = size;
        stackArray = new int[maxsize];
        top = -1;
    }
    public void push(int x){
        top++;
        stackArray[top] = x;
    }
    public int pop(){
        return stackArray[top--];
    }
    public int peek(){
        return stackArray[top];
    }
    public boolean isEmpty(){
        return(top == -1);
    }
    public boolean isFull(){
        return(top == maxsize -1);
    }
    public void makeEmpty(){
        top = -1;
    }
}*/