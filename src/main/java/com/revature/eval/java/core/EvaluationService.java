package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * DONE
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		// Attributes, char arrays for holding the chars in the string and a string for writing the reverse into
		char[] hold = new char[string.length()];
		String result = "";
		
		// Pass the string into a character array in hold
		hold = string.toCharArray();
		// Go backwards through the character array and place the characters into the result string
		for(int i = hold.length-1; i >= 0; i--) {
			result = result + hold[i];
		}
		
		// Return the reversed string
		return result;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// Create an array to hold the words in the phrase and a string to hold the result
		// Split the phrase into the individual words
		// TODO split punctuated stuff as well
		String[] words1 = phrase.split(" |-");
		String result = "";
		
		// Loop through the individual words and take the first character in the word
		for(String s : words1) {
			s = s.toUpperCase();
			result = result + s.charAt(0);
		}
		// Return the result
		return result;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 * DONE
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// Check if any of the sides do not equal any of the other sides
			if(sideOne != sideTwo || sideOne != sideThree || sideTwo != sideThree)
				return false;
			return true;
		}

		public boolean isIsosceles() {
			// Check if one of the pairs of sides is equal
			if(sideOne == sideTwo || sideOne == sideThree || sideTwo == sideThree)
				return true;
			return false;
		}

		public boolean isScalene() {
			// Check if any of the sides is equal to another side
			if(sideOne == sideTwo || sideOne == sideThree || sideTwo == sideThree)
				return false;
			return true;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * DONE
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// Create a TreeMap to hold the values and points for each letter
		int score = 0;
		TreeMap<Character, Integer> letters = new TreeMap<>();
		letters.put('A', 1); letters.put('B', 3); letters.put('C', 3); letters.put('D', 2); letters.put('E', 1);
		letters.put('F', 4); letters.put('G', 2); letters.put('H', 4); letters.put('I', 1); letters.put('J', 8);
		letters.put('K', 5); letters.put('L', 1); letters.put('M', 3); letters.put('N', 1); letters.put('O', 1);
		letters.put('P', 3); letters.put('Q', 10); letters.put('R', 1); letters.put('S', 1); letters.put('T', 1);
		letters.put('U', 1); letters.put('V', 4); letters.put('W', 4); letters.put('X', 8); letters.put('Y', 4);
		letters.put('Z', 10);
		
		// Pass the word into an array of characters
		char[] word = string.toUpperCase().toCharArray();
		// Loop through the array and add up the score according to the values in the TreeMap
		for(char c:word) {
			score+=letters.get(c);
		}
		// Return the resulting score
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO check length and check for only numbers
		String result = "";
		// Put the input into an array of characters
		char[] nums = string.toCharArray();
		for(int i = 0; i<nums.length; i++) {
			// If the character is a letter throw an exception
			if((nums[i] >= 65 && nums[i] <= 90) || (nums[i] >= 97 && nums[i] <= 122)) {
				throw new IllegalArgumentException();
			}
			// If the character is @,:, or ! throw an exception
			if(nums[i] == '@' || nums[i] == ':' || nums[i] == '!') {
				throw new IllegalArgumentException();
			}
			// Check if the character is a number and add it to the result if it is
			if(nums[i] != '(' && nums[i] != ')' && nums[i] != '-' && nums[i] != '.' && nums[i] != '+' && nums[i] != ' ') {
				result+= nums[i];
				System.out.println(nums[i]);
			}
		}
		
		if(result.length() > 11) {
			throw new IllegalArgumentException();
		}
		// Return the result
		return result;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO don't count \n as a word
		// Split the input into an array of strings
		String[] sent = string.split(" |,|\n");
		HashMap<String, Integer> result = new HashMap<>();
		// Loop through the array of words
		for(int i = 0; i < sent.length; i++) {
			// Check to see if the TreeMap contains the word already and isn't empty
			if(!result.containsKey(sent[i]) && !sent[i].isEmpty()) {
				// If it doesn't then add it and go through the array
				result.put(sent[i], 1);
				for(int j = i + 1; j < sent.length; j++) {
					// If the word is the same as the current word then increment the value in the Map
					if(sent[i].equals(sent[j])) {
						int inc = result.get(sent[i]);
						inc++;
						result.replace(sent[i], inc);
					}
				}
			}
		}
		
		// Return the result
		return result;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 * DONE
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// Hold the input value
			T item = t;
			// Get the upper and lower bounds of the search
			int upper = sortedList.size();
			int lower = 0;
			// Set an initial value for the index
			int result = sortedList.size()/2;
			// Get the value at the selected index
			T hold = sortedList.get(result);
			System.out.println(hold);
			// Loop the search while the item has not been found
			while(item.compareTo(hold) != 0) {
				// Test which direction to go in
				if(item.compareTo(hold) < 0) {
					// If the item is less than the result reset the upper bound and find a new result
					upper = result;
					result = (upper + lower) / 2;
				} else {
					// If the item is greater than the result reset the lower bound and find a new result
					lower = result;
					result = (upper + lower) / 2;
				}
				// Get the value at the new result index
				hold = sortedList.get(result);
			}
			// Once the index is found, return it
			return result;
//			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}


	/**
	 * 8. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * DONE?
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// Pass the input into a string
		String i = "" + input;
		// Pass the string into a char array of the individual digits
		char[] digits = i.toCharArray();
		int result = 0;
		// Loop through each digit
		for(char c:digits) {
			// Parse the digit into an int, then calculate the power of the digit to the number of digits and add it to the result
			String hold = "" + c;
			result += Math.pow(Integer.parseInt(hold), digits.length);
		}
		// Check if the resulting calculation is the same as the input
		if(result == input) {
			return true;
		}
		return false;
	}

	/**
	 * 9. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * DONE
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// Pass the string into a character array to check the individual characters
		char[] letters = string.toUpperCase().toCharArray();
		// Create a treemap of letters and booleans to check off if each letter was used
		TreeMap<Character, Boolean> alpha = new TreeMap<>();
		alpha.put('A', false); alpha.put('B', false); alpha.put('C', false); alpha.put('D', false); alpha.put('E', false);
		alpha.put('F', false); alpha.put('G', false); alpha.put('H', false); alpha.put('I', false); alpha.put('J', false);
		alpha.put('K', false); alpha.put('L', false); alpha.put('M', false); alpha.put('N', false); alpha.put('O', false);
		alpha.put('P', false); alpha.put('Q', false); alpha.put('R', false); alpha.put('S', false); alpha.put('T', false);
		alpha.put('U', false); alpha.put('V', false); alpha.put('W', false); alpha.put('X', false); alpha.put('Y', false);
		alpha.put('Z', false);
		// Loop through each character in the input and check that letter off in the treemap
		for(char c : letters) {
			if(alpha.containsKey(c)) {
				alpha.replace(c, true);
			}
		}
		// Loop through the treemap and if any of the letters has a false value then return false
		Set<Character> keys = alpha.keySet();
		for(Character key : keys) {
			if(!alpha.get(key)) {
				return false;
			}
		}
		return true;
	}

	
	/**
	 * 10. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Numbers and Punctuation needs to be handled
			// Pass the input into an array of characters
			char[] chars = string.toCharArray();
			String result = "";
			// Go through each character
			for(char c : chars) {
				// Check if the character is a lowercase letter
				if(c >= 97 && c <= 122) {
					// Check if the character needs to be wrapped around
					if((char)(c + key) > 'z') {
						result += (char)(c - (26-key));
					} else {
						result += (char)(c + key);
					}
				// Check if the character is an uppercase letter
				} else if(c >= 65 && c <= 90) {
					if((char)(c + key) > 'Z') {
						result += (char)(c - (26-key));
					} else {
						result += (char)(c + key);
					}
				// If it's not a letter don't rotate it
				} else {
					result += "" + c;
				}
			}
			// Return the result
			return result;
		}

	}
	

	/**
	 * 11 & 12. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		
		/**
		 * Question 11
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// Lists of alphabet forward, backward, and upper and lower case
			ArrayList<String> upperAlf = new ArrayList<String>();
			ArrayList<String> lowerAlf = new ArrayList<String>();
			ArrayList<String> reverseAlf = new ArrayList<String>();
			
			// Populate the arraylists
			for(int i = 65; i < 91; i++) {
				char c = (char)i;
				upperAlf.add("" + c);
			}
			for(int i = 97; i < 123; i++) {
				char c = (char)i;
				lowerAlf.add("" + c);
			}
			for(int i = lowerAlf.size() - 1; i >= 0; i--) {
				reverseAlf.add(lowerAlf.get(i));
			}
			
			// Pass the input into an array of characters
			char[] c = string.toCharArray();
			String result = "";
			int fixed = 0;
			
			// Check value of character, find reversed letter at index and append to result
			for(int i = 0; i < c.length; i++) {
				// Group at a fixed length
				System.out.println(fixed);
				if(fixed == 5 && i != c.length - 1) {
					fixed = 0;
					result += " ";
				}
				
				// Find the index of the character
				int index = -1;
				if(upperAlf.contains("" + c[i])) {
					index = upperAlf.indexOf("" + c[i]);
				} else if(lowerAlf.contains("" + c[i])) {
					index = lowerAlf.indexOf("" + c[i]);
				}
				
				// Find the oppossite character and put it in the result
				if(index != -1) {
					result += reverseAlf.get(index);
					fixed++;
				} else if(c[i] != ' ' && c[i] != ',' && c[i] != '.') {
					result += "" + c[i];
					fixed++;
				}
			}
			System.out.println("end");
			// Return the result
			return result;
		}

		/**
		 * Question 12
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// Lists of alphabet forward, backward, and upper and lower case
			ArrayList<String> lowerAlf = new ArrayList<String>();
			ArrayList<String> reverseAlf = new ArrayList<String>();
			
			// Populate the arraylists
			for(int i = 97; i < 123; i++) {
				char c = (char)i;
				lowerAlf.add("" + c);
			}
			for(int i = lowerAlf.size() - 1; i >= 0; i--) {
				reverseAlf.add(lowerAlf.get(i));
			}
						
			// Pass the input into an array of characters
			char[] c = string.toCharArray();
			String result = "";
						
			// Check value of character, find reversed letter at index and append to result
			for(int i = 0; i < c.length; i++) {				
				// Find the index of the character
				int index = -1;
				if(reverseAlf.contains("" + c[i])) {
					index = reverseAlf.indexOf("" + c[i]);
				}
						
				// Find the oppossite character and put it in the result
				if(index != -1) {
					result += lowerAlf.get(index);
				} else if(c[i] != ' ') {
					result += "" + c[i];
				}
			}
						
			// Return the result
			return result;
		}
	}

	/**
	 * 13. (Optional) The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}


	/**
	 * 14. (Optional) Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	
	/**
	 * 15. (Optional) Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		return 0;
	}

}
