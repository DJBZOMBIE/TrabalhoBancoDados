package trabalhoBD.controller;

import java.util.ArrayList;

import trabalhoBD.model.Produto;

public class produtoController {
	
	private ArrayList<Produto> lista; //armazenar todos os produtos cadastrados
	
	public produtoController(){
		this.lista = new ArrayList<Produto>();
	}
	
	public ArrayList<Produto> listarTodos(){
		return this.lista;
		
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
