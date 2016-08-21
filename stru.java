package ucsd;

import java.util.HashMap;

public class stru {

	public static void main(String[] args) {
		String s1 = "nishantismynameintheisnnnclassproblemfinding";
		String s2 = "yiss";
		int length=0, winLength=0;
		HashMap<Character, Integer> given = new HashMap<>();
		HashMap<Character, Integer> haveTo = new HashMap<>();
		
		
		
		for(char i : s1.toCharArray()){
			int value = given.get(i)==null? 0:given.get(i);
			given.put(i, value+1);
		}
		for(char i : s2.toCharArray()){
			int value = haveTo.get(i)==null? 0:haveTo.get(i);
			haveTo.put(i, value+1);
		}
		for(int i=0 , begin=0; i<s1.length();i++){
			
				if(haveTo.containsKey(s1.charAt(i))){
					int value =  given.get(s1.charAt(i))==null? 0:given.get(i);
					if(value < haveTo.get(s2.charAt(i))){
						length++;
						
					}
					given.put(s1.charAt(i),value+1);
						
				}
			
			if(length == s2.length()) {
				while(haveTo.get(s1.charAt(begin))==null || haveTo.get(s1.charAt(begin))<given.get(s1.charAt(begin))){
					if(haveTo.get(s1.charAt(begin))!=null && haveTo.get(s1.charAt(begin))<given.get(s1.charAt(begin))){
						given.put(s1.charAt(begin),given.get(s1.charAt(begin))-1);
					}
					begin++;
				}
				winLength = i-begin+1;
				//findmaxwin
			}
			
			
		}

}

}
