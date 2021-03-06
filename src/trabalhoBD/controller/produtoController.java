package trabalhoBD.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import trabalhoBD.dao.Conexao;

import trabalhoBD.model.Produto;

public class produtoController {
	
	
	private ArrayList<Produto> lista;
	private Conexao conectar;

	
	public produtoController(){
		this.lista = new ArrayList<Produto>();
		this.conectar = new Conexao();
	}
	
	//listar clientes
	public ArrayList <Produto> listarTodos() throws Exception{
		//abrindo conexao
		Statement conex = conectar.conectar();
		ArrayList<Produto> retorno = new ArrayList<Produto>();
		
		String sql = "SELECT cod, nome, saldo, cod_barras FROM Produto ORDER BY nome";
		try{
			ResultSet rs = conex.executeQuery(sql);
			while(rs.next()){
				Produto prod = new Produto();
				prod.setCod(rs.getInt("cod"));
				prod.setNome(rs.getString("nome"));
				prod.setSaldo(rs.getInt("saldo"));
				prod.setCod_Barras(rs.getString("cod_barras"));
				retorno.add(prod);
			}
		}catch(SQLException e){
			throw new Exception("Erro ao executar consulta: " + e.getMessage());
		}
		conectar.desconectar();
		
		return retorno;	
	}
	
	//pq n�o deu certo ?
	public void inserir(Produto produto) throws Exception{
		if (produto == null){
			throw new Exception("O produto n�o foi instanciado");
		}
		if(produto.getCod()<0){
			throw new Exception("O id n�o pode ser negativo");
		}
		if(produto.getCod_Barras()== null){
			throw new Exception("Informar o c�digo de barras do produto");
		}
		if(produto.getCod_Barras().trim().equals("")){
			throw new Exception("Informar o c�digo de barras do produto");
		}
		if(produto.getNome()==null){
			throw new Exception("Informar o nome do produto");
		}
		if(produto.getNome().trim().equals("")){
			throw new Exception("Informar o nome do produto");
		}
		if(produto.getSaldo()<=0){
			throw new Exception("O saldo do produto dever� ser superior a zero");
		}
		
		Statement conex = conectar.conectar();
		
		String sql = "INSERT INTO produto (nome, saldo, cod_barras)";sql += "VALUES('"+produto.getNome() + "', '" + produto.getSaldo()+"', '" + produto.getCod_Barras()+ "')";
		
		try{
			conex.execute(sql);
		}catch(SQLException e){
			throw new Exception("Erro ao inserir: " + e.getMessage());
		}
		conectar.desconectar();
		
		if(this.verificaExistencia(produto)>=0){
			throw new Exception("O produto j� esta cadastrado");
		}
		this.lista.add(produto);
	}
	
	public void remover(Produto produto) throws Exception{
		if (produto == null){
			throw new Exception("O produto n�o foi instanciado");
		}
		if(produto.getCod_Barras() == null){
			throw new Exception("Informar o c�digo de barras do produto");
		}
		if(produto.getCod_Barras().trim().equals("")){
			throw new Exception("Informar o c�digo de barras do produto");
		}
		
		
		Statement conex = conectar.conectar();
		
		String sql = "DELETE FROM produto Where cod = '" + produto.getCod() + "'";
		
		try{
			conex.execute(sql);
		}catch(SQLException e){
			throw new Exception("Erro ao executar remo��o: " + e.getMessage());
		}
		
		conectar.desconectar();
		if(this.verificaExistencia(produto)==-1){
			throw new Exception("O produto n�o esta mais cadastrado");
		}
		this.lista.remove(this.verificaExistencia(produto));
	}
	
	public void atualizar(Produto produto) throws Exception{
		if (produto == null){
			throw new Exception("O produto n�o foi instanciado");
		}
		if(produto.getCod_Barras()==null){
			throw new Exception("Informar o c�digo de barras do produto");
		}
		if(produto.getCod_Barras().trim().equals("")){
			throw new Exception("Informar o c�digo de barras do produto");
		}
		if(produto.getNome()==null){
			throw new Exception("Informar o nome do produto");
		}
		if(produto.getNome().trim().equals("")){
			throw new Exception("Informar o nome do produto");
		}
		if(produto.getSaldo()<=0){
			throw new Exception("O saldo do produto dever� ser superior a zero");
		}
		Statement conex = conectar.conectar();
		String sql = "UPDATE produto SET " + " nome = '" + produto.getNome() + "', " + "saldo= '" + produto.getSaldo() + "', " + "cod_barras= '" + produto.getCod_Barras()+"'"
				+ "WHERE cod = '" + produto.getCod() + "'";
		try{
			conex.executeUpdate(sql);
		}catch (SQLException e){
			throw new Exception("Erro ao executar atualiza��o: " + e.getMessage());
		}
		conectar.desconectar();
	}
	
	public int verificaExistencia(Produto produto){
		int retorno = -1;
		for(Produto prod:lista){
			if(produto.getCod()==prod.getCod()){
				retorno = prod.getCod();
				break;
			}
		}
		return retorno;
	}
}
