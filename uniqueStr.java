package ucsd;

import java.util.HashMap;

public class uniqueStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "nininishant";
		int maxSum=0;
		int curSum=0,begin=0;
		HashMap<Character,Integer> h1 = new HashMap<Character,Integer>();
		for(int i=0;i<str.length();i++){
			int prev=0;
			prev = h1.get(str.charAt(i))==null ? -1 : h1.get(str.charAt(i));
			if(prev ==-1 || prev <= i-curSum){
				
				curSum++;
			}
			else {
				
			}
				
			
			
		}
		
	}

}
