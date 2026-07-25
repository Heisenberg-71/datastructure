import java.util.*;
public class Linear_Search{
	static boolean find(int[] arr,int target,int i){
		if(i==arr.length){
			return false;
		}
		return arr[i]==target || find(arr,target,i+1);
	}
		static int findIndex(int[] arr,int target,int i){
		if(i==arr.length){
			return -1;
		}
		if(arr[i]==target){
			return i;
		}
		else{
			return findIndex(arr,target,i+1);
		}
	}
	
	static List<Integer> findAllIndex(int[] arr,int target,int i,List<Integer> list){
		if(i==arr.length){
			return list;
		}
		if(arr[i]==target){
			list.add(i);
		}
		return findAllIndex(arr,target,i+1,list);
	}
	static List<Integer> findAllIndex2(int[] arr,int target,int i){
		ArrayList<Integer> list=new ArrayList<>();
		if(i==arr.length){
			return list;
		}
		if(arr[i]==target){
			list.add(i);
		}
		List<Integer> ansFromBelowCalls= findAllIndex(arr,target,i+1,list);
		
		 list.addAll(ansFromBelowCalls);
		 
		 return list;
		 
	}
	public static void main(String args[]){
		int[] arr={1,2,3,10,5,3,4,7,3};
		System.out.println(findAllIndex(arr,3,0,new ArrayList<>()));
	}
}