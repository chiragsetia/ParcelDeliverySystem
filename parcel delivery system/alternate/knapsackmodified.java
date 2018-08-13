import java.util.*;
class knapsackmodified
{
	static class Node
	{
		int w;
		int value;
		int pos;
		Node(int a,int b,int c)
		{
			w=a;
			value=b;
			pos=c;
		}
	}
	static Node[][] Subset(Node obj[],int n)
	{
		int k1=1;
			for(int i=1;i<=n;i++)
				k1*=2;
			Node a[][]=new Node[k1][];
			int b[]=new int[n];
			int c=0;
			a[0]=new Node[1];
			a[0][0]=null;
			for(int i=1;i<k1;i++)
			{
				c=0;
				int j=i;
				for(int k=0;k<n;k++)
					{
						
						b[k]=j%2;
						if(b[k]==1)
							c++;
						j/=2;
					}
				a[i]=new Node[c];
				int k=0;
				for(int l=0;l<n;l++)
				{
					if(b[l]==1)
						{
							a[i][k]=obj[l];
							k++;	//break
						}
				}

			}
			return(a);
	}


	public static void main(String[] args) {
		Scanner abc=new Scanner(System.in);
		int n=abc.nextInt();
		int max=abc.nextInt();
		Node ob[]=new Node[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the value and then wt ");
			int a=abc.nextInt();
			int b=abc.nextInt();
			ob[i]=new Node(b,a,i+1);
		}

		Node subset[][]=Subset(ob,n);
		int l=subset.length;
		int c=0;
		int tv[]=new int[l];

		int wt,v;
		for(int i=1;i<l;i++)
		{
			wt=0;
			v=0;
			for(int j=0;j<subset[i].length;j++)
			{
				wt=wt+subset[i][j].w;
			}
			if(wt<=max)
			{
				for(int j=0;j<subset[i].length;j++)
					v=v+subset[i][j].value;

				tv[i]=v;
				c++;
			}

			else
				tv[i]=0;
		}
		int mv=tv[1];
		int maxp=1;
		for(int i=2;i<l;i++)
		{
			if(mv<tv[i])
				{
					mv=tv[i];
					maxp=i;
				}
					else if(mv==tv[i])
					{
						if(subset[i].length>subset[maxp].length)
						mv=tv[i];
					maxp=i;	
					}
		}
		if(c==0)
			{System.out.println("wt is each and every element is larger that maxwt");
		return;}
		System.out.println(mv);

		for(int i=0;i<subset[maxp].length;i++)
			System.out.print(subset[maxp][i].pos+" ");
	}
}


/*
if c=0
*/