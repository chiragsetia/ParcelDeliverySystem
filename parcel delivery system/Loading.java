class Path {
	int vertices=5;
    int minD(int dist[], Boolean sptSet[])
    {
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < vertices; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }
 
    int[] dijkstra(int g[][], int src)
    {
        int dist[] = new int[vertices]; 
        Boolean sptSet[] = new Boolean[vertices];
 
        
        for (int i = 0; i < vertices; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
 
        dist[src] = 0;

        for (int count = 0; count < vertices-1; count++)
        {
           
            int u = minD(dist, sptSet);
            sptSet[u] = true;
 
            for (int v = 0; v < vertices; v++)
 
                if (!sptSet[v] && g[u][v]!=0 && dist[u] != Integer.MAX_VALUE && 
                	dist[u]+g[u][v] < dist[v])
                    dist[v] = dist[u] + g[u][v];
        }
 
        return dist;
    }
}


public class Loading{
	
	public static void sortParcels(Parcel parcels[])
	{
        int n = parcels.length;
        for (int i = 0; i < n-1; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
                if (parcels[j].priority > parcels[j+1].priority)
                {
                    Parcel temp = parcels[j];
                    parcels[j] = parcels[j+1];
                    parcels[j+1] = temp;
                }
        		if(parcels[j].priority == parcels[j+1].priority)
        		{
        			if(parcels[j].stations.leastCostToGo<parcels[j+1].stations.leastCostToGo)
        			{
        				Parcel temp = parcels[j];
                        parcels[j] = parcels[j+1];
                        parcels[j+1] = temp;
        			}
        		}
            }
        }
	}
	public static void sortByProfit(Parcel parcels[])
	{
        int n = parcels.length;
        for (int i = 0; i < n-1; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
            	if (parcels[j].priority > parcels[j+1].priority)
                {
                    Parcel temp = parcels[j];
                    parcels[j] = parcels[j+1];
                    parcels[j+1] = temp;
                }
        		if(parcels[j].priority == parcels[j+1].priority)
        		{
        			if(parcels[j].profit/parcels[j].weight<parcels[j+1].profit/parcels[j+1].weight)
        			{
        				Parcel temp = parcels[j];
                        parcels[j] = parcels[j+1];
                        parcels[j+1] = temp;
        			}
        		}
            }
        }
	}
	public static void main(String args[])
	{
		station stations[]=new station[5];
		stations[0]=new station();
		stations[0].name='A';
		stations[0].id=0;
		stations[1]=new station();
		stations[1].name='B';
		stations[1].id=1;
		stations[2]=new station();
		stations[2].name='C';
		stations[2].id=2;
		stations[3]=new station();
		stations[3].name='D';
		stations[3].id=3;
		stations[4]=new station();
		stations[4].name='E';
		stations[4].id=4;
		Parcel parcels[]=new Parcel[6];
	//ex//parcels[i]=new Parcel(station[i],wt,id,priority,profit)
//		parcels[0]=new Parcel(stations[1],5,101,1,1000);
//		parcels[1]=new Parcel(stations[1],4,102,2,2000);
//		parcels[2]=new Parcel(stations[2],9,103,1,1500);
//		parcels[3]=new Parcel(stations[3],11,104,3,1800);
//		parcels[4]=new Parcel(stations[4],2,105,2,1400);
//		parcels[5]=new Parcel(stations[2],4,106,3,1600);
		
		//CASE-1
		parcels[0]=new Parcel(stations[1],5,101,1,1000);
		parcels[1]=new Parcel(stations[1],4,102,2,2000);
		parcels[2]=new Parcel(stations[2],6,103,1,1500);
		parcels[3]=new Parcel(stations[3],5,104,3,1800);
		parcels[4]=new Parcel(stations[4],4,105,2,1400);
		parcels[5]=new Parcel(stations[2],1,106,1,1600);
		//CASE-2
//		parcels[0]=new Parcel(stations[1],5,101,3,1000);
//		parcels[1]=new Parcel(stations[1],4,102,2,2000);
//		parcels[2]=new Parcel(stations[2],5,103,1,1500);
//		parcels[3]=new Parcel(stations[3],6,104,1,1800);
//		parcels[4]=new Parcel(stations[4],6,105,1,1400);
//		parcels[5]=new Parcel(stations[2],7,106,1,1600);
//		
		for(int i=0;i<parcels.length;i++)
		{
			switch (parcels[i].stations.name)
			{
				//case 'A': stations[0].weight_to_be_delivered+=parcels[i].weight;
					//	stations[0].parcelList.add(parcels[i]);
						//break;
				case 'B': stations[1].weight_to_be_delivered+=parcels[i].weight;
						stations[1].parcelList.add(parcels[i]);
						break;
				case 'C': stations[2].weight_to_be_delivered+=parcels[i].weight;
						stations[2].parcelList.add(parcels[i]);
						break;
				case 'D': stations[3].weight_to_be_delivered+=parcels[i].weight;
						stations[3].parcelList.add(parcels[i]);
						break;
				case 'E': stations[4].weight_to_be_delivered+=parcels[i].weight;
						stations[4].parcelList.add(parcels[i]);
						break;
				default:
					System.out.println("error");
					break;
			}	
			
		}
		for(int i=1;i<stations.length;i++)
		{
			System.out.print(stations[i].name+":"+ " total weight: "+stations[i].weight_to_be_delivered+" Parcels list: ");
			for(Parcel o:stations[i].parcelList)
			{
				System.out.print(o.pid+" ");
			}
			System.out.println();
		}
		
		truck trucks[]=new truck[1];
		trucks[0]=new truck(20);
		//trucks[1]=new truck(25);
		//int time[][]={{0,1,0,2,0},{1,0,3,0,4},{0,3,0,0,2},{2,0,0,0,0},{0,4,2,0,0}};
		int time[][]={{0,1,6,2,6},{1,0,3,2,4},{6,3,0,3,2},{2,2,3,0,6},{6,4,2,6,0}};
		Path t = new Path();
		
	    int dist[]= t.dijkstra(time, 0);
	    int z=0;
	    for(int i:dist)
	    {
	    	//System.out.println(i);
	    	stations[z].leastCostToGo=i;
	    	z++;
	    }
		int spaceAvailable=trucks[0].capacity;
		sortParcels(parcels);
		//print sorted parcels
		//sortByProfit(parcels);
//		for(int i=0;i<parcels.length;i++)
//		{
//			System.out.println(parcels[i].pid);
//		}
		int wtSum1=0;
		int wtSum=0;
		for(int i=0;i<parcels.length;i++)
		{
			if(parcels[i].priority==1)
			{
				wtSum1+=parcels[i].weight;
			}
			wtSum+=parcels[i].weight;
		}
		
		Boolean journey2=false;
		//loading parcels
		Parcel parcelsLoaded[]=new Parcel[parcels.length];
		int k=0;
		if(wtSum1<=trucks[0].capacity)
		{
			for(int i=0;i<parcels.length;i++)
			{
				if(spaceAvailable>0)
				{
					if(parcels[i].priority==1)
					{
						if(spaceAvailable>=parcels[i].weight&&parcels[i].loaded==false)
						{
							if(!trucks[0].path.contains(parcels[i].stations))
							{
								trucks[0].path.add(parcels[i].stations);
							}
							spaceAvailable=spaceAvailable-parcels[i].weight;
							parcels[i].loaded=true;
							parcelsLoaded[k]=parcels[i];
							k++;
						}
					}
					else if(parcels[i].priority==2)
					{
						if(spaceAvailable>=parcels[i].weight && trucks[0].path.contains(parcels[i].stations))
						{
							//trucks[0].path.add(parcels[i].stations);
							spaceAvailable=spaceAvailable-parcels[i].weight;
							parcels[i].loaded=true;
							parcelsLoaded[k]=parcels[i];
							k++;
						}
					}
					else if(parcels[i].priority==3)
					{
						if(spaceAvailable>=parcels[i].weight && trucks[0].path.contains(parcels[i].stations))
						{
							//trucks[0].path.add(parcels[i].stations);
							spaceAvailable=spaceAvailable-parcels[i].weight;
							parcels[i].loaded=true;
							parcelsLoaded[k]=parcels[i];
							k++;
						}
					}
				}
				else
				{
					break;
				}
			}
		}
		else
		{
			journey2=true;
			sortByProfit(parcels);
			for(int i=0;i<parcels.length;i++)
			{
				if(spaceAvailable>0)
				{
					if(parcels[i].priority==1)
					{
						if(spaceAvailable>=parcels[i].weight && parcels[i].loaded==false)
						{
							if(!trucks[0].path.contains(parcels[i].stations))
							{
								trucks[0].path.add(parcels[i].stations);
							}
							spaceAvailable=spaceAvailable-parcels[i].weight;
							parcels[i].loaded=true;
							parcelsLoaded[k]=parcels[i];
							k++;
						}
					}
					else if(parcels[i].priority==2)
					{
						if(spaceAvailable>=parcels[i].weight && trucks[0].path.contains(parcels[i].stations))
						{
							//trucks[0].path.add(parcels[i].stations);
							spaceAvailable=spaceAvailable-parcels[i].weight;
							parcels[i].loaded=true;
							parcelsLoaded[k]=parcels[i];
							k++;
						}
					}
					else if(parcels[i].priority==3)
					{
						if(spaceAvailable>=parcels[i].weight && trucks[0].path.contains(parcels[i].stations))
						{
							//trucks[0].path.add(parcels[i].stations);
							spaceAvailable=spaceAvailable-parcels[i].weight;
							parcels[i].loaded=true;
							parcelsLoaded[k]=parcels[i];
							k++;
						}
					}
				}
				else
				{
					break;
				}
			}
			
		}
		int temp[]=new int[trucks[0].path.size()+1];
		temp[0]=0;
		int d=1;
		//System.out.println(spaceAvailable);
		// print current truck path
		if(!journey2)
		{
			if(wtSum>trucks[0].capacity)
			{
				System.out.println();
				System.out.println("Cannot send all parcels in single journey due to limited truck capacity");
				System.out.println("For optimized result, send the following parcels first on the given route..");
				System.out.println();
			}
			System.out.print("Stations to be travelled :- ");
			for(station o:trucks[0].path)
			{
				System.out.print(o.name+" ");
				temp[d]=o.id;
				d++;
			}
			System.out.println();
			
			// print parcels loaded
			System.out.print("Parcels(id) covered in this path :- ");
			for(int j=0;j<k;j++)
			{
				System.out.print(parcelsLoaded[j].pid+" ");
			}
			System.out.println();
		}
		else
		{
			System.out.println("Cannot send all parcels in single journey due to limited truck capacity");
			System.out.println("For optimized result, send the following parcels first on the given route..");
			System.out.println();
			System.out.print("Stations to be travelled :- ");
			for(station o:trucks[0].path)
			{
				System.out.print(o.name+" ");
				temp[d]=o.id;
				d++;
			}
			System.out.println();
			
			// print parcels loaded
			System.out.print("Parcels(id) covered in this path :- ");
			for(int j=0;j<k;j++)
			{
				System.out.print(parcelsLoaded[j].pid+" ");
			}
			System.out.println();
			System.out.println();
			System.out.println("rest of the parcels will be sent in next journey");
		}
		for(int h=0;h<5;h++)
		{
			for( int j=0;j<5;j++)
			{
				if(h==j)
					time[h][j]=1000;
			}
		}
		
		int n1=temp.length;
		int f[][]=new int[n1][n1];
		
		for(int h=0;h<n1;h++)
		{
			for( int j=0;j<n1;j++)
			{
				f[h][j]=time[temp[h]][temp[j]];
				//System.out.println(f[h][j]);
			}
		}
		
//		for(int i=0;i<temp.length;i++)
//		{
//			for(int j=0;j<temp.length;j++)
//			{
//				System.out.print(f[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		int a[][]=f;
		int ref[][]=new int[n1][n1];
		for(int i=0;i<n1;i++)
		{
			for(int j=0;j<n1;j++)
			{
				if(j==0)
					ref[i][0]=0;
			else if(i!=j)
				ref[i][j]=1;
				else
					ref[i][i]=0;
			}
		}
		int sum=0;
		int b=0;//
		int min;
		int c=n1;//length
		
//		for(int i=0;i<5;i++)
//			{
//				for(int j=0;j<5;j++)
//					System.out.print(a[i][j]+" ");
//				System.out.println();
//			}
//			for(int i=0;i<5;i++)
//			{
//				for(int j=0;j<5;j++)
//					System.out.print(ref[i][j]+" ");
//				System.out.println();
//			}
		int i=0;//index of starting node
		System.out.print("Best shortest path: ");
		System.out.print("A"+" ");
		while(c>1)
		{
			c--;
			min=a[i][i];
			for(int j=0;j<n1;j++)
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
			for(int j=0;j<n1;j++)
			{
				ref[j][b]=0;
			}
			
			
			if(i!=b)
			{
				if(b==1)
				{
					System.out.print("B"+" ");
				}
				if(b==2)
				{
					System.out.print("C"+" ");
				}
				if(b==3)
				{
					System.out.print("D"+" ");
				}
				if(b==4)
				{
					System.out.print("E"+" ");
				}
			//System.out.println(b);
			sum=sum+a[i][b];
			i=b;
			}
		}
		System.out.println();
		System.out.println("Total cost of journey: "+sum);

		
	}
}
