
public class createDocuments {
	
	public static void main(String[]args) throws Exception
	{
	 DataSubset dSubset=new DataSubset(10000);
	 for (String track_id:dSubset.track_ids)
	 {
		 System.out.println(track_id);
		 
	 }
		
	}

}
