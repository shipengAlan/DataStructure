package Heap;

public class MinHeap {

	public void HeapifyDown(int a[], int key, int size){
		int l = (key+1)*2 -1;
		int r = (key+1)*2;
		int small = key;
		if(l<size&&a[key]>a[l]){
			small = l;
		}
		if(r<size&&a[small]>a[r]){
			small = r;
		}
		if(small!=key){
			int tmp = a[key];
			a[key]  = a[small];
			a[small] = tmp;
			HeapifyDown(a, small, size);
		}
	}
	public void HeapifyUp(int a[], int key){
		int f = (key+1)/2-1;
		if(a[f]>a[key]){
			int tmp = a[f];
			a[f] = a[key];
			a[key] = tmp;
			HeapifyUp(a, f);
		}
	}
	public void buildMinHeap(int a[], int size){
		for(int i=a.length/2;i>=0;i--){
			HeapifyDown(a, i, size);
		}
	}
	public int insert(int a[], int size, int key){
		if(size+1<=a.length){
			a[size] = key;
			size++;
			HeapifyUp(a,size-1);
			return size;
		}
		else{
			System.out.println("Insert Fail");
			return size;
		}
	}
	public int remove(int a[], int size){
		int result = a[0];
		a[0] = a[size-1];
		size--;
		HeapifyDown(a, 0, size);
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinHeap minheap = new MinHeap();
		int [] a = {53,23,17,9,45,65,78,87, 0};
		int size = a.length - 1;
		minheap.buildMinHeap(a, size);
		for(int i=0;i<size;i++){
			System.out.print(a[i]+",");
		}
		//insert
		System.out.println("\nAfter Insert");
		size = minheap.insert(a, size, 11);
		for(int i=0;i<size;i++){
			System.out.print(a[i]+",");
		}
		//remove
		System.out.println("\nAfter Remove");
		int result = minheap.remove(a, size);
		System.out.println(result);
		size--;
		for(int i=0;i<size;i++){
			System.out.print(a[i]+",");
		}
	}

}
