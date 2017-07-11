package Sort;

public class BubbleSort {
	//time O(n2)
	//space O(1)
	//stable inner sorting
	//why bubblesort is slower than insertsort
	//插入排序的速度直接是逆序对的个数，而冒泡排序中执行“交换“的次数是逆序对的个数，因此冒泡排序执行的时间至少是逆序对的个数，因此插入排序的执行时间至少比冒泡排序快。
	public void Bubble_sort(int arr[]){
		for(int i=0;i<arr.length;i++){
			for(int j=arr.length-1;j>i;j--){
				if(arr[j]<arr[j-1]){
					int tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}
			}
		}
	}
	public void Bubble_sort(int arr[], int l){
		if(l<arr.length){
			for(int j=arr.length-1;j>l;j--){
				if(arr[j]>arr[j-1]){
					int tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}
				
			}
			Bubble_sort(arr, l+1);
		}
	}
	public void improved_Bubble_sort_reverse(int arr[]){
		for(int i=0;i<arr.length;i++){
			int tag = 0;
			for(int j=arr.length-1;j>i;j--){
				if(arr[j]<arr[j-1]){
					tag = 1;
					int tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}
			}
			if(tag==0)
				return;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5,3,1,2,0};
		BubbleSort bs = new BubbleSort();
		bs.Bubble_sort(arr);
		Display.print(arr);
		bs.improved_Bubble_sort_reverse(arr);
		Display.print(arr);
		bs.Bubble_sort(arr,0);
		Display.print(arr);
	}

}
