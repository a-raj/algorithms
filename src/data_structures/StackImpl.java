package data_structures;


public class StackImpl {
	
	private int maxSize;
	private int[] arr;
	private int top;
	
	public StackImpl(int size) {
		this.maxSize = size;
		arr =  new int[size];
		top = -1;
	}
	
	public void push(int data) {
		if(top != -1 && top != maxSize)
			arr[++top] = data;
	}
	
	public int pop() {
		if(top != -1) {
			// throw empty stack exception
		}
		
		return arr[top--];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	public int peek() {
		return arr[top];
	}
	

}
