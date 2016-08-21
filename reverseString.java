package ucsd;
import java.io.*;
public class reverseString {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		DataInputStream al = new DataInputStream(System.in);
		String test = "nishant is";
		
		test = " "+test;
		String out="";
		for(int i=test.length()-1; i>=0;i--){
			String temp="";
			while(test.charAt(i)!=' '){
				temp=""+test.charAt(i)+temp;
				i--;
			}
			out = out +temp;
			out=i==0?out:out+" ";
		}
		System.out.println(out);

	}

}
