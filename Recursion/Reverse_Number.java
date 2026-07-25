import java.util.*;
public class Reverse_Number{
	static int reverse_number1(int n,int sum){
        if(n%10==n){
            return (sum*10)+n;
        }
        return reverse_number1(n/10,(sum*10)+n%10);
    }
	static int reverse_number2(int n){
		int digits=(int)Math.log10(n)+1;
		return helper(n,digits);		
	}
	static int helper(int n,int digits){
		if(n%10==n){
			return n;
		}
		return ((n%10)*((int)Math.pow(10,digits-1)))+helper(n/10,digits-1);
	}
	public static void main(String args[]){
		System.out.println(reverse_number2(94747373));
		System.out.println();
	}
}