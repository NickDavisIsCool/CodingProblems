package com.coding.problems;

import java.util.ArrayList;

public class DistinctArray {
	
// 	Direct version
//	public static void main(String[] args) {
//		Integer[] arrayNum = {14, 29, 30, 31, 32, 74, 75, 76, 77};
//		
//		
//		String output = null;
//		
//		for(int i = 0; i < arrayNum.length; i++){
//		
//			if(i == 0){
//				
//				output = "(0-" + Integer.toString(arrayNum[i] - 1) + ",";
//				if(arrayNum[i] + 1 == arrayNum[i + 1]){
//
//				} else {
//					output = output + Integer.toString(arrayNum[i] + 1) + "-";
//				}
//
//			}
//			else if(i == arrayNum.length - 1){
//				
//				if(arrayNum[i] - 1 == arrayNum[i - 1]){
//
//				} else {
//					output = output + Integer.toString(arrayNum[i] - 1) + ",";
//				}
//
//				output = output + Integer.toString(arrayNum[i] + 1) + "-100)";
//				
//			}
//			else{
//				if(arrayNum[i] - 1 == arrayNum[i - 1]){
//				
//				} else {
//					output = output + Integer.toString(arrayNum[i] - 1) + ",";
//				}		
//				if(arrayNum[i] + 1 == arrayNum[i + 1]){
//
//				} else {
//					output = output + Integer.toString(arrayNum[i] + 1) + "-";
//				}
//			}
//			
//		}
//		
//		System.out.println(output);
//	
//	}
	
//	Boolean Table version
//	public static void main(String[] args) {
//		Integer[] exclude = {0, 1, 14, 29, 30, 31, 32, 34, 36, 74, 75, 76, 77, 99, 100};
//		Boolean[] allNums = new Boolean[101];
//		String output = "(";
//		int i = 0;
//		
//		while(i <= 100){
//			allNums[i] = true;
//			i++;
//		}
//		
//		for(i = 0; i < exclude.length; i++){
//			allNums[exclude[i]] = false;
//		}
//		
//		int currentBot = 0;
//		int currentTop = -1;
//		
//		for(i = 0; i < allNums.length; i++){
//			if(allNums[i]){
//				currentTop = i;
//			}
//			if(!allNums[i]){
//				if(currentTop == currentBot){
//					output = output + Integer.toString(currentTop) + ",";
//					currentBot = i + 1;
//				}
//				else if(currentTop > currentBot){
//					output = output + Integer.toString(currentBot) + "-" + Integer.toString(currentTop) + ",";
//					currentBot = i + 1;
//				}
//				else{
//					currentBot = i + 1;
//				}
//			}
//		}
//		
//		if(currentTop == currentBot){
//			output = output + Integer.toString(currentTop) + ")";
//		}
//		else if(currentTop > currentBot){
//			output = output + Integer.toString(currentBot) + "-" + Integer.toString(currentTop) + ")";
//		}
//		else{
//			output = output.substring(0, output.length()-1) + ")";
//		}
//		
//		System.out.println(output);
//		
//		
//	}
	

	
//	List of Pairs version
//	This is probably one of the easiest to understand/nicest looking versions
//	Define a list of Bounds; each bound contains an upper and a lower bound
//	This list will describe the number ranges available
//	This version is extensible to any starting lowest/highest value
//	This version does not require excluded numbers to be in order
//	This version has a non-optimal time complexity rating
//	Time complexity could be improved upon by only keeping track of a single bound and appending that bound to the output string upon completion
	public static void main(String[] args) {
		
		//A local class 
		class Bounds{
			private int l;
			private int u;
			public Bounds(int l, int u){
				this.l = l;
				this.u = u;
			}
			public int getL(){return l;}
			public int getU(){return u;}
			public void setL(int l){this.l = l;}
			public void setU(int u){this.u = u;}
		}
		
		Integer[] exclude = {0, 1, 14, 29, 30, 31, 32, 34, 36, 74, 75, 76, 77, 99, 100};
		ArrayList<Bounds> result = new ArrayList<Bounds>();
		int lowest = 0;
		int highest = 100;

		result.add(new Bounds(lowest,highest));
		
		//Make the bounds for every integer in the exclusion list
		for(Integer ex : exclude){
			//For every bound we currently have...
			//Check and see if what we are try to exclude is either:
			//	1. Equivalent to the lowest and highest bound (remove that bound)
			//	2. Equivalent to the lowest bound (increase the lowest bound by 1)
			//	3. Equivalent to the highest bound (decrease the highest bound by 1)
			//	4. Somewhere in the middle (split the single bound into two bounds)
			//Breaks are required after modifications to result are made since the iterator is modified
			for(Bounds bound : result){
				if(ex == bound.getL() && ex == bound.getU()){
					result.remove(bound);
					break;
				}
				else if(ex == bound.getL()){
					bound.setL(ex + 1);
				}
				else if(ex == bound.getU()){
					bound.setU(ex - 1);
				}
				else if(ex > bound.getL() && ex < bound.getU()){
					Bounds lower = new Bounds(bound.getL(), ex - 1);
					Bounds upper = new Bounds(ex + 1, bound.getU());
					int index = result.indexOf(bound);
					result.add(index, upper);
					result.add(index, lower);
					result.remove(bound);	
					break;
				}
			}
		}
		
		
		String output = "(";
		for(Bounds bound : result){
			if(bound.getL() == bound.getU()){
				output += Integer.toString(bound.getL()) + ",";
			}
			else {
				output += Integer.toString(bound.getL()) + "-" + Integer.toString(bound.getU()) + ",";
			}
		}
		output = output.substring(0, output.length() - 1) + ")";
		
		System.out.println(output);
		
		
	}
	

	
}
