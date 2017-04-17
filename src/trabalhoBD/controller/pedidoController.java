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
			throw new Exception("O pedido n�o foi instanciado");
		}
		if(pedido.getCod()<=0){
			throw new Exception("O ID n�o pode ser negativo");
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
			throw new Exception("O ID n�o pode ser negativo");
		}
		
		if(this.verificarExistencia(pedido)>=0){
			throw new Exception("O pedido j� foi cadastrado");
		}
		this.lista.add(pedido);
	}
	public void remover(Pedido pedido)throws Exception{
		if(pedido == null){
			throw new Exception("O pedido n�o foi instanciado");
		}
		
		if(pedido.getCod()<=0){
			throw new Exception("O id n�o pode ser negativo");
		}
		
		if(this.verificarExistencia(pedido)<0){
			throw new Exception("este pedido n�o esta cadastrado ");
		}
		this.lista.remove(this.verificarExistencia(pedido));
		
	}
	public void atualizar(Pedido pedido)throws Exception{
		if(pedido == null){
			throw new Exception("O pedido n�o foi instanciado");
		}
		if(pedido.getCod()<=0){
			throw new Exception("O ID n�o pode ser negativo");
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
			throw new Exception("O ID n�o pode ser negativo");
		}
		
		if(this.verificarExistencia(pedido)>=0){
			throw new Exception("O pedido j� foi cadastrado");
		}
		this.lista.set(this.verificarExistencia(pedido),pedido);
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
