package ucsd;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class keysets {

	public static void main(String[] args) {
		HashMap<String, String> h = new HashMap<>();
		h.put("a@b.com", "nishant");
		h.put("abc@b.com", "nishant");
		h.put("aff@b.com", "nishant");
		h.put("aklmn@b.com", "niki");
		h.put("garry@b.com", "garry");
		h.put("aijijn@b.com", "niki");

		HashMap<String,List<String>> h2 = new HashMap<>();
		 
		LinkedList<String> k9 = new LinkedList<>();
		
		
	for(String v : h.values())	{
		LinkedList<String> k1 = new LinkedList<>();
		
		//k1.poll
		for(String k : h.keySet()){
			if(v.equals(h.get(k)))
				k1.add(k);
				
				
		}
		h2.put(v, k1);
		
		
		
		
	}
	
	for(String k : h2.keySet())	{
		System.out.print(k+" ");
		for(String v : h2.get(k)){
			System.out.print(v+" ");
			
		}
		System.out.println();
	

	}

}
}
