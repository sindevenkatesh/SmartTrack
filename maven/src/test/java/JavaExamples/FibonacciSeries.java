package JavaExamples;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class FibonacciSeries {
	
	@Test
	public void fibonacci() {
		
		int n=10,j=0,k=1;
		
		for(int i=1;i<=n;i++) {
			
			int sum=j+k;
			j=k;
			k=sum;		
			System.out.println("Fibonacci : "+k);						
		}
	}
	
	@Test
	public void fibo() {
		int i=1,n=10,j=0,k=1;
		while(i<=n) {
			int add=j+k;
			j=k;
			k=add;
			System.out.println("fibo :"+k);
			i++;
		}
	}
	

}
