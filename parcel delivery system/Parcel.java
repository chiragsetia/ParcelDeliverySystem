public class Parcel {
	int weight;
	int pid;
	station stations;
	int priority;
	Boolean loaded=false;
	int profit;
	Parcel(station st,int wt,int id,int p,int profits)
	{
		stations=st;
		weight=wt;
		pid=id;
		priority=p;
		profit=profits;
	}
}