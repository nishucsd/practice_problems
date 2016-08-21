package ucsd;

import java.util.HashMap;

public class firstChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Nishansggbrhzgjwngisk";
		HashMap<Character,Integer> h1 = new HashMap<>();
		char[] s1 = str.toCharArray();
		for(char i:s1){
			int val = h1.get(i)==null? 0:h1.get(i);
			h1.put(i, val+1);
		}
		for(char i:h1.keySet()){
			if(h1.get(i)==1){
				System.out.println(i);break;
			}
		}
		

	}

}
