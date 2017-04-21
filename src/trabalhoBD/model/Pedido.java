package trabalhoBD.model;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
	
	private int cod;
	private Date data;
	private int cod_cliente;
	private int cod_item;
	
	public Pedido(int code, Date data, int cod_cliente, int cod_item){
		this.cod = code;
		this.data = data;
		this.cod_cliente = cod_cliente;
		this.cod_item = cod_item;
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

	public int getCod_Item() {
		return cod_item;
	}

	public void setCod_Item(int cod_item) {
		this.cod_item = cod_item;
	}

	
}
