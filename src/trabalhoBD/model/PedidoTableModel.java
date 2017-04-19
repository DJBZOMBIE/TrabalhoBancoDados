package trabalhoBD.model;

import java.util.ArrayList;


import javax.swing.table.DefaultTableModel;

public class PedidoTableModel extends DefaultTableModel {
	private ArrayList<Pedido> internalList;
	private String[] header = new String[] {"ID", "Data", "Código do Cliente", "Total"};
	
	public PedidoTableModel(ArrayList<Pedido> newList){
		this.internalList = newList;
	}
	
	public Pedido getElementAt(int index){
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
		Pedido ped= internalList.get(row);
		if(column == 0){
			return ped.getCod();
		}else if(column == 1){
			return ped.getData();
		}else if(column == 2){
			return ped.getCod_cliente();
		}else{
			return ped.getItem();
		}
	}
	
	public boolean isCellEditable(int arg0, int arg1) {
		
		return false;
	}
	public Pedido getProdutoAt(int row) {
		
		return internalList.get(row);
	}
}
