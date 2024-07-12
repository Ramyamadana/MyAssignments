package week2.day4.homeassignment;

public class FindIntersection {

	public static void main(String[] args) {

		 int arr1[] = { 3, 2, 11, 4, 6, 7 };
		 int arr2[] = { 1, 2, 8, 4, 9, 7 };		

		System.out.println("Matching values are : ");

		for (int i = 0; i < arr1.length; i++) {

			for (int j = 0; j < arr2.length; j++) {

				//Compares the values in both arrays 
				if (arr1[i] == arr2[j]) {

					System.out.println(arr1[i]); // prints the matching values
				}
			}
		}

	}

}
