import java.util.*;
public class main{
	
	public static void main(String args[]){
		int c=0;
		int n=13;
		c+=n/25;
		n=n%25;
		c+=n/10;
		n=n%10;
		c+=n/5;
		n=n%5;
		c+=n/1;
		n=n%1;
		System.out.println(c);
	}
}