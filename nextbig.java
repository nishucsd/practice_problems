package ucsd;

public class nextbig {

	public static void main(String[] args) {
			int[] a={9,4,0,1,2,4,6,7,200,510};
			int[] b={0,0,0,0,0,0,0,0,0,0};
			int l = a.length;
			b[l-1]=-1;
			int inext=0,temp=0;
			
			
			for(int i=l-2; i>=0;i--){
				if(a[i]<a[i+1]){
					b[i]=i+1;
					continue;
					}
				else {
					temp = a[i];
					inext = b[i+1];
					while(temp> a[inext]){
						inext = b[inext];
						}
					b[i]=inext;
					}
			}
				for(int j : b){
					System.out.println(a[j]);
				}



	}

}
