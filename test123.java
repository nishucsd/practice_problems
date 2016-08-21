package ucsd;

public class test123 {

	public static void main(String[] args) {
			int[] nums = {1,1,2,2,3,3,4,4,5,6};
		   int zor =0;
	        int[] a = {0,0};
	        for(int i : nums)
	            zor^=i;
	        zor--;
	        for(int i : nums){
	            if((i & (zor+1) & ~zor) == 0) 
	                a[0]^=i;
	            else
	                a[1]^=i;
	        }
	        
			
	}

}


