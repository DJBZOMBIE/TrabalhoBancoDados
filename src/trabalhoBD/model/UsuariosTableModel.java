package trabalhoBD.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class UsuariosTableModel extends DefaultTableModel{
	private ArrayList<Usuarios> internalList;
	private String[] header = new String[] {"Cod", "Nome", "Senha", "Tipo"};
	
	public UsuariosTableModel(ArrayList<Usuarios> newList){
		this.internalList = newList;
	}
	
	public Usuarios getElementAt(int index){
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
	
	
	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		
		return false;
	}
	public Usuarios getUsuariosAt(int row) {
		
		return internalList.get(row);
	}
}
