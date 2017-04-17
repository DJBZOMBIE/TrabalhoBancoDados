package trabalhoBD.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import trabalhoBD.controller.clienteController;
import trabalhoBD.model.Cliente;
import trabalhoBD.model.ClienteTableModel;

public class telaCliente extends JFrame{
	private clienteController controller;
	private JPanel pnBase = new JPanel();
	private JPanel pnBot = new JPanel();
	private JPanel pnTab = new JPanel();
	
	private JButton btList = new JButton("Listar");
	private JButton btNovo = new JButton("Novo");
	private JButton btAlt = new JButton("Alterar");
	private JButton btRemove = new JButton("Remover");
	
	
	public telaCliente(){
		this.controller = controller;
	}
	
	public void init(){
		pnBase.setLayout(new BorderLayout());
		pnBase.add(pnTab, BorderLayout.SOUTH);
		pnBase.add(pnBot, BorderLayout.SOUTH);
		
		
		configurePnTable();
		
		
		super.setContentPane(pnBase);
		super.pack();
		super.setTitle("Cadastro Cliente");
		super.setSize(new Dimension(500, 300));
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //quando clicar em fechar não irá fechar o form principal
	}
	public void configurePnTable(){
		
		ArrayList<Cliente> newList = new ArrayList<Cliente>();
		
		//newList.add(new Cliente(1, "teste", "123.321.456.01", "teste@gmail.com"));
		ClienteTableModel model = new ClienteTableModel(newList);
		
		JTable table = new JTable(model);
		
		JScrollPane scroll = new JScrollPane(table);
		pnBase.add(scroll);
	}
	
}
