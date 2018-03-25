/*Use a stack structure to reverse a word.*/
import java.util.*;

public class Stacks_ReverseWord 
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter word to reverse:");
		String word = scan.nextLine();
		Stack stack1 = new Stack(word.length());
		
		for(int i = 0;i<word.length();i++)
		{
			stack1.push(String.valueOf(word.charAt(i)));
		}
		String backwards = "";
		for(int i = 0;i<word.length();i++)
		{
			backwards += stack1.pop();
		}
		System.out.println("Reversed: " + backwards);	
		scan.close();
	}
}

class Stack
{
    private int maxsize;
    private int[] stackArray;
    private int top;

    public Stack(int size){
        maxsize = size;
        stackArray = new int[maxsize];
        top = -1;
    }
    public void push(String string){
        top++;
        stackArray[top] = string;
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
    public int getTop(){
        return top;
    }
}