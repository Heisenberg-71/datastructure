package sort;
import java.util.*;
public class Merge_sort {
    static void merge_sort(int[] arr,int s,int e){
		if(e-s==1){
			return;
		}
		int mid=(s+e)/2;
		merge_sort(arr,s,mid);
		merge_sort(arr,mid,e);
		
		merge(arr,s,mid,e);
	}
	static void merge(int[] arr,int s,int m,int e){
		int[] mix=new int[e-s];
		int i=s;
		int j=m;
		int k=0;
		while(i<m && j<e){
			if(arr[i]<arr[j]){
				mix[k++]=arr[i++];
			}
			else{
				mix[k++]=arr[j++];
			}
		}
		while(i<m){
			mix[k++]=arr[i++];
		}
		while(j<e){
			mix[k++]=arr[j++];
		}
		for(int l=0;l<e-s;l++){
			arr[l+s]=mix[l];
		}
	}
	public static void main(String args[]){
		int[] arr={9,7,5,14,2,3,6,10};
		merge_sort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
