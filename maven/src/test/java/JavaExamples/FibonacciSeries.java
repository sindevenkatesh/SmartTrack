package JavaExamples;

public class FibonacciSeries {

	public static void main(String[] args) {

		int n = 10, a = 0, b = 1;

		int sum;

		for (int i = 0; i <= n; i++) {

			sum = a + b;
			
			a = b;
			b = sum;
			
			System.out.println(sum);

		}
	}
}