package Sort;
import java.util.Stack;


public class QuickSort {
	//avg time O(nlogn)
	//space O(logn)
	//not stable, inner sorting
	public void Quick_sort(int arr[], int l, int r){
		if(l<r){
			int p = partition1(arr, l, r);
			Quick_sort(arr, l, p-1);
			Quick_sort(arr, p+1, r);
		}
	}
	public int partition1(int arr[], int s, int e){
		int j = s-1;
		int p = arr[e];
		for(int i=s;i<e;i++){
			if(arr[i]<p){ // why is "small"
				j++;
				if(i!=j){
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		arr[e] = arr[j+1];
		arr[j+1] = p;
		return j+1;
	}
	public int partition2(int arr[], int s, int e){
		int x = arr[s];
		int l = s;
		int r = e;
		while(l<r){
			while(l<r&&arr[r]>=x)
				r--;
			while(l<r&&arr[l]<=x)
				l++;
			if(l<r){
				int tmp = arr[l];
				arr[l] = arr[r];
				arr[r] = tmp;
			}
		}
		arr[s] = arr[l];
		arr[l] = x; 
		return l;
	}
	// non recursion version of quick sort
	public void Quick_sort2(int arr[]){
		Stack<Integer> left_stack = new Stack<Integer>();
		Stack<Integer> right_stack = new Stack<Integer>();
		left_stack.push(0);
		right_stack.push(arr.length-1);
		while(!left_stack.isEmpty()&&!right_stack.isEmpty()){
			int l = left_stack.pop();
			int r = right_stack.pop();
			int p = partition2(arr, l, r);
			if(l<p-1){
				left_stack.push(l);
				right_stack.push(p-1);
			}
			if(p+1<r){
				left_stack.push(p+1);
				right_stack.push(r);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QuickSort qs = new QuickSort();
		
		int arr[] = {5,3,1,2,0};
		qs.Quick_sort(arr, 0, arr.length-1);
		Display.print(arr);
		
		int arr2[] = {5,3,1,2,0};
		qs.Quick_sort2(arr2);
		Display.print(arr2);
		
		int arr3[] = {1,5,8,5,0,6,7,6,5,8,3};
		qs.Quick_sort(arr3, 0, arr3.length-1);
		Display.print(arr3);
		
		int arr4[] = {1,5,8,5,0,6,7,6,5,8,3};
		qs.Quick_sort2(arr4);
		Display.print(arr4);
	}

}
