package ucsd;

import java.util.HashMap;

public class substring {

	public static void main(String[] args) {
		String srt = "abcdan";
		HashMap<Character,Integer> h2= new HashMap<>();
		
		int maxLen=1;
		int curLen=1;
		h2.put(srt.charAt(0), 0);
		
		for(int i=1;i<srt.length();i++){
			if(h2.get(srt.charAt(i)) == null || i-curLen  > h2.get(srt.charAt(i))){
				curLen++;
				
			}
			else{
				maxLen=maxLen<curLen ? curLen : maxLen;
				curLen= i-h2.get(srt.charAt(i));
			}
				
				h2.put(srt.charAt(i),i);
			
		}
		maxLen=maxLen<curLen ? curLen : maxLen;
		System.out.println(maxLen);
		
		

	}

}
