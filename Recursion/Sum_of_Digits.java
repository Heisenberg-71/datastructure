import java.util.*;
public class Sum_of_Digits{
	static int sum(int n){
		if(n==0){
			return 0;
		}
		return n%10+sum(n/10);
	}
	public static void main(String args[]){
		int n=12345;
		System.out.println(sum(n));
		
	}
}