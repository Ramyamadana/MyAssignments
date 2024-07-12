package week1.day2.homeassignment;

public class FibonacciSeries {

	public static void main(String[] args) {
		// Program to print Fibonacci Series
		
		int num1=0, num2=1, num3, i, count=10; 
		//Prints 0 and 1
		System.out.print(num1+" "+num2);
		
		
		for(i=2; i<count;i++)
		{
			num3 = num1 + num2;	
			System.out.print(" "+num3);
			num1=num2;
			num2=num3;			
			
		}

	}

}
