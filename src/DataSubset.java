import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DataSubset {

	String[]track_ids;
	
	
	public DataSubset(int limit) throws Exception
	{
		Connection c = null;
		Statement stmt=null;

		
	   this.track_ids=getArrayOfTrackIds(limit);
	   
	      
	}
	
	 public static String[] getArrayOfTrackIds(int limit) throws Exception
	 {
		 ResultSet rs=queryDB("Select distinct track_id from lyrics limit" + limit);
		 
		 
		 ArrayList<String> trackIDs=new ArrayList();
 
 
		 
		  while (rs.next())
			  
			  
		  {
			  
			 trackIDs.add(rs.getString(1));
			  
			  
		  }
		  
		String []tracks=trackIDs.toArray(new String[trackIDs.size()]);
		return tracks;
		
		
	 }
	 public static ResultSet queryDB (String query) throws Exception{
			
			
		 Connection c = null;
			Statement stmt=null;

			
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:mxm_dataset.db");
		      c.setAutoCommit(true);
		     
		      
				
					 
						
					      
					      stmt = c.createStatement();
					    
						   int counter=0;
					      ResultSet rs =   stmt.executeQuery(query);
					
					      return rs;
					   
					     
	}
	
}
