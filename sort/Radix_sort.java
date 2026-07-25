package sort;
import java.util.*;
public class Radix_sort {
    static int[] radix_sort(int[] arr,int n){
		if(arr.length==0){
			return arr;
		}
		int div=1;
		int max=arr[0];
		for(int i=1;i<n;i++){
			if(max<arr[i]){
				max=arr[i];
			}
		}
		int digitLen=String.valueOf(max).length();
		for(int i=0;i<digitLen;i++){
			int[] count=new int[10];
			for(int j=0;j<n;j++){
				count[(arr[j]/div)%10]++;
			}
			for(int j=1;j<10;j++){
				count[j]=count[j-1]+count[j];
			}
			int[] temp=new int[n];
			for(int j=n-1;j>=0;j--){
				temp[--count[(arr[j]/div)%10]]=arr[j];
			}
			arr=temp;
			div*=10;
		}
		return arr;
	}
	public static void main(String args[]){
		int[] arr={ 170, 45, 75, 90, 802, 24, 2, 66 };
		arr=radix_sort(arr,arr.length);
		System.out.println(Arrays.toString(arr));
	}
}
