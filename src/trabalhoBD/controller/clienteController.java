package trabalhoBD.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import trabalhoBD.dao.Conexao;
import trabalhoBD.model.Cliente;
import trabalhoBD.model.ClienteTableModel;

public class clienteController {
	private ArrayList<Cliente> lista;
	private Conexao conectar;

	
	public clienteController(){
		this.lista = new ArrayList<Cliente>();
		this.conectar = new Conexao();
	}
	
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
			throw new Exception("O cliente n�o foi instanciado");
		}
		if(cliente.getCod()<0){
			throw new Exception("O c�digo do cliente n�o pode ser negativo");
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
		
		//abrindo conex�o
		Statement conex = conectar.conectar();
		
		String sql = "INSERT INTO cliente (nome, email, cpf)";sql += "VALUES('"+cliente.getNome() + "', '" + cliente.getEmail()+"', '" + cliente.getCpf() + "')";
		
		try{
			conex.execute(sql);
		}catch (SQLException e){
			throw new Exception("Erro ao inserir: " + e.getMessage());
		}
		conectar.desconectar();
		
		if(this.verificaExistencia(cliente)>=0){
			throw new Exception("Este cliente j� esta cadastrado");
		}
		this.lista.add(cliente);
	}
	
	//remover cliente
	public void remover(Cliente cliente) throws Exception{
		if(cliente == null){
			throw new Exception("O cliente n�o foi instanciado");
		}
		
		if (cliente.getCpf() == null){
			throw new Exception("Informar o cpf do cliente");
		}
		
		if (cliente.getCpf().trim().equals("")){
			throw new Exception("Informar o cpf do cliente");
		}
		
		
		
		//abrinco conexao
		Statement conex = conectar.conectar();
		
		//instru��o sql correspondente a remo��o do cliente
		String sql = "DELETE FROM cliente where cpf = '" + cliente.getCpf() + "'";
		
		try{
			//executando a intru��o sql
			conex.execute(sql);
		}catch(SQLException e){
			throw new Exception("Erro ao executar remo��o: "+e.getMessage());
		}
		
		//error
		if(this.verificaExistencia(cliente)== -1){
			throw new Exception("Este cliente n�o esta cadastrado");
		}
		conectar.desconectar();
		
		this.lista.remove(this.verificaExistencia(cliente));
	}
	
	
	//atualizar cliente
	public void atualizar(Cliente cliente) throws Exception{
		if (cliente == null){
			throw new Exception("O cliente n�o foi instanciado");
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
		
		//tirar ou n�o do programa ?
		if(this.verificaExistencia(cliente) == -1){
			throw new Exception("Este cliente n�o esta cadastrado");
		}
		this.lista.set(this.verificaExistencia(cliente), cliente);
	}
	
	
	public ArrayList <Cliente> pesquisar() throws Exception{
		//abrindo conexao
		Statement conex = conectar.conectar();
		ArrayList<Cliente> retorno = new ArrayList<Cliente>();
		
		String sql = "SELECT nome FROM cliente WHERE nome LIKE ? ";
		try{
			ResultSet rs = conex.executeQuery(sql);
			while(rs.next()){
				Cliente cliente1 = new Cliente();
				cliente1.setCod(rs.getInt("cod"));
				cliente1.setNnome(rs.getString("nome"));
				cliente1.setEmail(rs.getString("email"));
				cliente1.setCpf(rs.getString("cpf"));
				retorno.add(cliente1);
			}
			
			
		}catch(SQLException e){
			throw new Exception("Erro ao executar consulta: " + e.getMessage());
		}
		
		conectar.desconectar();
		return retorno;	
	}

	
	
	
	//voltar nesse metodo depois
	//pesquisar id do objeto e retornar o indice do objeto
	public int verificaExistencia(Cliente cliente){
		int retorno = -1;
		for(Cliente cli: lista){
			if(cliente.getCod() == cli.getCod()){
				retorno = cli.getCod();
				break;
			}
		}
		return retorno;
		
		/*for(int i = 0; i < this.lista.size(); i++){
			if(cliente.getCpf().trim().equals(this.lista.get(i).getCpf().trim())){
				retorno = i;
				System.out.println("retorno(dentro if):");
			}
		}
		
		
		return retorno;*/
	}
}
