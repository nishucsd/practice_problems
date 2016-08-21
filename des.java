package ucsd;

import java.util.LinkedList;

public class des {

	public static void main(String[] args) {
		String s1 = "aaaaab";
		char[] str = s1.toCharArray();
		LinkedList<Character> l1 = new LinkedList<>();
		LinkedList<Integer> l2 = new LinkedList<>();
		
		for(int i=0;i<s1.length()-1;i++){
			int count=1;
			while(i<s1.length()-1 && s1.charAt(i)==s1.charAt(i+1) ){
				count++;
				i++;
			}
			l1.add(s1.charAt(i));
			l2.add(count);
			
		}
		if(l1.peekLast()!=s1.charAt(s1.length()-1)){
			l1.add(s1.charAt(s1.length()-1));
			l2.add(1);
		}
		for(int i=0;i<l1.size();i++){
			System.out.println(l1.get(i)+"  "+l2.get(i));
		}
		
		
	}

}
