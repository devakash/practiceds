package APIClient;

public class PitInArray {
	
	public static void main(String[] args) {
		int t[]={0,1,3,-2,0,1,0,-3,2,3};
		int p=0;
		int q=0;
		int r=0;
		int deepPit=-1;
		outer:for(int i=0;i<t.length-1;i++)
		{
			if((t[i]>t[i+1]))
			{
				p=t[i];
				q=t[i+1];
				
				int k=i+1;
				inner:for(int j=k+1;j<t.length;j++)
				{
					if(t[j]>q)
					{
						r=t[j];
						int pit=getDeepPit(p,q,r);
						if(pit>deepPit)
						{
							deepPit=pit;
							continue outer;
						}
					}
				}
				
			}
		}
		
		System.out.println(deepPit);
	}

	private static int getDeepPit(int p, int q, int r) {
		return (p-q)<(r-q)?(p-q):(r-q);
		
	}

}
