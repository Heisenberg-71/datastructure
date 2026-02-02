import java.util.*;
public class main{
	static int[] mergesort1(int[] arr){
		if(arr.length==1){
			return arr;
		}
		int mid=arr.length/2;
		int[] left=mergesort1(Arrays.copyOfRange(arr,0,mid));
		int[] right=mergesort1(Arrays.copyOfRange(arr,mid,arr.length));
		
		return merge(left,right);
	}
	private static int[] merge(int[] first,int[] second){
		int[] mix=new int[first.length+second.length];
		
		int i=0;
		int j=0;
		int k=0;
		while(i<first.length && j<second.length){
			if(first[i]<second[j]){
				mix[k++]=first[i++];
			}
			else{
				mix[k++]=second[j++];
			}
		}
		
		while(i<first.length){
			mix[k++]=first[i++];
		}
		while(j<second.length){
			mix[k++]=second[j++];
		}
		return mix;
	}
	static void mergesortInPace(int[] arr,int s,int e){
		if(e-s==1){
			return;
		}
		int mid=(s+e)/2;
		mergesortInPace(arr,s,mid);
		mergesortInPace(arr,mid,e);
		
		mergeInPlace(arr,s,mid,e);
	}
	
	private static void mergeInPlace(int[] arr,int s,int m,int e){
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
		for(int l=0;l<mix.length;l++){
			arr[l+s]=mix[l];
		}
	}
	
	
	public static void main(String args[]){
		int[] arr={3,2,-1,-4,-100,1,4,7,5};
		mergesortInPace(arr,0,arr.length);
		System.out.println(Arrays.toString(arr));
	}
}