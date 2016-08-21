package ucsd;

public class araymid {
	public static void main(String laa[]) {
		
		int a[]= {5,4,9,8,11,15,14,13};
		
		int small[] =new int[a.length];
		int least=9999;
		for(int i=a.length-1;i>=0;i--) {
			if(a[i]<least){
				least = a[i];
				small[i]=1;
			}
			
		}
		int max=0;
		for(int i=0; i<a.length;i++){
			if(a[i]>max){
				max=a[i];
				if(small[i]==1)
					System.out.println(a[i]);
			}
			
		}
		
		
	}

}
