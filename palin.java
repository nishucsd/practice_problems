package ucsd;

public class palin {
	static int d1=11;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 11;
		checkp(num);
			
	}
	public static void checkp(int num){
		if(num ==0)
			return;
		
		checkp(num/10);
		int a = num%10;
		int b = d1%10;
		d1/=10;
		System.out.print(a);
		System.out.print(b);
		if(a!=b)
			System.out.print("not!!");
			
	}
	

}
