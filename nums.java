package ucsd;

import java.util.Arrays;
import java.util.LinkedList;

public class nums {
static int count =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "111111";
		int a[]={5,6,7,8,4};
		Arrays.sort(a);
		LinkedList<Integer> l1 = new LinkedList<>();
		countWay(num,l1);
		

	}
	
	public static void countWay(String str, LinkedList<Integer> l1 ){
		if(str.length()==0){
			count++;
			for(int k : l1){
				System.out.print(k+" ");
			}
			System.out.println();
		}
		int num=0;
		for(int i=0; i<str.length();i++){
			num = num*10 + (str.charAt(i) -'0');
			
			if(num<1 || num>26)continue;
			else{
				l1.add(num);
				countWay(str.substring(i+1),l1);
				l1.pollLast();
			}
			
		}
		
	}
	
	

}
