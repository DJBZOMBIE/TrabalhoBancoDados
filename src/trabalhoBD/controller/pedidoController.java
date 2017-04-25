package trabalhoBD.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import trabalhoBD.dao.Conexao;
import trabalhoBD.model.Cliente;
import trabalhoBD.model.Item;
import trabalhoBD.model.Pedido;

public class pedidoController {
	private ArrayList<Item> itens;
	private ArrayList<Pedido> lista;
	private Conexao conectar;
	
	public pedidoController(){
		this.lista = new ArrayList<Pedido>();
		this.itens = new ArrayList<Item>();	
		this.conectar = new Conexao();
	}
	
	public ArrayList<Pedido> listarTodos()throws Exception{
		//abrindo conexao
				Statement conex = conectar.conectar();
				ArrayList<Pedido> retorno = new ArrayList<Pedido>();
				
				String sql = "SELECT cod, data, cod_cliente FROM pedido ORDER BY data";
				try{
					ResultSet rs = conex.executeQuery(sql);
					while(rs.next()){
						Pedido pedido = new Pedido();
						pedido.setCod(rs.getInt("cod"));
						pedido.setData(rs.getDate("data"));
						pedido.setCod_cliente(rs.getInt("cod_cliente"));
				
						retorno.add(pedido);
					}
				}catch(SQLException e){
					throw new Exception("Erro ao executar consulta: " + e.getMessage());
				}
				conectar.desconectar();
				
				return retorno;	
	}
	
	
	
	
	public void inserir(Pedido pedido)throws Exception{
		if(pedido == null){
			throw new Exception("O pedido não foi instanciado");
		}
		if(pedido.getCod()<=0){
			throw new Exception("O ID não pode ser negativo");
		}
		if(pedido.getData()==null){
			throw new Exception("Informar a data do pedido");
		}
		if(pedido.getData().equals("")){
			throw new Exception("Informar a data do pedido");
		}
		if(pedido.getCod_item()==null){
			throw new Exception("Informar pelo menos um item para o pedido");
		}
		if(pedido.getCod_cliente()<=0){
			throw new Exception("O ID não pode ser negativo");
		}
		
		
		
		
		if(this.verificarExistencia(pedido)>=0){
			throw new Exception("O pedido já foi cadastrado");
		}
		this.lista.add(pedido);
	}
	
	
	public void remover(Pedido pedido)throws Exception{
		if(pedido == null){
			throw new Exception("O pedido não foi instanciado");
		}
		
		if(pedido.getCod()<=0){
			throw new Exception("O id não pode ser negativo");
		}
		
		
		//abrindo conexao
				Statement conex = conectar.conectar();
				
				//instrução sql correspondente a remoção do cliente
				String sql = "DELETE FROM pedido where cod = '" + pedido.getCod() + "'";
				
				try{
					//executando a intrução sql
					conex.execute(sql);
				}catch(SQLException e){
					throw new Exception("Erro ao executar remoção: "+e.getMessage());
				}
				
				
				conectar.desconectar();
		
				//error
				if(this.verificarExistencia(pedido)== -1){
					throw new Exception("Este pedido não esta mais cadastrado");
				}
		
		this.lista.remove(this.verificarExistencia(pedido));
		
	}
	
	
	public int verificarExistencia(Pedido pedido){  //se der algum erro mudar esse metodo
		int retorno = -1;
		for(Pedido ped: lista){
			if(pedido.getCod() == ped.getCod()){
				retorno = ped.getCod();
				break;
			}
		}
		return retorno;
	}
	
	
	
	
}
