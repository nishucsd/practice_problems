package ucsd;

public class nondups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4,1,2,3,4,5,6,6,8,8,9};
		int val1=0, val2=0, zora=0;
		for( int i : a){
			zora^=i;
		}
		for(int i:a){
			if((i & zora & ~(zora-1)) ==0){
				val1^=i;
			}
			else
				val2^=i;
		}
		System.out.println(val1+" "+val2);
	}

}
