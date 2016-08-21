package ucsd;

public class cipher {

	public static void main(String[] args) {
		String s1 = "abc abc abd ";
		String s2 = "yza yza yzb ";
		int diff=0,prev=0;
		
		for(int i=0;i<s1.length(); i++){
			if(s1.charAt(i)== ' ')
				continue;
			
			diff = s1.charAt(i)-s2.charAt(i);
			if(Math.abs(diff)>13)
				diff = diff<0 ? (26-Math.abs(diff)):-1*(26-Math.abs(diff));
			
				System.out.println(diff);
				
		}

	}

}
