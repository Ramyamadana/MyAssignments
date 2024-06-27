package week1.day2;

public class FindOddNumbers {

	public static void main(String[] args) {
		// Prints odd and even numbers from 1 to 10

		int maxRange = 10;
		
		for (int i = 1; i <= maxRange; i++) {
			if (i % 2 == 1) {
				System.out.println(i + " is odd");
			}

			else if (i % 2 == 0) {
				System.out.println(i + " is even");
			}

		}
	}

}
