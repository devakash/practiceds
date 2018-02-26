package testngtesting;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listener extends TestListenerAdapter {
	@Override
	public void onTestSuccess(ITestResult tr) {

		Object o[]=tr.getParameters();
		for(Object obj:o)
		{
			System.out.print(obj+" ");
		}
		System.out.println( );
	}

}
