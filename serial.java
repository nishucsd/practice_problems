package ucsd;

import java.util.HashMap;
import java.util.LinkedList;

public class serial {

	public static void main(String[] args) {
		
		String test = "aaaaaaabc";
		
		LinkedList<Character> charList = new LinkedList<>();
		LinkedList<Integer> countList = new LinkedList<>();
		
		for(int i=0;i<test.length()-1;i++) {
			int count =1;
			while(test.charAt(i)==test.charAt(i+1)){
				count++;
				i++;
			}
			charList.add(test.charAt(i));
			countList.add(count);
			
			
		}
		if(charList.peekLast()!=test.charAt(test.length()-1)){
			charList.add(test.charAt(test.length()-1));
			countList.add(1);
		}
		
		for( int i : countList)
			System.out.println(i);
		
		
		
		
	}

}