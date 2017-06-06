package trabalhoBD.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import trabalhoBD.dao.Conexao;
import trabalhoBD.model.Cliente;
import trabalhoBD.model.ClienteTableModel;
import trabalhoBD.model.Produto;

public class clienteController {
	private ArrayList<Cliente> lista = new ArrayList<Cliente>();
	private Conexao conectar;

	
	public clienteController(){
		//this.lista = new ArrayList<Cliente>();
		this.conectar = new Conexao();
	}
	
	
	//listar clientes
	public ArrayList <Cliente> listarTodos() throws Exception{
		//abrindo conexao
		Statement conex = conectar.conectar();
		ArrayList<Cliente> retorno = new ArrayList<Cliente>();
		
		String sql = "SELECT cod, nome, email, cpf FROM cliente ORDER BY nome";
		try{
			ResultSet rs = conex.executeQuery(sql);
			while(rs.next()){
				Cliente cliente = new Cliente();
				cliente.setCod(rs.getInt("cod"));
				cliente.setNnome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setCpf(rs.getString("cpf"));
				retorno.add(cliente);
			}
		}catch(SQLException e){
			throw new Exception("Erro ao executar consulta: " + e.getMessage());
		}
		conectar.desconectar();
		
		return retorno;	
	}
	
	//inserir cliente
	public void inserir(Cliente cliente) throws Exception{
		
		if (cliente == null){
			throw new Exception("O cliente não foi instanciado");
		}
		if(cliente.getCod()<0){
			throw new Exception("O código do cliente não pode ser negativo");
		}
		
		if (cliente.getCpf() == null){
			throw new Exception("Informar o cpf do cliente");
		}
		
		if (cliente.getCpf().trim().equals("")){
			throw new Exception("Informar o cpf do cliente");
		}
		
		if(cliente.getNome() == null){
			throw new Exception("Informar o nome do cliente");
		}
		if(cliente.getNome().trim().equals("")){
			throw new Exception("Informar o nome do cliente");
		}
		if(cliente.getEmail() == null){
			throw new Exception("Informar o email do cliente");
		}
		if(cliente.getEmail().trim().equals("")){
			throw new Exception("Informar o email do cliente");
		}
		
		//abrindo conexão
		Statement conex = conectar.conectar();
		
		String sql = "INSERT INTO cliente (nome, email, cpf)";sql += "VALUES('"+cliente.getNome() + "', '" + cliente.getEmail()+"', '" + cliente.getCpf() + "')";
		
		try{
			conex.execute(sql);
		}catch (SQLException e){
			throw new Exception("Erro ao inserir: " + e.getMessage());
		}
		conectar.desconectar();
		
		if(this.verificaExistencia(cliente)>=0){
			throw new Exception("Este cliente já esta cadastrado");
		}
		this.lista.add(cliente);
	}
	
	//remover cliente
	public void remover(Cliente cliente) throws Exception{
		if(cliente == null){
			throw new Exception("O cliente não foi instanciado");
		}
		
		if (cliente.getCpf() == null){
			throw new Exception("Informar o cpf do cliente");
		}
		
		if (cliente.getCpf().trim().equals("")){
			throw new Exception("Informar o cpf do cliente");
		}
		
		
		
		//abrindo conexao
		Statement conex = conectar.conectar();
		
		//instrução sql correspondente a remoção do cliente
		String sql = "DELETE FROM cliente where cpf = '" + cliente.getCpf() + "'";
		
		try{
			//executando a intrução sql
			conex.execute(sql);
		}catch(SQLException e){
			throw new Exception("Erro ao executar remoção: "+e.getMessage());
		}
		
		
		conectar.desconectar();
		//error
				if(this.verificaExistencia(cliente)== -1){
					throw new Exception("Este cliente não esta mais cadastrado");
				}
		this.lista.remove(this.verificaExistencia(cliente));
	}
	
	
//atualizar cliente
	public void atualizar(Cliente cliente) throws Exception{
		if (cliente == null){
			throw new Exception("O cliente não foi instanciado");
		}
		
		if (cliente.getCpf() == null){
			throw new Exception("Informar o cpf do cliente");
		}
		
		if (cliente.getCpf().trim().equals("")){
			throw new Exception("Informar o cpf do cliente");
		}
		
		if(cliente.getNome() == null){
			throw new Exception("Informar o nome do cliente");
		}
		if(cliente.getNome().trim().equals("")){
			throw new Exception("Informar o nome do cliente");
		}
		if(cliente.getEmail() == null){
			throw new Exception("Informar o email do cliente");
		}
		if(cliente.getEmail().trim().equals("")){
			throw new Exception("Informar o email do cliente");
		}
		
		Statement conex = conectar.conectar();
		String sql = "UPDATE cliente SET " + " nome = '" + cliente.getNome() + "', " + "email = '" + cliente.getEmail() + "', " + "cpf = '" + cliente.getCpf()+"'"
				+ "WHERE cod = '" + cliente.getCod() + "'";
		try{
			conex.executeUpdate(sql);
		}catch (SQLException e){
			throw new Exception("Erro ao executar atualização: " + e.getMessage());
		}
		conectar.desconectar();
		
		
	}
	
	//verificar existencia do produto pelo codigo(id)
		public int verificaExistencia(Cliente cliente){
			int retorno = -1;
			int i;
			for(i = 0; i< this.lista.size(); i++){
				if(cliente.getCod() == this.lista.get(i).getCod()){
					retorno = i;
					System.out.println("retorno \n"+retorno);
					break;
				}
			}
			return retorno;
		}
}
