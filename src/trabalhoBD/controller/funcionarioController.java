package trabalhoBD.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import trabalhoBD.dao.Conexao;
import trabalhoBD.model.Funcionario;

public class funcionarioController {
	private ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
	private Conexao conectar;
	
	public funcionarioController(){
		this.conectar = new Conexao();
	}
	
	public ArrayList <Funcionario> listarTodos() throws Exception{
		Statement conex = conectar.conectar();
		ArrayList<Funcionario> retorno = new ArrayList<Funcionario>();
		
		String sql = "SELECT cod, nome, cpf, cargo FROM funcionario ORDER BY nome";
		try{
			ResultSet rs = conex.executeQuery(sql);
			while(rs.next()){
				Funcionario func = new Funcionario();
				func.setCod(rs.getInt("cod"));
				func.setNome(rs.getString("nome"));
				func.setCpf(rs.getString("cpf"));
				func.setCargo(rs.getString("cargo"));
				retorno.add(func);
			}
		}catch(SQLException e){
			throw new Exception("Erro ao executar consulta: " + e.getMessage());
		}
		conectar.desconectar();
		
		return retorno;	
	}
	
	public void inserir(Funcionario func) throws Exception{
		if(func == null){
			throw new Exception("O funcionario não foi instanciado");
		}
		if(func.getCod()<0){
			throw new Exception("O código do funcionario não pode ser negativo");
		}
		if(func.getNome()==null){
			throw new Exception("Informar o nome do funcionario");
		}
		if(func.getNome().trim().equals("")){
			throw new Exception("Informar o nome do funcionario");
		}
		if(func.getCpf()==null){
			throw new Exception("Informar o cpf do funcionario");
		}
		if(func.getCpf().trim().equals("")){
			throw new Exception("Informar o cpf do funcionario");
		}
		if(func.getCargo()==null){
			throw new Exception("Informar o cargo do funcionario");
		}
		if(func.getCargo().trim().equals("")){
			throw new Exception("Informar o cargo do funcionario");
		}
		
		Statement conex = conectar.conectar();
		String sql = "INSERT INTO funcionario (nome,cpf,cargo)";sql += "VALUES('"+func.getNome() + "', '" + func.getCpf()+"', '"+func.getCargo()+"')";
		try{
			conex.execute(sql);
		}catch (SQLException e){
			throw new Exception("Erro ao inserir: " + e.getMessage());
		}
		conectar.desconectar();
		if(this.verificaExistencia(func)>=0){
			throw new Exception("Este funcionario já esta cadastrado");
		}
		this.lista.add(func);
	}
	
	public void remover(Funcionario func) throws Exception{
		if(func == null){
			throw new Exception("O funcionario não foi instanciado");
		}
		if(func.getCpf()==null){
			throw new Exception("Informar o cpf do funcionario");
		}
		if(func.getCpf().trim().equals("")){
			throw new Exception("Informar o cpf do funcionario");
		}
		Statement conex = conectar.conectar();
		String sql = "DELETE FROM funcionario where cpf = '" + func.getCpf() + "'";
		try{
			//executando a intrução sql
			conex.execute(sql);
		}catch(SQLException e){
			throw new Exception("Erro ao executar remoção: "+e.getMessage());
		}
		conectar.desconectar();
		if(this.verificaExistencia(func)== -1){
			throw new Exception("Este funcionario não esta mais cadastrado");
		}
		this.lista.remove(this.verificaExistencia(func));
	}
	
	public void atualizar(Funcionario func) throws Exception{
		if(func == null){
			throw new Exception("O funcionario não foi instanciado");
		}
		if(func.getCod()<0){
			throw new Exception("O código do funcionario não pode ser negativo");
		}
		if(func.getNome()==null){
			throw new Exception("Informar o nome do funcionario");
		}
		if(func.getNome().trim().equals("")){
			throw new Exception("Informar o nome do funcionario");
		}
		if(func.getCpf()==null){
			throw new Exception("Informar o cpf do funcionario");
		}
		if(func.getCpf().trim().equals("")){
			throw new Exception("Informar o cpf do funcionario");
		}
		if(func.getCargo()==null){
			throw new Exception("Informar o cargo do funcionario");
		}
		if(func.getCargo().trim().equals("")){
			throw new Exception("Informar o cargo do funcionario");
		}
		Statement conex = conectar.conectar();
		String sql = "UPDATE funcionario SET " + "nome = '" + func.getNome() + "', " + "cpf = '" + func.getCpf() + "', " + "cargo = '" + func.getCargo()+"'"
				+ "WHERE cod = '" + func.getCod() + "'";
		try{
			conex.executeUpdate(sql);
		}catch (SQLException e){
			throw new Exception("Erro ao executar atualização: " + e.getMessage());
		}
		conectar.desconectar();
		
	}
	
	public int verificaExistencia(Funcionario func) throws Exception{
		int retorno = -1;
		int i;
		for(i=0;i<this.listarTodos().size();i++){
			if(func.getCod() == this.listarTodos().get(i).getCod()){
				retorno = i;
				break;
			}
		}
		return retorno;
	}
}
