import java.util.*;
public class main{
	public static void skip(String p,String up){
		if(up.isEmpty()){
			System.out.println(p);
			return;
		}
		char ch=up.charAt(0);
		if(ch=='a'){
			skip(p,up.substring(1));
		}
		else{
			skip(p+ch,up.substring(1));
		}
	}
	public static String skip(String up){
		if(up.isEmpty()){
			return "";
		}
		char ch=up.charAt(0);
		if(ch=='a'){
			return skip(up.substring(1));
		}
		else{
			return ch+skip(up.substring(1));
		}
	}
	public static String skipWorld(String up){
		if(up.isEmpty()){
			return "";
		}
		if(up.startsWith("world")){
			return skipWorld(up.substring(5));
		}
		else{
			return up.charAt(0)+skipWorld(up.substring(1));
		}
	}
	public static void main(String args[]){
		System.out.println(skipWorld("bacworldcabwiorld"));
	}
}