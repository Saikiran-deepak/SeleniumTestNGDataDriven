package Annotations;
import org.testng.annotations.*;
public class Demo {
	
	@BeforeSuite
	public void beforesuite() {
		System.out.println("hi");
	}
	@Test
	public void test() {
		System.out.println("good night");
	}
	@AfterSuite
	public void aftersuite() {
		System.out.println("bye");
	}
}
