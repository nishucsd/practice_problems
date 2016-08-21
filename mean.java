package ucsd;

public class mean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a=0.0509  ;
		double b=  0.0521;
		double c=0.0501;
		double mean = (a+b+c)/3;
		double variance = ((a-mean)*(a-mean) + (a-mean)*(a-mean) + (a-mean)*(a-mean) )/3;
		double sd = Math.sqrt(variance);
		System.out.println(mean + "   " + sd);
	}

}
