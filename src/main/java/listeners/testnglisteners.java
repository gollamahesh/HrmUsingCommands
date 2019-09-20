package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

 
public class testnglisteners implements ITestListener{

	public void onFinish(ITestContext result) {
System.out.println("Test case finished results are :"+result.getName());		
	}

	public void onStart(ITestContext result) {
		System.out.println("Test case started results are :"+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
System.out.println("Test case failed but with success percentage results are :"+result.getName());		
	}

	public void onTestFailure(ITestResult result) {
System.out.println("Test case failure results are :"+result.getName());		
	}

	public void onTestSkipped(ITestResult result) {
System.out.println("Test case skipped results are :"+result.getName());		
	}

	public void onTestStart(ITestResult result) {
System.out.println("Test case test started results are :"+result.getName());		
	}

	public void onTestSuccess(ITestResult result) {
System.out.println("Test case onTestSuccess results are :"+result.getName());		
	}

}
