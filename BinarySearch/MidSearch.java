package BinarySearch;

public class MidSearch {
	//http://blog.chinaunix.net/uid-1844931-id-3337784.html
	static int searchFirstEqual(int []arr, int n, int key)
	{
	    int left = 0, right = n-1;
	    while(left<=right) {
	        int mid = (left+right)/2;
	        if(arr[mid] >= key) right = mid - 1;
	        else if(arr[mid] < key) left = mid + 1;
	    }
	    if( left < n && arr[left] == key) return left;
	    return -1;
	}
	static int searchLastEqual(int []arr, int n, int key)
	{
	    int left = 0, right = n-1;
	    while(left<=right) {
	        int mid = (left+right)/2;
	        if(arr[mid] > key) right = mid - 1;
	        else if(arr[mid] <= key) left = mid + 1;
	    }
	    if( right >=0 && arr[right] == key) return right;
	    return -1;
	}
	
	static int searchFirstEqualOrLarger(int []arr, int n, int key)
	{
	    int left=0, right=n-1;
	    while(left<=right) {
	        int mid = (left+right)/2;
	        if(arr[mid] >= key) right = mid-1;
	        else if (arr[mid] < key) left = mid+1;
	    }
	    return left;
	}
	static int searchFirstLarger(int []arr, int n, int key)
	{
	    int left=0, right=n-1;
	    while(left<=right) {
	        int mid = (left+right)/2;
	        if(arr[mid] > key) right = mid-1;
	        else if (arr[mid] <= key) left = mid+1;
	    }
	    return left;
	}
	static int searchLastEqualOrSmaller(int []arr, int n, int key)
	{
	    int left=0, right=n-1;
	    while(left<=right) {
	        int mid = (left+right)/2;
	        if(arr[mid] > key) right = mid-1;
	        else if (arr[mid] <= key) left = mid+1;
	    }
	    return right;
	}
	static int searchLastSmaller(int []arr, int n, int key)
	{
	    int left=0, right=n-1;
	    while(left<=right) {
	        int mid = (left+right)/2;
	        if(arr[mid] >= key) right = mid-1;
	        else if (arr[mid] < key) left = mid+1;
	    }
	    return right;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {0,1,2,2,2,5,6};
		System.out.println(searchFirstEqual(a, 7, 2));
		System.out.println(searchLastEqual(a, 7, 6));
	}

}
