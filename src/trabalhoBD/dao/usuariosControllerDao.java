package trabalhoBD.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
		Statement conex = conectar.conectar();
		ArrayList<Usuarios> retorno = new ArrayList<Usuarios>();
		String sql = "SELECT cod, nome, senha, tipo FROM usuarios ORDER BY nome";
		try{
			ResultSet rs = conex.executeQuery(sql);
			while(rs.next()){
				Usuarios user = new Usuarios();
				user.setCod(rs.getInt("cod"));
				user.setNome(rs.getString("nome"));
				user.setSenha(rs.getString("senha"));
				user.setTipo(rs.getString("tipo"));
				retorno.add(user);
			}
		}catch(SQLException e){
			throw new Exception("Erro ao executar consulta: " + e.getMessage());
		}
		conectar.desconectar();
		return retorno;
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
		if(usuarios ==null){
			throw new Exception("O login não foi instanciado");
		}
		if(usuarios.getNome()==null){
			throw new Exception("Informar o nome de usuario");
		}
		if(usuarios.getNome().trim().equals("")){
			throw new Exception("Informar o nome de usuario");
		}
		Statement conex = conectar.conectar();
		String sql = "DELETE FROM usuarios where nome = '" + usuarios.getNome() + "'";
		try{
			//executando a intrução sql
			conex.execute(sql);
		}catch(SQLException e){
			throw new Exception("Erro ao executar remoção: "+e.getMessage());
		}
		conectar.desconectar();
		if(this.verificaExistencia(usuarios)== -1){
			throw new Exception("Este login não esta mais cadastrado");
		}
		this.lista.remove(this.verificaExistencia(usuarios));
	}
	
	public void atualizar(Usuarios usuarios) throws Exception{
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
		Statement conex = conectar.conectar();
		String sql = "UPDATE usuarios SET " + " nome = '" + usuarios.getNome() + "', " + usuarios.getSenha() + "', " + "tipo = '" + usuarios.getTipo()+"'"
				+ "WHERE cod = '" + usuarios.getCod() + "'";
		try{
			conex.executeUpdate(sql);
		}catch (SQLException e){
			throw new Exception("Erro ao executar atualização: " + e.getMessage());
		}
		conectar.desconectar();
	}
	
	public int verificaExistencia(Usuarios usuarios){
		int retorno = -1;
		int i;
		for(i = 0; i< this.lista.size(); i++){
			if(usuarios.getNome().equals(this.lista.get(i).getNome())){
				retorno = i;
				break;
			}
		}
		return retorno;
	}
	
}
