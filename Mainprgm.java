

public class MainPrg 
{
	public static void main(String argv[])
	{
		String ds[][]={
				{"Id","Correct","S1","S2","S3","S4","S5"},
				{"t1","Yes","1","1","0","1","1"},
				{"t2","No","1","1","0","0","0"},
				{"t3","Yes","0","0","1","0","0"},
				{"t4","Yes","0","1","1","1","1"},
				{"t5","No","0","1","1","0","0"},
				{"t6","Yes","1","0","0","1","1"},
				{"t7","Yes","1","1","1","0","0"},
				{"t8","No","1","1","0","1","1"},
				{"t9","No","1","1","0","1","1"},
				{"t10","Yes","1","0","1","1","1"},
		};
		
		ProcessDS obj=new ProcessDS();
		obj.table1(ds);
		obj.table2(ds);
		obj.independentSources(ds);
		obj.sourcePrecision();
		obj.fusingCorrelatedSources();
		
		
	}

}
