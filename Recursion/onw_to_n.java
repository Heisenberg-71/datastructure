public class onw_to_n{
	static void one_to_n(int n){
		if(n==0){
			return;
		}
		one_to_n(n-1);
		System.out.println(n);
	}
	public static void main(String args[]){
		one_to_n(5);
	}
}