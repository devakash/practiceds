package innerclasspractice;

public class NormalInnerPractice {
	
	int i=10;
	static int j=15;

	class innerC {
		int i=20;
		int j=25;
		public void m()
		{
			
		}

	}
	
	public static void main(String [] akash)
	{
		NormalInnerPractice nip= new NormalInnerPractice();
		innerC c=nip.new innerC();
		c.m();
	}

}
