package trabalhoBD.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
	public Connection con;
	public Statement stm;
	
	public Statement conectar() throws Exception{
		try{
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/loja", "postgres", "1234");
			stm = con.createStatement();
		}catch(SQLException sqle){
			throw new Exception("Erro ao conectar ao banco de dados: "+ sqle.getMessage());
		}
		return stm;
	}
	
	public void desconectar(){
		try{
			con.close();
		}catch(SQLException sqle){
			
		}
	}
}
