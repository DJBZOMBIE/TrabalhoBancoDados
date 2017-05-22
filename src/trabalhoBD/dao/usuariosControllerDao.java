package trabalhoBD.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import trabalhoBD.model.Usuarios;

public class usuariosControllerDao {
	private ArrayList<Usuarios> lista;
	private Conexao conectar;
	
	public usuariosControllerDao(){
		this.lista = new ArrayList<Usuarios>();
		this.conectar = new Conexao();
	}
	
	//listar usuarios
	public ArrayList <Usuarios> listarTodos() throws Exception{
		return lista;
	}
	public void inserir(Usuarios usuarios) throws Exception{
		if(usuarios == null){
			throw new Exception("O usuario não foi instanciado");
		}
		if(usuarios.getNome() == null){
			throw new Exception("Informar o nome de usuario");
		}
		if(usuarios.getNome().trim().equals("")){
			throw new Exception("Informar o nome de usuario");
		}
		if(usuarios.getSenha() == null){
			throw new Exception("Informar a senha de usuario");
		}
		if(usuarios.getSenha().trim().equals("")){
			throw new Exception("Informar a senha de usuario");
		}
		if(usuarios.getTipo() == null){
			throw new Exception("Informar o tipo de usuario");
		}
		if(usuarios.getTipo().trim().equals("")){
			throw new Exception("Informar o tipo de usuario");
		}
		
		
		//abrindo conexao
		Statement conex = conectar.conectar();
		
		String sql = "INSERT INTO usuarios (nome, senha, tipo)";sql += "VALUES('"+usuarios.getNome() + "', '" + usuarios.getSenha()+"', '" + usuarios.getTipo() +"')";
		try{
			conex.execute(sql);
			
		}catch(SQLException e){
			throw new Exception("Erro ao inserir: " + e.getMessage());
		}
		conectar.desconectar();
		this.lista.add(usuarios);
		
	}
	
	//remover
	public void remover (Usuarios usuarios) throws Exception{
		
	}
	public int verificaExistencia(Usuarios usuarios) throws Exception{
		int retorno = 0;
		Statement conex = conectar.conectar();
		
		try{
			ResultSet rs = (ResultSet) conex;
			if(rs.getString("nome").equals(usuarios.getNome())){
				System.out.println("if");
				retorno = 1;
			}
		}catch(SQLException e){
			throw new Exception("Erro na verificação");
		}
		return retorno;
	}
	
}
