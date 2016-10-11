
public class ProcessDS 
{
	double pr[];
	double rc[];
	public void table1(String ds[][])
	{
		 pr=new double[6];
		 rc=new double[6];
		for(int i=1;i<=5;i++)
		{
			double tyes=0.0,feqticks=0.0,totalyes=0;;
			for(int j=1;j<=10;j++)
			{
				if(ds[j][i+1].equals("1") && ds[j][1].equals("Yes"))
					tyes++;
				if(ds[j][i+1].equals("1"))
					feqticks++;
				
				if(ds[j][1].equals("Yes"))
					totalyes++;
					
					
				
			}
			//System.out.print("\n tyes="+tyes+" feqticks="+feqticks);
			double p=tyes/(tyes+(feqticks-tyes));
			double r=tyes/(totalyes);
			
			String result = String.format("%.2f", p);
			p=Double.parseDouble(result);
			
			result = String.format("%.2f", r);
			r=Double.parseDouble(result);
			pr[i]=p;
			rc[i]=r;
			//System.out.print("\n P"+i+" = "+p);
			//System.out.print("\n R"+i+" = "+r);
			
		}
	
	
	System.out.print("\n Precisions : ");
	for(int i=1;i<=5;i++)
	{
		System.out.print("  P"+i+" = "+pr[i]);
	}
	
	System.out.print("\n\n Recalls    : ");
	for(int i=1;i<=5;i++)
	{
		System.out.print("  R"+i+" = "+rc[i]);
	}
	
}
	
	
	
	public void table2(String ds[][])
	{
		double pr[]=new double[3];
		double rc[]=new double[3];
		int comb1[][]={
				{2,3},
				{1,3}
		};
		for(int i=0;i<comb1.length;i++)
		{
			double tyes=0.0,feqticks=0.0,totalyes=0;;
			
			for(int j=1;j<=10;j++)
			{
				if(ds[j][comb1[i][0]+1].equals("1") && ds[j][1].equals("Yes") && ds[j][comb1[i][1]+1].equals("1") && ds[j][1].equals("Yes"))
					tyes++;
				
				if(ds[j][comb1[i][0]+1].equals("1") && ds[j][comb1[i][1]+1].equals("1"))
					feqticks++;
				
				if(ds[j][1].equals("Yes"))
					totalyes++;
					
					
				
			}
			//System.out.print("\n tyes="+tyes+" feqticks="+feqticks);
			double p=tyes/(tyes+(feqticks-tyes));
			double r=tyes/(totalyes);
			
			String result = String.format("%.2f", p);
			p=Double.parseDouble(result);
			
			result = String.format("%.2f", r);
			r=Double.parseDouble(result);
			pr[i]=p;
			rc[i]=r;
			//System.out.print("\n P"+i+" = "+p);
			//System.out.print("\n R"+i+" = "+r);
			
		}
	
	
	
	

	
	
//////////////
	double pr1[]=new double[3];
	double rc1[]=new double[3];
	int comb2[][]={
			{1,2,4},
			{1,4,5}
	};
	for(int i=0;i<comb2.length;i++)
	{
		double tyes=0.0,feqticks=0.0,totalyes=0;;
		
		for(int j=1;j<=10;j++)
		{
			if(ds[j][comb2[i][0]+1].equals("1") && ds[j][1].equals("Yes") && ds[j][comb2[i][1]+1].equals("1") && ds[j][1].equals("Yes") && ds[j][comb2[i][2]+1].equals("1") && ds[j][1].equals("Yes") )
				tyes++;
			
			if(ds[j][comb2[i][0]+1].equals("1") && ds[j][comb2[i][1]+1].equals("1") && ds[j][comb2[i][2]+1].equals("1"))
				feqticks++;
			
			if(ds[j][1].equals("Yes"))
				totalyes++;
				
				
			
		}
		//System.out.print("\n tyes="+tyes+" feqticks="+feqticks);
		double p=tyes/(tyes+(feqticks-tyes));
		double r=tyes/(totalyes);
		
		String result = String.format("%.2f", p);
		p=Double.parseDouble(result);
		
		result = String.format("%.2f", r);
		r=Double.parseDouble(result);
		pr1[i]=p;
		rc1[i]=r;
		//System.out.print("\n P"+i+" = "+p);
		//System.out.print("\n R"+i+" = "+r);
		
	}

	System.out.print("\n Precisions : ");
	for(int i=0;i<comb1.length;i++)
	{
		System.out.print("  PS"+comb1[i][0]+"S"+comb1[i][1]+" = "+pr[i]);
	}

for(int i=0;i<comb2.length;i++)
{
	System.out.print("  PS"+comb2[i][0]+"S"+comb2[i][1]+"S"+comb2[i][2]+" = "+pr1[i]);
}

System.out.print("\n\n Recalls    : ");
for(int i=0;i<comb1.length;i++)
{
	System.out.print("  RS"+comb1[i][0]+"S"+comb1[i][1]+" = "+rc[i]);
}
for(int i=0;i<comb2.length;i++)
{
	System.out.print("  RS"+comb2[i][0]+"S"+comb2[i][1]+"S"+comb2[i][2]+" = "+rc1[i]);
}

	
	//////////////////
	
	
	
	
}
	
	public void independentSources(String ds[][])
	{
		int tid[]={2,8};
		double q[]={0.0,0.5,0.67,0.167,0.33,0.33};
		
		System.out.print("\n\n For independent sources ...\n");
		for(int i=0;i<tid.length;i++)
		{
			int sel[]=new int[6];
			for(int j=1;j<=5;j++)
			{
				if(ds[tid[i]][j+1].equals("1"))
					sel[j]=1;
				else
					sel[j]=0;
				
			}
		/*	System.out.print("\n t ticks :");
			for(int k=1;k<=5;k++)
			{
				System.out.print(" "+sel[k]);
			}
*/			
			double mu=1.0;
			for(int j=1;j<=5;j++)
			{
				if(sel[j]==1)
					mu*=rc[j]/q[j];
				else
					mu*=(1-rc[j])/(1-q[j]);
			}
			String result = String.format("%.2f", mu);
			mu=Double.parseDouble(result);
			
			
			System.out.print("\nMu value for T"+tid[i]+" = "+ mu);
			double alpha=0.5;
			double prob=1.0/(1+((1-alpha)/alpha)*(1/mu));
			result = String.format("%.2f", prob);
			prob=Double.parseDouble(result);
			System.out.print("\nProb value for T"+tid[i]+" = "+prob);
			
			System.out.print("\nT"+tid[i]+" case "+prob);
			if(prob<alpha)
				System.out.print(" < ");
			else
				System.out.print(" > ");
			System.out.print(" " + alpha+ " hence " + (!(prob<alpha)));
			
		}
		
	}
	
	
	public void sourcePrecision()
	{
		double res=0.0,alpha=0.5;
		res=pr[1]/ ( pr[1]+rc[1]-pr[1]*rc[1]);
		System.out.print("\n\n res="+res  +"  alpha="+alpha);
		if(alpha<res)
		{
			double q1=(alpha/(1-alpha)) * ( (1-pr[1])/pr[1])* rc[1];
			System.out.print("\n as res is < alpha then q1  ="+q1);
		}
		if(pr[1]>alpha)
		{
			
		System.out.print("\nP1 value is 0.57 > alpha value 0.5(alpha) so s1 is good source");
		}
		
	}
	
	public void fusingCorrelatedSources()
	{
		double r1245 = 0.22, r12345 = 0.11;
		double q1245 = 0.22, q12345 = 0.185;
		double mu=r12345/q12345;
		double prob=1/(1+ q12345/r12345);
	System.out.print("\n\n Title fusing correlated sources..\n");	
		System.out.print("\n mu="+mu +" prob ="+prob);
		System.out.print("\ntaking aplha =0.5, probability =0.37 so t8 is false"); 

	}
	
	
	
}
