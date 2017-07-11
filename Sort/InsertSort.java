package Sort;

public class InsertSort {
	//time  O(n2)
	//space O(1)
	//stable inner sorting
	public void Insertion_sort(int []arr){
		if(arr.length==0)
			return;
		for(int i=1;i<arr.length;i++){
			int j = i-1;//++
			int m = arr[i];
			while(j>=0&&arr[j]>m){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = m;
		}
		return;
	}
	// from large to small
	public void Insertion_sort_reverse(int arr[]){
		if(arr.length==0)
			return;
		for(int i=1;i<arr.length;i++){
			int j = i-1;
			int m = arr[i];
			while(j>=0&&arr[j]<m){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = m;
		}
	}
	// recursion version of Insertion sort
	public void Insertion_sort(int arr[], int n){
		if(n>0){
			Insertion_sort(arr, n-1);
			int m = arr[n];
			int j = n-1;
			while(j>=0&&arr[j]>m){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = m;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5,3,1,2,0};
		InsertSort is = new InsertSort();
		is.Insertion_sort(arr);
		Display.print(arr);
		is.Insertion_sort_reverse(arr);
		Display.print(arr);
		is.Insertion_sort(arr, arr.length-1);
		Display.print(arr);
	}

}
