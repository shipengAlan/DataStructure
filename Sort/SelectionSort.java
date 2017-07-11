package Sort;

public class SelectionSort {

	public void Selection_sort(int a[]){
		for(int i=0;i<a.length-1;i++){
			int min = i;
			for(int j=i+1;j<a.length;j++){
				if(a[j]<a[min]){
					min = j;
				}
			}
			if(min!=i){
				int tmp = a[min];
				a[min] = a[i];
				a[i] = tmp;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectionSort ss = new SelectionSort();
		
		int arr[] = {5,3,1,2,0};
		ss.Selection_sort(arr);
		Display.print(arr);
	
		
		int arr3[] = {1,5,8,5,0,6,7,6,5,8,3};
		ss.Selection_sort(arr3);
		Display.print(arr3);
	}

}
