import java.util.*;
import java.sql.*;
public class BatchProcessingJdbc{
	public static void main(String[] args)throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student",Username,Password);
		Statement st=con.createStatement();
		con.setAutoCommit(false);
		try{
			st.addBatch("insert into stu values('raji',13,28);");
			st.addBatch("insert into stu values('chandrs',11,55);");
			st.addBatch("insert into stu values('waste',12,30);");
			st.addBatch("update stu set sName='RajeswariRamasamy',sAge=25 where sNo=13;");
			st.addBatch("delete from stu where sNo=10;");
			int[] a=st.executeBatch();
			for(int a1:a){
				System.out.println("rows affected"+a1);
			}
		con.commit();
		}
		catch(Exception e){
			System.out.println("entered catch");
			con.rollback();
			System.out.println(e.getMessage());
		}
	}
}
		

		
