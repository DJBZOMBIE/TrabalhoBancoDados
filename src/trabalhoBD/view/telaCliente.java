package trabalhoBD.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
		pnBase.add(pnTab, BorderLayout.CENTER);
		pnBase.add(pnBot, BorderLayout.SOUTH);
		
		
		configurePnTable();
		configurePnBot();
		
		super.setContentPane(pnBase);
		super.pack();
		super.setTitle("Tela Cliente");
		super.setSize(new Dimension(600, 500));
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //quando clicar em fechar não irá fechar o form principal
	}
	
	public void configurePnBot(){
		
		pnBase.setLayout(new GridBagLayout());
		
		GridBagConstraints restricoes = new GridBagConstraints();
		restricoes.gridx = 1;
		restricoes.gridy = 0;
		restricoes.gridwidth = 1;
		restricoes.gridheight = 2;
		pnBot.add(btList, restricoes);
		
		restricoes.gridx = 2; //coluna
		restricoes.gridy = 0; //linha
		restricoes.gridwidth = 1;
		restricoes.gridheight = 2;
		
		pnBot.add(btNovo, restricoes);
		
		restricoes.gridx = 3; //coluna
		restricoes.gridy = 0; //linha
		restricoes.gridwidth = 1;
		restricoes.gridheight = 2;
		
		pnBot.add(btAlt, restricoes);
		
		restricoes.gridx = 4; //coluna
		restricoes.gridy = 0; //linha
		restricoes.gridwidth = 1;
		restricoes.gridheight = 2;
		
		pnBot.add(btRemove, restricoes);
		
	}
	public void configurePnTable(){
		
		ArrayList<Cliente> newList = new ArrayList<Cliente>();
		
		//newList.add(new Cliente(1, "teste", "123.321.456.01", "teste@gmail.com"));
		ClienteTableModel model = new ClienteTableModel(newList);
		
		JTable table = new JTable(model);
		
		JScrollPane scroll = new JScrollPane(table);
		pnBase.add(scroll);
		
		super.setContentPane(pnTab);
		super.pack();
		super.setTitle("Tela Cliente");
		super.setSize(new Dimension(400, 200));
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}
