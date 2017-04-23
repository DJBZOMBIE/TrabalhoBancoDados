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
				prod.setCodigoBarras(rs.getString("cod_barras"));
				retorno.add(prod);
			}
		}catch(SQLException e){
			throw new Exception("Erro ao executar consulta: " + e.getMessage());
		}
		conectar.desconectar();
		
		return retorno;	
	}
	
	public void inserir(Produto produto) throws Exception{
		if (produto == null){
			throw new Exception("O produto não foi instanciado");
		}
		if(produto.getCod()<0){
			throw new Exception("O id não pode ser negativo");
		}
		if(produto.getCodigoBarras()==null){
			throw new Exception("Informar o código de barras do produto");
		}
		if(produto.getCodigoBarras().trim().equals("")){
			throw new Exception("Informar o código de barras do produto");
		}
		if(produto.getNome()==null){
			throw new Exception("Informar o nome do produto");
		}
		if(produto.getNome().trim().equals("")){
			throw new Exception("Informar o nome do produto");
		}
		if(produto.getSaldo()<=0){
			throw new Exception("O saldo do produto deverá ser superior a zero");
		}
		
		if(this.verificaExistencia(produto)>=0){
			throw new Exception("O produto já esta cadastrado");
		}
		this.lista.add(produto);
	}
	
	public void remover(Produto produto) throws Exception{
		if (produto == null){
			throw new Exception("O produto não foi instanciado");
		}
		if(produto.getCodigoBarras() == null){
			throw new Exception("Informar o código de barras do produto");
		}
		if(produto.getCodigoBarras().trim().equals("")){
			throw new Exception("Informar o código de barras do produto");
		}
		
		if(this.verificaExistencia(produto)==-1){
			throw new Exception("O produto não esta cadastrado");
		}
		this.lista.remove(this.verificaExistencia(produto));
	}
	
	public void atualizar(Produto produto) throws Exception{
		if (produto == null){
			throw new Exception("O produto não foi instanciado");
		}
		if(produto.getCodigoBarras()==null){
			throw new Exception("Informar o código de barras do produto");
		}
		if(produto.getCodigoBarras().trim().equals("")){
			throw new Exception("Informar o código de barras do produto");
		}
		if(produto.getNome()==null){
			throw new Exception("Informar o nome do produto");
		}
		if(produto.getNome().trim().equals("")){
			throw new Exception("Informar o nome do produto");
		}
		if(produto.getSaldo()<=0){
			throw new Exception("O saldo do produto deverá ser superior a zero");
		}
		
		if(this.verificaExistencia(produto)<0){
			throw new Exception("O produto não esta cadastrado");
		}
		this.lista.set(this.verificaExistencia(produto), produto);
	}
	
	//verificar existencia do produto pelo codigo(id)
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
