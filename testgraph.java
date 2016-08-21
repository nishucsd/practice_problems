package ucsd;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.StringTokenizer;

public class testgraph {

	public static void main(String[] args) throws FileNotFoundException {
		File f1 = new File("D:/tokens.txt");
		File f2 = new File("D:/unigram.txt");
		File f3 = new File("D:/bigram.txt");
		Scanner sc = new Scanner(f1);
		Scanner sc2 = new Scanner(f2);
		Scanner sc3= new Scanner(f3);
		int count1=0, count2=0;
		String tokens[] = new String[500];
		String Dummytokens[] = new String[500];
		String[] sentence1 = {"<s>", "The", "stock", "market", "fell", "by", "one", "hundred", "points", "last", "week"};
		String[] sentence2 = {"<s>", "The", "sixteen", "officials", "sold", "fire", "insurance"};
		int freqUni[] = new int[500];
		int freqThe[] = new int[500];
		int freqBi[][] = new int[500][500];
		int i=0;
		
		
		while(sc.hasNext() && sc2.hasNext()) {
			String ab = sc.nextLine();
			String uc = sc2.nextLine();
			
			tokens[i]=ab;
			freqUni[i]=Integer.parseInt(uc.trim());
			count2+=freqUni[i];
			i++;
			
		}
		
		
		for(i=0;i<500;i++) {
			Dummytokens[i] = tokens[i];
		}
		
		// For printing the probabilits of tokens that start with an M
		for(i=0;i<500;i++) {
			if(tokens[i].startsWith("M")) {
				System.out.println(tokens[i] + "   " + (double)freqUni[i]/count2);
			}
		}
		
		// creating the bigram matrix. Saving frequesncies of the word pairs.
		while(sc3.hasNext()) {
			String ab = sc3.nextLine();
			
			StringTokenizer st = new StringTokenizer(ab);
			int row = Integer.parseInt(st.nextToken());
			int column = Integer.parseInt(st.nextToken());
			freqBi[row-1][column-1] = Integer.parseInt(st.nextToken());
			
			
			
		}
		
		i= index("the", tokens, freqUni);
		for(int j=0;j<500;j++) {
			freqThe[j] = freqBi[i][j];
		}
		
		
		
		
		
		int theFreq = index("the", tokens, freqUni);
		findMostFreq(Dummytokens, freqThe, 500);
		
		//Printing the words that follow the most and their probabilities.
		for(int x=0; x<10; x++){
			System.out.println(Dummytokens[x] + "    " + (double)freqThe[x]/(double)freqUni[theFreq]);
		}
		
		// Varying lambda and calculating the corresponding mixed probabilities
		double lambda =0.0;
		for(int x=1;x<=1000;x++){
			double y =logMix( lambda,sentence2,tokens,freqUni,freqBi, count2);
			lambda= lambda + 0.001;
			System.out.println(lambda + "  " + y);
		}
		
		
		double y =logUni(sentence1,tokens,freqUni, count2);
		System.out.println("Unigram probability of sentence 1 is "+y);
		
		double z =logBi(sentence1,tokens,freqUni, freqBi);
		System.out.println("bigram probability of sentence 1 is "+z);
		
		 y =logUni(sentence2,tokens,freqUni, count2);
		System.out.println("Unigram probability of sentence 2 is "+y);
		
		 z =logBi(sentence2,tokens,freqUni, freqBi);
		System.out.println("bigram probability of sentence 2 is "+z);
		
		
		sc.close();
		sc2.close();
		sc3.close();
		
	

	
	}
	
	//finds the index of the word in the array
	public static int index(String str, String[] tokens, int[] freqUni) {
		for(int i=0;i<500;i++) {
			if(tokens[i].trim().equalsIgnoreCase(str)) {
				return i;
			}
			
			
		}
		
		return -1;
	}
	
	public static double unigramProb(String str, String[] tokens, int[] freqUni, int count2) {
		int ind = index(str, tokens, freqUni);
		;
		
		return (double)freqUni[ind]/(double)count2;
	}
	
	public static double bigramProb(String str1, String str2, String[] tokens, int[] freqUni, int[][] freqBi) {
		int ind1 = index(str1, tokens, freqUni);
		int ind2 = index(str2, tokens, freqUni);
		int freq;
		
			freq = freqBi[ind1][ind2];
			System.out.println((double)freq/(double)freqUni[ind1]);
			return (double)freq/(double)freqUni[ind1];
			
			
		
		
	}
	
	
	public static double logUni(String[] sentence,String[] tokens, int[] freqUni, int count2 ) {
		
		double result=0;
		
		for(int i=1; i< sentence.length; i++){
			result+= Math.log(unigramProb(sentence[i], tokens, freqUni, count2));
		}
		return result;
		
	}
	
	public static double logBi(String[] sentence, String[] tokens, int[] freqUni, int[][] freqBi) {
		double result=0;
		
		for(int j=1; j< sentence.length; j++) {
			result+= Math.log(bigramProb(sentence[j-1], sentence[j], tokens, freqUni, freqBi));
		}
		
		return result;
		
	}
	
	public static double logMix(double lambda, String[] sentence, String[] tokens, int[] freqUni, int[][] freqBi, int count2) {
	
		double result =0;
		for(int j=1; j< sentence.length; j++) {
			result+= Math.log(lambda*unigramProb(sentence[j], tokens, freqUni, count2)+ (1-lambda)*bigramProb(sentence[j-1], sentence[j], tokens, freqUni, freqBi));
		}
		
		return result;
		
	}
	
	
public static void findMostFreq(String[] tokens, int[] freqThe,int l){
		
		for(int x=0; x<l;x++){
			int largest = 0;
			for(int y=0;y<l-x;y++){
				largest = freqThe[y] < freqThe[largest]? y : largest;
			}
			
			String temp1="";
			int t=0;
			temp1=tokens[largest];
			tokens[largest]=tokens[l-x-1];
			tokens[l-x-1]=temp1;
			
			t=freqThe[largest];
			freqThe[largest]=freqThe[l-x-1];
			freqThe[l-x-1]=t;
			
			
			
		}
}
	
	
}