package com.coding.problems;

import java.util.HashMap;
import java.util.Random;

public class FindDuplicateElements {

	//creates an array with all values sorted.
	//duplicates can be found at the end, as -x - bounds, where x is a duplicate number
	//additionally, duplicates can be found internally, at pos elements[x] = x + bounds*y where y is the number of duplicate occurances
	public static void main(String[] args) {
		
		int bounds = 100;
		int numDuplicates = 5;
		
		
		Integer[] elements = generateElements(bounds, numDuplicates);
		elements = findDuplicates(elements, bounds);

	}
	
	//Attempt to have O(N) time with O(1) space complexity, worst case
	//Idea: use modulus, and negatives to flip positions and determine duplicates
	//Given: an array of elements, the bounds (can be derived from array length anyway)
	public static Integer[] findDuplicates(Integer[] elements, int bounds){
		int current;
		int flip;
		
		//sorts the list by moving objects into their correct locations
		//takes, at most, 2N iterations, making it O(N) for N array elements
		//Worst case: we sort everything while sitting in the 0th position, takes:
		//	N moves to sort
		//	N moves to move through the list
		for(int i = 0; i < elements.length; i++){
			//if this element is <0, it's a repeat, so don't move it around
			if(elements[i] < 0){
				continue;
			}
			
			//the location we could flip with.  Could be a dup value, ie > bounds, so take the modulo
			flip = elements[elements[i] % bounds];
			
			//if i and elements[i] are the same (w/resp to duplicates) do nothing
			if(elements[i] % bounds == i){
				continue;
			}
			
			//If what we are flipping with is the same value, then mark it as a duplicate by:
			//	Adding bounds to itself at the flip location
			//	Subtracting bounds from the negative of the element
			//This marks, internally, the value at sorted location, and makes the negative value bubble up
			else if(elements[i] == flip % bounds){
				elements[elements[i]] += bounds;
				elements[i] = -elements[i] - bounds; //java does not support -0, which causes issues with 0 as a duplicate
			}
			
			//Otherwise just flip normally
			//subtract 1 from i so that we stay at this place and flip next round
			else{
				elements[elements[i]] = elements[i];
				elements[i] = flip;
				i--;
			}
		}
		
		printArray(elements);
		
		return elements;
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
		
		printArray(elements);

		return elements;
	}
	
	public static void printArray(Integer[] array){
		System.out.print("[");
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + ",");
		}
		System.out.print("]\n");
	}

}
