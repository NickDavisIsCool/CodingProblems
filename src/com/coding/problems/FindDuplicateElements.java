package com.coding.problems;

import java.util.Random;

public class FindDuplicateElements {

	public static void main(String[] args) {
		
		int bounds = 10;
		int numDuplicates = 1;
		
		
		Integer[] elements = generateElements(bounds, numDuplicates);

	}
	
	/*
	 * Generates a random uniformly distributed integer list with numbers between bounds and
	 * numDuplicates.  Placement of values is based on the nearest available position
	 * with respect to the initially randomly generated position value.
	 * 
	 */
	public static Integer[] generateElements(int bounds, int numDuplicates){
		Integer[] elements = new Integer[bounds];
		Boolean[] available = new Boolean[bounds];
		Random random = new Random();
		int pos = 0;
		int num = 0;
		
		for(int i = 0; i < available.length; i++){
			available[i] = true;
		}
		
		//Generate one occurrence of each number within bounds - numDuplicates
		for(int i = 0; i < bounds - numDuplicates; i++){
			pos = random.nextInt(bounds);
			if(available[pos % bounds]){
				elements[pos % bounds] = i;
				available[pos % bounds] = false;
			}
			else{
				while(true){
					pos++;
					if(available[pos % bounds]){
						elements[pos % bounds] = i;
						available[pos % bounds] = false;
						break;
					}
				}
			}	
		}
		
		//Generate the extra numbers to fill the rest of the array
		for(int i = 0; i < numDuplicates; i++){
			num = random.nextInt(bounds - numDuplicates);
			pos = random.nextInt(bounds);
			if(available[pos % bounds]){
				elements[pos % bounds] = num;
				available[pos % bounds] = false;
			}
			else{
				while(true){
					pos++;
					if(available[pos % bounds]){
						elements[pos % bounds] = num;
						available[pos % bounds] = false;
						break;
					}
				}
			}	
		}
		
		for(int i = 0; i < bounds; i++){
			System.out.println(elements[i]);
		}

		return elements;
	}

}
