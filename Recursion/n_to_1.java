import java.util.*;
public class n_to_1{
	static void n_to_1(int n){
		if(n==0){
			return;
		}
		System.out.println(n);
		n_to_1(n-1);
	}
	public static void main(String args[]){
		n_to_1(5);
	}
}