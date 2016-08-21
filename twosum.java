package ucsd;

import java.util.HashMap;

public class twosum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> h1 = new HashMap<>();
		int[] nums={3,3,3,3,3,33,3};
		int t =6;
		for(int i=0;i<nums.length;i++){
			if(h1.containsKey(t-nums[i])){
				System.out.println(i+" "+h1.get(t-nums[i]));
				h1.remove(t-nums[i]);
			}
			else{
				h1.put(nums[i], i);
			}
		}
	}

}
