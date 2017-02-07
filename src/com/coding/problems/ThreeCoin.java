package com.coding.problems;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ThreeCoin {

	public static void main(String[] args) {

		int maxSum = 1000;
		int i = 0;
		int index = 0;
		int placeHere = 0;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10); list.add(15); list.add(55);

		
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		i = 0;
		
		/****************************************************/
		/* The goal is to get the sum for each number		*/
		/* then add the sums for the next number to that 	*/
		/* list while maintaining the sorted order			*/
		/****************************************************/
		for(Integer p : list){
			
			while(true){
				i = result.get(index) + p; //this only works if we include an initial value (0 in my solution)
				if(i > maxSum){
					break;
				}
				/* Check our current list of resultant sums until we 	*/
				/* find a number that is larger than us					*/
				/* NOTE: not the best solution, timewise				*/
				/* Since the list is traversed naturally, it might be 	*/
				/* worth it to store all intermediate sum values		*/
				/* in a separate list and then add those while going up	*/
				while(result.get(placeHere) < i){
					placeHere++;
					if(placeHere >= result.size()){
						break;
					}
				}
				
				//no currently found sum is larger than a sum we have derived
				if(placeHere >= result.size()){ 
					result.add(i);
				}
				//Add the value to our list of sums, unless it already exists (no duplicates)
				else if(result.get(placeHere) != i){
					result.add(placeHere, i);
				}
				
				index++;
				placeHere = index;
			}
			i = 0;
			index = 0;
			placeHere = 0;
		}

		
		for(Integer x : result){
			System.out.println(x);
		}
	}
	

}
