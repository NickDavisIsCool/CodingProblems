This Readme describes the individual applications located within the src directory.
Eventually I want to make a coding problem testing system that allows people to upload a problem type and the current solution (something I or other people come up with), and then create a problem interface for other people to download and try to implement their own solution, kind of like a "coding problem repository" that just has a bunch of coding problems, the current solutions, and a way for people to clone the repository and try to implement their own solutions to the problems presented while having a way to check their correctness against multiple example problems.  I also want to implement a timing feature (i.e. time their code execution, maybe time how long it takes for them to submit a final solution somehow?)

###BaseConverter:
	A solution to the Google Code Jam Round 1C 2009 problem A
	- Takes a string input, converts characters to numbers in the lowest base possible dependent on the number of characters in the string
	- Minimizes the number by using the smallest available digits possible in the most significant location
	- Takes the derived number and its base and converts it to decimal
	
###DistinctArray:
	A solution to a random coding problem stumbled upon online
	- Takes an array of integers as input
	- Also take a lowest/highest bound for a number line
	- Derive a string that describes the numbers not included in the initial array
	- Example:
		Input: Min: 0, Max: 100, Array: [0,1,45,46,48,15,75]
		Output: [2-14,16-44,47,49-74,76-100]
		
###ThreeCoin:
	A solution to a random coding problem stumbled upon online
	- Takes in 3 coin values as input, and a maximum sum size.
	- Derives all possible coin values between 0 and the maximum sum size in order from smallest to largest sum.
	- Example:
		Input: Coins: 5, 53, 76; maxSum: 1000
		Condensed Output: 0,5,10,15,20,25,30,35,40,50,53,55,58,60,63,65,68,70,73,75,76,...
		
###MaximumDigitReplacement:
	A solution to a random coding problem stumbled upon online
	- Takes an input integer
	- Outputs an integer that is the maximum of all possible integers derived by taking two adjacent values in the integer and replacing both of those values with the ceiling of the average.
	- Example:
		Input: 792838
		Output: 82838 (7 + 9 / 2 = 8, replace 79 with 8, 82838 > 7....)
		
###MaxDirListingLength:
	A solution to a random coding problem stumbled upon online
	- Takes a string representing a directory listing as input.
		1. All names are separated by a newline character: '\n'
		2. Directory depth is represented by the number of ' ' or spaces before the name
		3. A directory is a child of the closest directory before it with 1 less space before the name
	- Outputs the length of the longest directory path to reach a file with an image descriptor extension.
		1. All whitespace is removed from before the name when counting
		2. The newline symbols are removed from the name before counting
		3. A directory delimiter symbol, /, is placed between each directory and is included when counting
		4. The actual file itself is not included when counting the length, only the directory names and the directory delmiter symbols are included when counting
	- Example:
		Input: "DIRECTORY\n DIRECTORY293\n DIRECTORY9292\n  file.jpeg\n name.gif"
		Output: 24, String: "DIRECTORY/DIRECTORY9292/"
		
###FindDuplicateElements:
	A solution to finding multiple duplicate elements in an array when each element is 0 <= x < N, where N is the size of the array.
	- Generates an array with d duplicates
	- Outputs a sorted array with an internally represented format for duplicates.
	- Can detect:
		1. The number of duplicates that a given value has within the array
		2. Duplicates associated with multiple values in the array
	- Works in O(N) time (loops 3N time to display duplicates), with O(1) space (does not create extra data structures outside of the initial array
		
