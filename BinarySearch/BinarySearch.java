package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
	public int arr[];
	public BinarySearch(int a[]){
		arr = Arrays.copyOf(a, a.length);
		Arrays.sort(arr);
	}
	public int find(int key){
		int left = 0, right = arr.length-1, mid;
		while(left<=right){
			mid = (left+right)/2;
			if(arr[mid]==key)
				return mid;
			else if(arr[mid]>key)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	}
	// repeated and find the left bound
	public int findLeft(int key){
		int left = 0, right = arr.length-1, mid;
		while(left<=right){
			mid = (left+right)/2;
			if(arr[mid]>key)
				right = mid - 1;
			else if(arr[mid]<key)
				left = mid + 1;
			else if(arr[mid]==key&&(mid-1<0||arr[mid-1]!=key))
				return mid;
			else
				right = mid - 1;
		}
		return -1;

	}
	// find the first large or equal one (from left)
	public int findFirstLE(int key){
		int left = 0, right = arr.length-1, mid=0;
		if(left>right)
			return -1;
		if(left==right)
			return arr[left]>=key?left:-1;
		if(key>arr[right])
			return -1;
		while(left<right){
			if(right-left==1)
				break;
			mid = (left+right)/2;
			if(arr[mid]>=key)
				right = mid;
			else if(arr[mid]<key)
				left = mid;
		}
		if(arr[left]>=key)
			return left;
		else
			return right;
	}
	public static void main(String[] args) {
		int a[] = {1,5,8,5,0,6,7,6,5,8,3};
		BinarySearch bs = new BinarySearch(a);
		System.out.println(Arrays.toString(bs.arr));
		System.out.println(bs.find(5));
		System.out.println(bs.findLeft(5));
		System.out.println(bs.find(3));
		System.out.println(bs.findLeft(3));
		System.out.println(bs.findFirstLE(5));
		System.out.println(bs.findFirstLE(9));
		System.out.println(bs.findFirstLE(5));
		System.out.println(bs.findFirstLE(3));
		System.out.println(bs.findFirstLE(6));
		System.out.println(bs.findFirstLE(8));
		System.out.println(bs.findFirstLE(-1));
	}

}
