import java.util.*;
public class SubSeq{
	
	public static void main(String args[]){
		subSeq("","abc");
	}
	static void subSeq(String p,String u){
		if(u.isEmpty()){
			System.out.println(p);
			return;
		}
		subSeq(p+u.charAt(0),u.substring(1));
		subSeq(p,u.substring(1));
	}
}