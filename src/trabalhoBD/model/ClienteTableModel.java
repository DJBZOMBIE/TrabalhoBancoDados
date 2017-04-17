package trabalhoBD.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class ClienteTableModel extends DefaultTableModel{
	private ArrayList<Cliente> internalList;
	private String[] header = new String[]{"ID", "Nome", "cpf", "email"};
	
	public ClienteTableModel(ArrayList<Cliente> newList){
		this.internalList = newList;
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
		Cliente cli = internalList.get(row);
		if(column == 0){
			return cli.getCod();
		}else if(column == 1){
			return cli.getNome();
		}else if(column == 2){
			return cli.getCpf();
		}else{
			return cli.getEmail();
		}
	}
}
