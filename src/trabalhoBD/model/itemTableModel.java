package trabalhoBD.model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class itemTableModel extends DefaultTableModel {
	private ArrayList<Item> internalList;
	private String[] header = new String[] {"cod_pedido", "cod_produto", "quantidade", "cod"};
	
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
	
	
	
	public boolean isCellEditable(int arg0, int arg1) {
		
		return false;
	}
	public Item getProdutoAt(int row) {
		
		return internalList.get(row);
	}
}
