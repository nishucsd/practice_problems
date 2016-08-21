package ucsd;

import java.util.HashMap;
import java.util.LinkedList;

public class test23 {
	static int[] b;
	public static void main(String[] args) {
		String[] ar= {"abc","def","abc","abc","def","abc","abc","def","abc","nahm","bam","pram","abc","def","abc","abc","def","abc","abc","def","abc","nahm","abc","def","abc","abc","def","abc","abc","def","abc","nahm"};
		
		HashMap<String,Integer> h1 = new HashMap<>();
		HashMap<Integer,LinkedList<String>> h2 = new HashMap<>();
		LinkedList<String> l1;
		
		for(String i : ar){
			int val = h1.get(i)==null? 0:h1.get(i);
			h1.put(i, val+1);
			
		}
		for(String s : h1.keySet()){
			if(h2.get(h1.get(s))==null){
				l1 = new LinkedList<String>();
				
			}
			else{
				l1= h2.get(h1.get(s));
				
			}
			l1.add(s);
			h2.put(h1.get(s), l1);
			
		}
		
		
		
		System.out.println(h2.entrySet());
		
		
		

	}

}
