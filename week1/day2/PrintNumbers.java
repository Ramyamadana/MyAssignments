package week1.day2;

public class PrintNumbers {

	public static void main(String[] args) {
		// Print only odd numbers and if numbers divisible by 3 dont print
		for (int i = 1; i <= 20; i++) {
			// checks if number is odd
			if (i % 2 == 1) {

				// checks if number is divisible by 3
				if (i % 3 == 0)
					continue;
				System.out.println(i);
			}
		}
	}

}
