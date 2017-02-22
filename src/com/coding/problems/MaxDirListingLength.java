package com.coding.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class MaxDirListingLength {

	public static void main(String[] args) {
		
		String S = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
		String[] s = S.split("\n");
		Stack<String> path = new Stack<>();
		String string = null;
		int maxLength = 0;
		int currentDirectoryDepth = -1;
		for(int i = 0; i < s.length; i++){
		    String concat = "/";
		    int whitespace = 0;
            int tempCounter = 1;
            for(int j = 0; j < s[i].length(); j++){
                if(s[i].charAt(j) == ' '){
                    whitespace++;
                } else {
                    break;
                }
			}

			if(s[i].endsWith(".jpeg") || s[i].endsWith(".gif") || s[i].endsWith(".jpg")){
			    for(String temp : path){
			        tempCounter += temp.length() + 1;
                }
                if(tempCounter > maxLength){
			        maxLength = tempCounter;
                }
            }

			if(whitespace > currentDirectoryDepth){
                path.push(s[i].trim());
                currentDirectoryDepth++;
            } else if(whitespace == currentDirectoryDepth){
			    path.pop();
			    path.push(s[i].trim());
            } else {
                path.pop(); path.pop();
                path.push(s[i].trim());
                currentDirectoryDepth--;
            }

            for(String temp : path){
                concat += temp + "/";
            }
            System.out.println(concat.substring(0, concat.length()-1));

		}

		
		System.out.println(maxLength);

	}
}
