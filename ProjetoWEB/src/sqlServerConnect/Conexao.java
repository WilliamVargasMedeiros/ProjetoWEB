package sqlServerConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {
	Connection con;
	
	public void open_sqlserver(String query) throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = 	"jdbc:sqlserver://localhost:1433;" +
						"databaseName=ProjetoWEB;integratedSecurity=true;" +
						"encrypt=true;trustServerCertificate=true";
		
		con            = DriverManager.getConnection(url);
		Statement stmt = con.createStatement();
		ResultSet rs   = stmt.executeQuery(query);
		
		System.out.println(rs+"\nConexao Realizada.");
		
		while (rs.next()) {
			System.out.println(rs.getString("ID") + " | " + rs.getString("NOME"));
		}
	}
	
	public void close_sqlserver() throws Exception{
		if (con != null) {
			con.close();
		}
	}
	
}
