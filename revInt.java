package ucsd;

public class revInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=1534236469;
		boolean neg = false;
        if(x<0){
            x*=-1;
            neg=true;
        }
        String s = Integer.toString(x);
        String s2="";
        for(int i =0;i<s.length();i++){
            s2=""+s.charAt(i)+s2;
        }
        s2= neg? "-"+s2:s2;
        int b2=Integer.parseInt(s2);
        System.out.println(b2);
        
	}

}
