package Sort;

public class CountSort {

	public void Count_sort(int a[], int max){
		int b[] = new int[a.length];
		for(int i=0;i<a.length;i++){
			b[i] = a[i];
		}
		int c[] = new int[max+1];
		for(int i=0;i<b.length;i++){
			c[b[i]]++;
		}
		for(int i=1;i<=max;i++){
			c[i] = c[i] +c[i-1];
		}
		for(int i=b.length-1;i>=0;i--){
			a[c[b[i]]-1] = b[i];
			c[b[i]] --;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountSort cs = new CountSort();
		
		int arr[] = {5,3,1,2,0};
		cs.Count_sort(arr, 10);
		Display.print(arr);
	
		
		int arr3[] = {1,5,8,5,0,6,7,6,5,8,3};
		cs.Count_sort(arr3, 10);
		Display.print(arr3);
	}

}
