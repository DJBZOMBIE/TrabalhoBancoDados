package trabalhoBD.controller;

import java.util.ArrayList;

import trabalhoBD.model.Item;
import trabalhoBD.model.Pedido;

public class pedidoController {
	private ArrayList<Item> itens;
	private ArrayList<Pedido> lista;
	
	public pedidoController(){
		this.lista = new ArrayList<Pedido>();
		this.itens = new ArrayList<Item>();
	}
	
	public ArrayList<Pedido> listarTodos(){
		return this.lista;	
	}
	
	public void inserir(Pedido pedido)throws Exception{
		if(pedido == null){
			throw new Exception("A pedido não foi instanciado");
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
		if(pedido.getItem().size()<=0){
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
		
	}
	public void atualizar(Pedido pedido)throws Exception{
		
	}
	
	public int verificarExistencia(Pedido pedido){  //se der algum erro mudar esse metodo
		
	}
	
	//calcular o valor total do pedido
	public float getValorTotal(){
		
		float retorno = 0;
		for(Item it: itens){
			float valor = (it.getQuantidade() * it.getPreco());
			retorno = retorno + valor;
		}
		return retorno;
	}
	
	
}
