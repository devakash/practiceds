package javaakash;

public class InnerTest {
	
	class firstInner
	{
		public void goGet() throws Exception
		{
			System.out.println("N/A-1");
		}
	}
	
	class secondInner extends firstInner
	{
		public void goGet() throws Exception
		{
			System.out.println("N/A-2");
		}
	}
	
	public static void main(String[] args) throws Exception {
		InnerTest t=new InnerTest();
		t.new secondInner().goGet();
	}

}
