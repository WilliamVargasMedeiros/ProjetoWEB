package executavel;

import sqlServerConnect.Conexao;

public class Start {
	
	public static void main(String[] args) {
		
		Conexao banco = new Conexao();
		String query  = "select * from Usuarios";
		
		try {
			banco.open_sqlserver(query);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				banco.close_sqlserver();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
