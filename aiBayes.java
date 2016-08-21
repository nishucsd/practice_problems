package ucsd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class aiBayes {

	public static void main(String[] args) throws FileNotFoundException {
		File f1 = new File("D:/words.txt");
		Scanner sc = new Scanner(f1);
		int i=0, totalWords=0, counter=0, length;
		String words[] = new String[6600];
		double finalArr[] = new double[26];
		int freq[] = new int[6600];
		double prob[] = new double[6600];
		Scanner sc2= new Scanner(System.in);
		
		
		
		//parsing the input file to create two arrays- words, and freq
		while(sc.hasNext()) {
			String ab = sc.nextLine();
			StringTokenizer st = new StringTokenizer(ab);
			words[i] = st.nextToken();
			freq[i] = Integer.parseInt(st.nextToken());
			counter+= freq[i];
			
			i++;
			
		}
		length=i;
		//sorting the file to get most and least frequent words
		findMostFreq(words, freq, length);
		
		/*for(int g=0;g<length;g++){
			System.out.println(words[g]+ "   " + freq[g]);
		}*/
	
		// taking the alreay entered character sequence one by one and storing the indices and letters in a hashmap.
		System.out.println("Do you wish to enter correct guesses?(y/n)");	
		Scanner s1= new Scanner(System.in);
		String response= s1.nextLine();
		HashMap<Integer, String> myMap = new HashMap<Integer, String>();
	
	
		while(response.equalsIgnoreCase("y")) {
			System.out.println("Enter the index and the letter in separate by a space:");
			myMap.put(s1.nextInt(), s1.nextLine().toUpperCase().trim())	;
			
			System.out.println("Do you wish to enter correct guesses?(y/n)");	
			response= s1.nextLine();
			
		}
	
		
		System.out.println("Enter the incorrect character sequence:");
		String incorrect = s1.nextLine().toUpperCase();
		int count=0, flag;
		for(int x=0;x<length; x++){
			flag=0;
			// computing the words which match the already entered character sequence
			if(myMap !=null) {
				for(int y : myMap.keySet()){
					if(words[x].charAt(y)!= myMap.get(y).charAt(0)) {
						flag=1;
						
					}
					//also excluding words that already present
					incorrect=incorrect + myMap.get(y).charAt(0);
				}
			}
			// eliminating the words that have the incorrect characters as a part the unfilled word
		
			if(flag==0 && incorrect!=null){
				for(int j=0;j<5;j++){
					if(myMap.containsKey(j)== false){
						if(incorrect.contains(""+words[x].charAt(j))){
							flag=1;
						}
					}
				}
			}
		
			if(flag == 0){
				count+=freq[x];
				prob[x]= freq[x];
			}
			else 
				prob[x]= 0;
		
		}//prob[x]/count gives the bayes term of P(W=w | E)
		
		for(int x=0; x<finalArr.length; x++){
			finalArr[x]=0.0;
		}
	
	//calculating the final probability of each letter as the next best guess using the bayes result.
		for(int a=0;a<26;a++){
		for(int x=0;x<length; x++){
			flag=0;
			for(int j=0;j<5;j++){
				if(myMap.containsKey(j)== false){
					if(words[x].charAt(j) == (char)('A'+a)){
						flag=1;break;
					}
				}
			}
			
			if(flag ==1 && count!=0){
				finalArr[a]=finalArr[a]+(prob[x]/count);
			}
		}
		
	}
	
	
	int largest = 0;
	
	//finding the letter with largest probability of occuring next.
	for(int m=0; m<26; m++){
		largest = finalArr[m] > finalArr[largest]? m : largest;
	}
	
	System.out.println("Next best guess is : " + (char)('A'+largest)+ " with probability " + finalArr[largest]);
	
	}
	
	public static void findMostFreq(String[] words, int[] freq,int l){
		
		for(int x=0; x<l;x++){
			int largest = 0;
			for(int y=0;y<l-x;y++){
				largest = freq[y] > freq[largest]? y : largest;
			}
			
			String temp1="";
			int t=0;
			temp1=words[largest];
			words[largest]=words[l-x-1];
			words[l-x-1]=temp1;
			
			t=freq[largest];
			freq[largest]=freq[l-x-1];
			freq[l-x-1]=t;
			
			
			
		}
		
		
		
		
	}
	
	
	

}
