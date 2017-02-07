package com.coding.problems;

import java.util.ArrayList;

public class CodingProblemTwo {

	public static void main(String[] args) {
		
		String S = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
		String[] s = S.split("\n");
		ArrayList<String> options = new ArrayList<String>();
		String string = null;
		int maxLength = 0;
		for(int i = 0; i < s.length; i++){
			int lowDirectoryDepth = 0;
			int currentDirDepth = 0;
			String p = s[i];
			if(p.endsWith(".jpeg") || p.endsWith(".gif") || p.endsWith(".png")){
				for(int j = 0; j < p.length(); j++){
					if(p.charAt(j) == ' '){
						lowDirectoryDepth++;
					}
					else{
						currentDirDepth = lowDirectoryDepth;
						string = p.trim();
						break;
					}
				}
				for(int k = i - 1; k >= 0; k--){
					lowDirectoryDepth = 0;
					for(int j = 0; j < s[k].length(); j++){
						if(s[k].charAt(j) == ' '){
							lowDirectoryDepth++;
						}
						
						if(lowDirectoryDepth < currentDirDepth){
							currentDirDepth = lowDirectoryDepth;
							string = s[k].trim() + "/" + string;
							break;
						}
					}
				}
				
				options.add(string);
			}
		}
				
		for(String x : options){
			int cutOff = x.lastIndexOf("/");
			x = x.substring(0, cutOff + 1);
			System.out.println(x);
			if(x.length() > maxLength){
				maxLength = x.length();
			}
		}
		
		System.out.println(maxLength);
		
	
	}
}
