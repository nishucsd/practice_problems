package ucsd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class bitsInt {
	public static int b7=0;

	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		for(int i =1; i<800000; i=i+100)
		System.out.println(i +"    " + getY(i));

	}
	
	public static int getBValue() {
		Double rd = Math.random();
		int b = rd >0.5? 1 :0;
		return b;
		
	}
	
	//Computes the maximum likelihood
	public static double getY(int sample) {
		double num=0,den=0,z=0,y=0;
		
		for(int i =1; i<=sample; i++) {
			z=getZValue();
			if(b7 == 1)
				num+=z;
			
			den+=z;
			
		}
		
		y=num/den;
		return y;
		
	}
	//returns the probability value of P(Z=64 | B1,B2...B10)
	public static double getZValue() {
		double alpha = 0.35;
		b7=0;
		int fn=0,  bVal;
		for(int i=1;i<=10;i++){
			bVal = getBValue();
			if(i==7 && bVal==1) 
				b7= 1;
			
					
			
			
			fn+=(int)Math.pow((double)2,(double) (i-1))*bVal;
		}
		
		double beta = (1-alpha)/(1+alpha);
		double prob = beta*Math.pow(alpha, Math.abs(64.0 - fn));
		
		
				
		
		return prob;
	}

}
