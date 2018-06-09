package data_structures;

public class QueueImpl {
	
	private int front;
	private int rear;
	private int size;
	private int capaicity;
	private int[] arr;
	
	public QueueImpl(int capaicity) {
		
		this.capaicity = capaicity;
		this.size = 0;
		this.front = this.size;
		this.rear = capaicity - 1;
		this.arr = new int[capaicity];
	}
	
	boolean isFull() {
		return this.size == this.capaicity;
	}
	
	boolean isEmpty() {
		return this.size == 0;
	}
	
	void enque(int item) {
		
		if (this.isFull()) 
			return;
		
		this.rear = (this.rear + 1) % this.capaicity;
		this.arr[rear] = item;
		this.size++;
			
	}
	
	int deque() {
		
		if (this.isEmpty())
			return Integer.MAX_VALUE;
		
		int item = this.arr[this.front];
		this.front = (this.front + 1) % this.capaicity;
		this.size--;
		return item;
		
	}
	
	int front() {
        if (this.isEmpty())
            return Integer.MIN_VALUE;
          
        return this.arr[this.front];
    }
    
    int rear() {
        if (this.isEmpty())
            return Integer.MIN_VALUE;
          
        return this.arr[this.rear];
    }

}
