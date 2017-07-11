package Sort;
import java.util.Arrays;


public class MergeSort {
	//time O(nlogn)
	//space O(n)
	//stable out sorting
	public void Merge_sort(int arr[], int l, int r){
		if(l<r){
			//System.out.println(l+","+r);
			int p = (r+l)/2+1;
			Merge_sort(arr, l, p-1);
			Merge_sort(arr, p, r);
			Merge(arr, l, p, r);
		}
	}
	public void Merge(int arr[], int l, int p, int r){
		int MAX = Integer.MAX_VALUE;
		int tmp1[] = new int[p-l+1];
		int tmp2[] = new int[r-p+2];
		int i = 0; 
		for(i=l;i<p;i++){
			tmp1[i-l] = arr[i];
		}
		tmp1[i-l] = MAX;
		for(i=p;i<=r;i++){
			tmp2[i-p] = arr[i];
		}
		tmp2[i-p] = MAX;
		int p1 = 0;
		int p2 = 0;
		for(i=l;i<=r;i++){
			if(tmp1[p1] <= tmp2[p2]){ // stable
				arr[i] = tmp1[p1];
				p1++;
			}
			else{
				arr[i] = tmp2[p2];
				p2++;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MergeSort ms = new MergeSort();
		
		int arr[] = {5,3,1,2,0};
		ms.Merge_sort(arr, 0, arr.length-1);
		Display.print(arr);
		/*
		int arr2[] = {5,3,1,2,0};
		qs.Quick_sort2(arr2);
		Display.print(arr2);
		*/
		int arr3[] = {1,5,8,5,0,6,7,6,5,8,3};
		ms.Merge_sort(arr3, 0, arr3.length-1);
		Display.print(arr3);
		/*
		int arr4[] = {1,5,8,5,0,6,7,6,5,8,3};
		qs.Quick_sort2(arr4);
		Display.print(arr4);
		*/
	}

}
