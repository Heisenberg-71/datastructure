package sort;
import java.util.*;
public class Quick_sort {
    static void quick_sort(int[] arr,int l,int r){
		if(l>=r){
			return;
		}
		int i=l;
		int j=r;
		int mid=i+(j-i)/2;
		int p=arr[mid];
		while(i<=j){
			while(arr[i]<p){
				i++;
			}
			while(arr[j]>p){
				j--;
			}
			if(i<=j){
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i++;
				j--;
			}
		}
		quick_sort(arr,l,j);
		quick_sort(arr,i,r);
	}
	public static void main(String args[]){
		int[] arr={9,7,5,14,2,3,6,10};
		quick_sort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
