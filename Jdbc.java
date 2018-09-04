import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {

	public static void main(String[] args) {
		
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection ObjConnection=DriverManager.getConnection("jdbc:oracle:thin:@172.16.5.73:1521:oracle","ce1808260","ce1808260");  

			Statement ObjStatement=ObjConnection.createStatement();
			ResultSet ObjResultSet=ObjStatement.executeQuery("select *from dept");
			
			
			while(ObjResultSet.next()) 
			{
			
				System.out.print(ObjResultSet.getString(1)+" "+ObjResultSet.getString(2)+" "+ObjResultSet.getString(3));
				System.out.println();
			}
			
			if( ObjResultSet !=null)
				ObjResultSet.close();
			if(ObjStatement !=null)
				ObjStatement.close();
			if(ObjConnection!=null)
				ObjConnection.close();
		}
		catch(ClassNotFoundException e) {
			System.out.println(e);
			
		}
		catch(SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

}
