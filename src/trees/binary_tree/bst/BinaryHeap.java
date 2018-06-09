package trees.binary_tree.bst;

public class BinaryHeap {
	
	private int[] arr;
	private int capacity;
	private int heapSize;
	
	public BinaryHeap(int capacity) {
		this.capacity = capacity;
		this.arr = new int[capacity];
		this.heapSize = 0;
	}
	
	// Return parent of the index i
	private int parent(int i) {
		return (i - 1) / 2;
	}
	
	
	private int left(int i) {
		return 2 * i + 1;
	}
	
	private int right(int i) {
		return 2 * i + 2;
	}
	
	
	int getMini() { return arr[0]; }
	
	// A recursive function to heapify subtree with root at given index
	// This method assumes that subtree is already heapify
	void minHeapify(int i) {
		
		int left = left(i);
		int right = right(i);
		int smallest = i;
		
		if (left < heapSize && arr[left] < arr[i]) {
			smallest = left;
		}
		if (right < heapSize && arr[right] < arr[smallest]) {
			smallest = i;
		}
		if (smallest != i) {
			swap(arr, i, smallest);
			minHeapify(smallest);
		}
	}

	
	void insertKey(int key) {
		if (heapSize == capacity) {
			System.out.println("Overflow: Could not insert a new key");
			return;
		}
		
		// Insert the key at the end
		int i = heapSize;
		heapSize++;
		arr[i] = key;
		
		// Fix the min heap property if its violated
		while (i != 0 && arr[ parent(i) ] > arr[i]) {
			swap(arr, i, parent(i));
			i = parent(i);
		}
	}
	
	
	void decreaseKey(int i, int newValue) {
		
		arr[i] = newValue;
		
		while (i != 0 && arr[ parent(i) ] > arr[i]) {
			swap(arr, i, parent(i));
			i = parent(i);
		}
	}
	
	
	int extractMin() {
		if (heapSize <= 0) {
			return Integer.MAX_VALUE;
		}
		
		if (heapSize == 1) {
			heapSize--;
			return arr[heapSize];
		}
		
		int root = arr[0];
		arr[0] = arr[ heapSize - 1 ];
		heapSize--;
		minHeapify(0);;
		return root;
	}
	
	void deleteKey(int i) {
		decreaseKey(i, Integer.MIN_VALUE);
		extractMin();
	}
	
	
	

	private void swap(int[] arr, int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
		
	public static void main(String[] args) {
		BinaryHeap h = new BinaryHeap(11);
		h.insertKey(3);
	    h.insertKey(2);
	    h.deleteKey(1);
	    h.insertKey(15);
	    h.insertKey(5);
	    h.insertKey(4);
	    h.insertKey(45);
	    
	    System.out.println(h.extractMin());
	    System.out.println(h.getMini());
	
	    h.decreaseKey(2, 1);
	    System.out.println(h.getMini());
	}

}
