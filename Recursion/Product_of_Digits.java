import java.util.*;
public class Product_of_Digits{
	static int product(int n){
		if(n%10==n){
			return n;
		}
		return n%10*product(n/10);
	}
	public static void main(String args[]){
		int n=1235;
		System.out.println(product(n));
		
	}
}