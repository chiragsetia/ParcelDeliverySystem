import java.util.*;

class up 
{
	public static void main(String[] args)
	{
		int a[][]={{1000,20,10,15,5},{20,1000,15,6,20},{10,15,1000,7,10},{15,6,7,1000,20},{5,20,3,20,1000}};
		int ref[][]=new int[5][5];
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(i!=j)
				ref[i][j]=1;
				else
					ref[i][i]=0;
			}
		}
		int sum=0;
		int b=0;//
		int min;
		int c=5;//length
		
		for(int i=0;i<5;i++)
			{
				for(int j=0;j<5;j++)
					System.out.print(a[i][j]+" ");
				System.out.println();
			}
			for(int i=0;i<5;i++)
			{
				for(int j=0;j<5;j++)
					System.out.print(ref[i][j]+" ");
				System.out.println();
			}
		int i=0;//index of starting node
		System.out.println(i);
		while(c>1)
		{
			c--;
			min=a[i][i];
			for(int j=0;j<5;j++)
			{
				if(ref[i][j]==1)
				{
				if(min>a[i][j])
				{
					b=j;
					min=a[i][j];
				}
			}
			}
			
			ref[b][i]=0;
			for(int j=0;j<5;j++)
			{
				ref[j][b]=0;
			}
			
			
			if(i!=b)
			{
			System.out.println(b);
			sum=sum+a[i][b];
			i=b;
			}
		}
		System.out.println(sum);

	}
}
