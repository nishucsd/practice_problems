package ucsd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File f1= new File("D:/lookup.txt");
		Scanner sc= new Scanner(f1);
		
		while(sc.hasNext()) {
			String str = sc.nextLine();
			if(str.trim().equals("")) {
				System.out.println(" ");continue;
			}
			int a = Integer.parseInt(str);
			
			switch(a){
			case 1:
				System.out.println("Business");
				break;
			case 2:
				System.out.println("Vacation");
				break;
			case 3:
				System.out.println("Visiting friends and relatives");
				break;
			case 4:
				System.out.println("School");
				break;
			case 5:
				System.out.println("Conference/Convention");
				break;
			case 6:
				System.out.println("Wedding/funeral");
				break;
			case 7:
				System.out.println("Moving");
				break;
			case 8:
				System.out.println("Military");
				break;
			case 9:
				System.out.println("Other");
				break;
			
			
			
			
			}
			
		}
		
		sc.close();
		
	}

}
