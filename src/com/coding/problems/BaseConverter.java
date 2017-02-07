package com.coding.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseConverter {

	public static void main(String[] args) {

		int caseNum = 1;
		String line;
		int seconds = 0;
		int base = 0;
		ArrayList<Integer> number;

		
		try {
			BufferedReader in = new BufferedReader(new FileReader("input_files/A-small-practice.in"));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output_files/A-small-practice.out")));
			while((line = in.readLine()) != null){
				number = optimize(line);
				base = minBase(number);
				seconds = (int) baseToDecimal(base, number);
				System.out.println(seconds);
				out.write("Case #" + caseNum + ": " + Integer.toString(seconds) + "\n");
				caseNum++;
			}
			
			in.close();
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		

	}

	static double baseToDecimal(int base, ArrayList<Integer> number){
		
		double decimalNumber = 0;
		
		for(int i = 0; i < number.size(); i++){			
			decimalNumber += Math.pow(base, (number.size() - 1) - i) * number.get(i);
		}
		
		return decimalNumber;
	}
	
	static ArrayList<Integer> optimize(String line){
		
		ArrayList<Integer> number = new ArrayList<Integer>();
		int currentNumber = 1;
		int i = 0;
		HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
		
		hMap.put(line.charAt(i), currentNumber);
		number.add(hMap.get(line.charAt(i)));
		currentNumber = 0;
		
		for(i = 1; i < line.length(); i++){	
			if(hMap.get(line.charAt(i)) != null){
				number.add(hMap.get(line.charAt(i)));
			}
			else{
				hMap.put(line.charAt(i), currentNumber);
				number.add(hMap.get(line.charAt(i)));
				if(currentNumber == 0){
					currentNumber = 2;
				}
				else{
					currentNumber++;
				}
			}
		}
		
		System.out.println(hMap.toString());
		System.out.println(number.toString());
		
		return number;
	}
	
	static int minBase(ArrayList<Integer> number){
		int i = 0;
		int max = 0;
		
		for(i = 0; i < number.size(); i++){
			if(number.get(i) > max){
				max = number.get(i);
			}
		}
		
		System.out.println("Base: " + Integer.toString(max + 1));
		return max + 1;
	}
	
}




/*    
 *  a6b hex -> dec 16^2 * 10 + 16^1 * 6 + 16^0 * 11 = 2560 + 96 + 11 = 2667
 *  
 * 
 * 
 * 
 */
