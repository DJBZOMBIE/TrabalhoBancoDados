package trabalhoBD.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class funcionarioTableModel extends DefaultTableModel {
	private ArrayList<Funcionario> internalList;
	private String [] header = new String [] {"cod", "Nome", "CPF", "Cargo"};
	
	public funcionarioTableModel(ArrayList<Funcionario> newlist){
		this.internalList = newlist;
	}
	
	public Funcionario getElementAt(int index){
		return internalList.get(index);
	}
	
	public int getSize(){
		return internalList.size();
	}
	
	public int getRouCount(){
		if(internalList == null){
			return 0;
		}
		return internalList.size();
	}
	
	public int getColumenCount(){
		return header.length;
	}
	
	public String getColumnName(int column){
		return header[column];
	}
	
	public boolean isCellEditable(int arg0, int arg1){
		return false;
	}
	
	public Funcionario getFuncionarioAt(int row){
		return internalList.get(row);
	}
}
