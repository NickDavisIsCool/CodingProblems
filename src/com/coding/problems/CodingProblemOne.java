package com.coding.problems;
import java.util.ArrayList;


//Reduce a number's size by a power of ten
//by taking two adjacent numbers and replacing them with the average
//find the maximum of these numbers
public class CodingProblemOne {

	public static void main(String[] args) {
		
		int X = 792838;
		int newX = 0;
		int maxX = 0;
		ArrayList<Integer> list = splitNumber(X);
        
		/************************************************/
		/*	Start at the most significant digits			
			Get the two digits w/respect to location		
			Average those values and ceiling them		
			Make the new number by:						
			 -Clearing the two digits			
			 -Adding the average value * smallest digit	
			We only need to keep doing this until		
			the newX is <= the current maxX				
			If replacing the ith location is smaller		
			than the previous step... then we won't		
			find any larger changes in less significant	
			digits... 10^4 * 1 > 10^3 * 9 + 10^2 * 9 ... */
		/************************************************/
		for(int i = list.size()-1; i > 0; i--){
			
			int lowerNum = list.get(i-1);
			int higherNum = list.get(i);
			int avg = (int) Math.ceil((double)(lowerNum + higherNum) / 2);
			
			newX = (int) (clearNumber(list, i-1) + avg * Math.pow(10, i-1));
			if(newX > maxX){
				maxX = newX;
			}
			else{
				break;
			}

		}
		
		System.out.println(maxX);
		
		
	}
	
	/*
	 * Splits an integer into an ArrayList of the individual digits
	 * Location in the List signifies its significance
	 */
	public static ArrayList<Integer> splitNumber(int X){
		
		ArrayList<Integer> list =  new ArrayList<Integer>();
		
		for(int i = 0; X % Math.pow(10, i) != X; i++){
			list.add((int) (X % Math.pow(10, i+1) / Math.pow(10, i)));
		}
		
		return list;
		
	}
	
	/*
	 * Removes the values at pos and pos+1 from an integer list
	 * Replaces the value at that location with a single 0
	 * Example:
	 *  [5,1,3,4,4,5], pos = 3
	 *  result: 50315
	 */
	public static int clearNumber(ArrayList<Integer> list, int pos){
		int pre = 0;
		int post = 0;
		
		for(int i = 0; i < pos; i++){
			pre += list.get(i) * Math.pow(10, i);
		}
		for(int i = pos + 2; i < list.size(); i++){
			post += list.get(i) * Math.pow(10, i);
		}
		
		post = post / 10;
		return pre + post;
	}
	
}

