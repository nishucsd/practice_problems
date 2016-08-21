package ucsd;

public class revStr {

	public static void main(String[] args) {
		String s1 = "Hello this is my name";
		s1 = " "+s1+" ";
		String s2="";
		int l1= s1.length();
		for(char i: s1.toCharArray()){
			s2=""+i+s2;
		}
		String temp="";
		System.out.println(s2);
		String s3="";
		for(char i: s2.toCharArray()){
			
			temp=temp+i;
			if(i == ' '){
				s3=""+temp+s3;
				temp="";
			}
		}
		System.out.println(s3.trim());
	}

}
