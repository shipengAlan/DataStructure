package Sort;

public class HeapSort {
	//time O(nlogn)
	//space O(1)
	//not stable, inner sorting
	public void Heap_sort(int a[]){
		buildMaxHeap(a, a.length);
		int i = a.length;
		while(i>0){
			int tmp = a[0];
			a[0] = a[i-1];
			a[i-1] = tmp;
			i--;
			heapify(a, 0, i);
		}
	}
	public void heapify(int a[], int k, int size){
		int l = (k+1)*2 - 1;
		int r = (k+1)*2;
		int large = k;
		if(l<size&&a[k]<a[l]){
			large = l;
		}
		if(r<size&&a[large]<a[r]){
			large = r;
		}
		if(large!=k){
			int tmp = a[large];
			a[large] = a[k];
			a[k] = tmp;
			heapify(a, large, size);
		}
	}
	public void buildMaxHeap(int a[], int size){
		for(int i=size/2;i>=0;i--){
			heapify(a, i, size);
		}
	}
	
	public static void main(String[] args) {
		HeapSort hs = new HeapSort();
		
		int arr[] = {5,3,1,2,0};
		hs.Heap_sort(arr);
		Display.print(arr);
	
		
		int arr3[] = {1,5,8,5,0,6,7,6,5,8,3};
		hs.Heap_sort(arr3);
		Display.print(arr3);
		

	}

}
