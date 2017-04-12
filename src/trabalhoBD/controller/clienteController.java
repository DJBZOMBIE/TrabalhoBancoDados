package trabalhoBD.controller;

import java.util.ArrayList;

import trabalhoBD.model.Cliente;

public class clienteController {
	private ArrayList<Cliente> lista;
	
	public clienteController(){
		this.lista = new ArrayList<Cliente>();
	}
	
	public ArrayList <Cliente> listarTodos(){
		return this.lista;	
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
		
		
		if(this.verificaExistencia(cliente)== -1){
			throw new Exception("Este cliente não esta cadastrado");
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
		
		if(this.verificaExistencia(cliente)== -1){
			throw new Exception("Este cliente não esta cadastrado");
		}
		this.lista.set(this.verificaExistencia(cliente), cliente);
	}
	
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
	}
}
