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
			throw new Exception("O Item n�o foi instanciado");
		}
		
		if(item.getCod()<=0){
			throw new Exception("O id n�o pode ser negativo");
		}
		
		//abrindo conexao
				Statement conex = conectar.conectar();
				
				//instru��o sql correspondente a remo��o do cliente
				String sql = "DELETE FROM item where cod = '" + item.getCod() + "'";
				
				try{
					//executando a intru��o sql
					conex.execute(sql);
				}catch(SQLException e){
					throw new Exception("Erro ao executar remo��o: "+e.getMessage());
				}
				
				
				conectar.desconectar();
		
				//error
				if(this.verificarExistencia(item)== -1){
					throw new Exception("Este item n�o esta mais cadastrado");
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
