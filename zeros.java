package ucsd;

public class zeros {

	public static void main(String[] args) {
		int[] a = {5,4,0,3,5,0,2,0,0,0,430,50,0};
		int acpos=0;
		int count=0;
		for(int i =0;i<a.length;i++) {
			if(a[i]==0){
				count++;
				continue;
			}
			a[acpos++]=a[i];
			
		}
		while(acpos<a.length)
			a[acpos++]=0;
		for(int i : a)
			System.out.println(i);

}
}