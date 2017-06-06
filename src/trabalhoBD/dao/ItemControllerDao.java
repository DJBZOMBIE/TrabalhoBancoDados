package trabalhoBD.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import trabalhoBD.model.Item;
import trabalhoBD.model.Pedido;


public class ItemControllerDao {
	private ArrayList<Item> lista;
	private Conexao conectar;
	
	public ItemControllerDao(){
		this.lista = new ArrayList<Item>();
		this.conectar = new Conexao();
	}
	
	public void remover(Item item)throws Exception{
		if(item == null){
			throw new Exception("O Item não foi instanciado");
		}
		
		if(item.getCod()<=0){
			throw new Exception("O id não pode ser negativo");
		}
		
		//abrindo conexao
				Statement conex = conectar.conectar();
				
				//instrução sql correspondente a remoção do cliente
				String sql = "DELETE FROM item where cod = '" + item.getCod() + "'";
				
				try{
					//executando a intrução sql
					conex.execute(sql);
				}catch(SQLException e){
					throw new Exception("Erro ao executar remoção: "+e.getMessage());
				}
				
				
				conectar.desconectar();
		
				//error
				if(this.verificarExistencia(item)== -1){
					throw new Exception("Este item não esta mais cadastrado");
				}
		
		this.lista.remove(this.verificarExistencia(item));
		
	}
	
	
	public int verificarExistencia(Item item){  //se der algum erro mudar esse metodo
		int retorno = -1;
		for(Item ped: lista){
			if(item.getCod() == ped.getCod()){
				retorno = ped.getCod();
				break;
			}
		}
		return retorno;
	}
	
}
