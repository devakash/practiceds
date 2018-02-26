package datastructure;

public class FinalPrice {
	//this is comment
	public static void main(String[] args) {
		int i[]={1,1,1,1,1};
		int sum=0;
		String indices="";
		
		a: for(int j=0;j<i.length;j++)
		{
			b: for(int k=j+1;k<i.length;k++)
			{
				if(i[k]<=i[j])
				{
					sum=sum+(i[j]-i[k]);
					continue a;
				}
				else
				{
					continue b;
				}
			}
			sum=sum+i[j];
			indices=indices+" "+j;
			indices=indices.trim();
				
		}
		
		System.out.println(sum);
		System.out.println(indices);
	}

}
