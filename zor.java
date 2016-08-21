package ucsd;

public class zor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] str = "121212112313131231121212".toCharArray();
		char[] buffer = new char[str.length];
		climb(str,0,str.length-1,buffer,0);
	}
	
	public static void climb(char[] str, int l,int r, char[] buffer,int pointer){
	
		
		if(l>r){
			printB(buffer, pointer);
			return;
		}
		buffer[pointer]= (char)((int)str[l] - (int)'1' + (int)'A');
		climb(str, l+1, r, buffer, pointer+1);
		if(r-l >=1){
			String two = ""+str[l]+str[l+1];
			int temp = Integer.parseInt(two);
			if(temp<=26){
				buffer[pointer]= (char)(temp-1+'A');
				climb(str, l+2, r, buffer, pointer+1);
			}
		}
	}


	public static void printB(char[] buffer, int p){
		for(int i=0;i<p;i++)
			System.out.print(buffer[i]);
		System.out.println();
	}
}