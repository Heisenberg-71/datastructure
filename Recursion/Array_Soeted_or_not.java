
public class Array_Soeted_or_not{
	static boolean soted_or_not(int[] arr,int i){
		if(i==arr.length-1){
			return true;
		}
		return (arr[i]<arr[i+1]) && soted_or_not(arr,i+1);
	}
	public static void main(String args[]){
		int[] arr={1,2,3,10,5,7};
		System.out.println(soted_or_not(arr,0));
	}
}