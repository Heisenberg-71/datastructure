import java.util.*;
public class permutation_no{
	static List<List<Integer>> list=new ArrayList<>();
	static void check(int[] arr,int n,int index){
		if(index==n){
			list.add(ArrayToList(arr));
			return;
		}
		for(int i=index;i<n;i++){
			swap(arr,i,index);
			check(arr,n,index+1);
			swap(arr,i,index);
		}
	}
	static void swap(int[] arr,int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	static List<Integer> ArrayToList(int[] arr){
		List<Integer> test=new ArrayList<>();
		for(int num:arr){
			test.add(num);
		}
		return test;
	}
	public static void main(String args[]){
		int[] arr={1,2,3};
		int n=3;
		check(arr,n,0);
		System.out.println(list);
	}
}