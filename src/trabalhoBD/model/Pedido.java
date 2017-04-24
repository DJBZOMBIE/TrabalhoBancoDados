package trabalhoBD.model;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
	
	private int cod;
	private Date data;
	private int cod_cliente;
	private ArrayList<Item> cod_item;
	
	public Pedido(){
		this.cod_item = new ArrayList<Item>();
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	public int getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public ArrayList<Item> getCod_item() {
		return cod_item;
	}

	public void setCod_item(ArrayList<Item> cod_item) {
		this.cod_item = cod_item;
	}



	
}
