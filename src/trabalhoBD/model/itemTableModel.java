package trabalhoBD.model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class itemTableModel extends DefaultTableModel {
	private ArrayList<Item> internalList;
	private String[] header = new String[] {"ID", "Preço", "Quantidade", "Código do Pedido","Código do Produto"};
	
	public itemTableModel(ArrayList<Item> newList){
		this.internalList = newList;
	}
	
	public Item getElementAt(int index){
		return internalList.get(index);
	}
	
	public int getSize() {
		return internalList.size();
	}
	
	public int getRouCount(){
		if(internalList == null){
			return 0;
		}
		return internalList.size(); // quantidade de objetos/linhas na tabela
	}
	
	public int getColumnCount(){
		return header.length;
	}
	
	public String getColumnName(int column){
		return header[column];
	}
	
	public Object getValueAt(int row, int column){
		Item it = internalList.get(row);
		if(column == 0){
			return it.getCod();
		}else if(column == 1){
			return it.getPreco();
		}else if(column == 2){
			return it.getQuantidade();
		}else if(column == 3){
			return it.getCod_pedido();
		}else{
			return it.getCod_produto();
		}
	}
	
	public boolean isCellEditable(int arg0, int arg1) {
		
		return false;
	}
	public Item getProdutoAt(int row) {
		
		return internalList.get(row);
	}
}
