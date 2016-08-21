package ucsd;

import java.io.*;
import java.util.*;
import java.util.HashMap;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    HashMap<Character, Integer> h1 = new HashMap<>();
    String s12 ="abcde";
    String[] strings = {"abc","abccc","avdd"};
    char[] abc = s12.toCharArray();
    Set<String> set1= new HashSet<String>();
    
    //Set<Character> mySet = new HashSet<>(Arrays.asList(abc));
    String s1 = "abcde";
    String s2 = "dabce";
    String s3="sd"+2;
    System.out.println(s3);
    for(int i =0;i<s1.length(); i++){
      if(h1.containsKey(s1.charAt(i))){
    	  
    }
      else
        h1.put(s1.charAt(i),1);
      
    }
  }
}

class Tree{
	
	Tree left;
	Tree right;
	int a;
}
