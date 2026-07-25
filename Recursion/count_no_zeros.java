import java.util.*;

public class count_no_zeros{
	static int count_no_zeros(int n,int c){
		if(n==0){
			return c;
		}
		if(n%10==0){
			return count_no_zeros(n/10,c+1); 
		}
		return count_no_zeros(n/10,c); 
	}
	public static void main(String args[]){
		System.out.print(count_no_zeros(3000,0));
	}
}