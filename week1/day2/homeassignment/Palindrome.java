package week1.day2.homeassignment;

public class Palindrome {

	// checks whether the given number is a Palindrome or not
	public static void main(String[] args) {
		int input = 121, output = 0, rem;

		for (int i = input; i > 0; i = i / 10) {
			rem = i % 10;
			output = output * 10 + rem;			
		}

		// checks if input and output are equal
		if (input == output)
			System.out.println(input + " is Palindrome.");
		else
			System.out.println(input + " is not Palindrome.");

	}
}
