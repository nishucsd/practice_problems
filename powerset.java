package ucsd;

public class powerset {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		findPowerset(a,4);

	}

	public static void findPowerset(int[] a, int l){
		if(l<0) {
			printArray(a);
			return;
		}
		a[l]=0;
		findPowerset(a,l-1);
		a[l]=1;
		findPowerset(a,l-1);
		
	}
	
	
	public static void printArray(int[] a){
		for(int i=0; i< a.length; i++){
			System.out.print(a[i]);
		}
		System.out.println();
	}
	
}
