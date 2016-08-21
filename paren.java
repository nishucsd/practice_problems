package ucsd;

public class paren {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=3;
		char[] str = new char[count*2];
		//paren(3,3,str,0);
			parent(3,3,"");
	}
	
	
	public static void paren(int l,int r, char[] s, int count){
		if(l<0 ) return;
		if(l== 0 && r==0){
			System.out.println(s);
		}
		
		else {
			
			if(l>0){
				s[count]='(';
				paren(l-1, r, s, count+1);
			}
			if(r>l ) {
				s[count]= ')';
				paren(l,r-1,s,count+1);
			}
			
			
			
		}
	}
	
	public static void parent(int l,int r, String s){
		if(l<0 ) return;
		if(l== 0 && r==0){
			//System.out.println(s);
		}
		
		else {
			
			if(l>0){
				s+='(';
				System.out.println(s+l+r);
				parent(l-1, r, s);
			}
			if(r>l ) {
				s+= ')';
				System.out.println(s+l+r);
				parent(l,r-1,s);
			}
			
			
			
		}
	}

}
