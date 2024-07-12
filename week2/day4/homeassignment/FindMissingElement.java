package week2.day4.homeassignment;

import java.util.Arrays;

public class FindMissingElement {

	public static void main(String[] args) {
		int numbers[] = new int[] { 1, 4, 3, 2, 8, 6, 7 };

		Arrays.sort(numbers); // Sorts the array elements in ascending order
		//System.out.println("After Sorting the values :"); 

		for (int i = 0; i < numbers.length; i++) {

		//	System.out.println(numbers[i]);

			if (numbers[i] != i+1)
				System.out.println("Missing Number : " + (i+1));
		}

	}
}

