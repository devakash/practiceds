package testngtesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestListener {

	@Test(dataProvider="dp")
	public void a(String i, String k) {

	}
	
	@DataProvider(name="dp")
	public Object[][] dataprovider()
	{
		Object obj[][]=new Object[2][2];
		obj[0][0]="a";
		obj[0][1]="ak";
		obj[1][0]="aka";
		obj[1][1]="akas";
		return obj;
	}

}
