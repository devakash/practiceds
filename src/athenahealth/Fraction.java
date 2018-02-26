package athenahealth;

import java.util.HashMap;
import java.util.Scanner;
/**
 * 
 * @author ajain5
 *
 */
public class Fraction {
	
	public static void main(String[] args) {
		
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		HashMap<Double, Integer> hm=new HashMap<Double, Integer>();
		for(int x=1; x<=n;x++)
		{
			for(int y=x; y<=n;y++)
			{
				double p=(double)x/(double)y;
				if(x/y!=1)
				{
					if(hm.containsKey(p))
					{
						continue;
					}
					else
					{
						hm.put(p, 1);
					}
				}
				
			}
		}
		System.out.println(hm.size());
		scn.close();
	}
}
