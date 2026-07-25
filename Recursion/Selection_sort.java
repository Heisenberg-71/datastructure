import java.util.*;
public class Selection_sort{
	static void SelectionSort(int[] arr,int r,int c,int max){
		if(r==0){
			return;
		}
		if(c<r){
			if(arr[c]>arr[max]){
				SelectionSort(arr,r,c+1,c);
			}
			else{
				SelectionSort(arr,r,c+1,max);
			}
		}
		else{
		int temp=arr[r-1];
		arr[r-1]=arr[max];
		arr[max]=temp;
		SelectionSort(arr,r-1,0,0);
		}
	}
	public static void main(String args[]){
		int[] arr={1,4,2,3,6};
		SelectionSort(arr,arr.length,0,0);
		System.out.println(Arrays.toString(arr));
	}
}