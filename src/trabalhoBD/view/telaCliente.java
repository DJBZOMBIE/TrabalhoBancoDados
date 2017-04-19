package trabalhoBD.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import trabalhoBD.controller.clienteController;
import trabalhoBD.model.Cliente;
import trabalhoBD.model.ClienteTableModel;

public class telaCliente extends JFrame{
	private clienteController controller;
	private ArrayList<Cliente> newList = new ArrayList<Cliente>();
	private ClienteTableModel model = new ClienteTableModel(newList);
	private JTable table = new JTable(model);
	private JLabel lbCod = new JLabel("Pesquisar (por CPF)");
	private JTextField txCod = new JTextField(20);
	private JPanel pnBase = new JPanel();
	private JPanel pnTab = new JPanel();
	
	private JButton btbuscar = new JButton("Buscar");
	private JButton btList = new JButton("Listar");
	private JButton btNovo = new JButton("Novo");
	private JButton btAlt = new JButton("Alterar");
	private JButton btRemove = new JButton("Remover");
	//===================


	
	public telaCliente(){
		this.controller = controller;
	}
	
	public void init(){
		configurePnTab();
		centralizeFrame(); 
		
		GridBagLayout layoutData = new GridBagLayout();
		pnBase.setLayout(layoutData);
		
		GBC gbc10 = new GBC(1,1);
		pnBase.add(pnTab,gbc10);
		
		super.setTitle("Tela Cliente");
		super.setSize(200, 300);
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
		//super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //quando clicar em fechar não irá fechar o form principal
	}
	
	public void configurePnTab(){
		
		JScrollPane scroll = new JScrollPane(table);
		GridBagLayout layoutData = new GridBagLayout();
		pnTab.setLayout(layoutData);
		
		GBC gbc1 = new GBC(1,1).setSpan(1, 1);
		GBC gbc2 = new GBC(2,1).setSpan(3, 1);
		GBC gbc8 = new GBC(5,1).setSpan(1, 1);
		GBC gbc3 = new GBC(1,8).setSpan(1, 1);//botoes
		GBC gbc4 = new GBC(2,8).setSpan(1, 1);
		GBC gbc5 = new GBC(3,8).setSpan(1, 1);
		GBC gbc6 = new GBC(4,8).setSpan(1, 1);//fim botoes
		GBC gbc7 = new GBC(1,3).setSpan(6, 3);
		pnTab.add(lbCod, gbc1);
		pnTab.add(txCod, gbc2);
		pnTab.add(btList, gbc3);
		pnTab.add(btNovo, gbc4);
		pnTab.add(btAlt, gbc5);
		pnTab.add(btRemove, gbc6);
		pnTab.add(scroll, gbc7);
		pnTab.add(btbuscar,gbc8);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Clientes");
		pnTab.setBorder(border);
		
		
		
		super.setSize(200, 300);
		super.setContentPane(pnTab);
		super.setVisible(true);
		super.pack();
	}
	
	public void showCliente(Cliente cli) {
		//converte de int para String
		txCod.setText(Integer.toString(cli.getCod())); 

    }
	
	public void centralizeFrame(){
		int x, y;
		
		Rectangle scr = this.getGraphicsConfiguration().getBounds();
		Rectangle form = this.getBounds();
		x = (int) (scr.getWidth() - form.getWidth()) / 2;
		y = (int) (scr.getHeight() - form.getHeight())/2;
		this.setLocation(x,y);
	}
	
	/*public void configurePnBot(){
		
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

*/

	/*public void configurePnTable(){
		
		
		
		newList.add(new Cliente(1, "teste", "123.321.456.01", "teste@gmail.com"));
		
		
		JTable table = new JTable(model);
		
		JScrollPane scroll = new JScrollPane(table);
		pnBase.add(scroll);
		
		super.setContentPane(pnTab);
		super.pack();
		super.setTitle("Tela Cliente");
		super.setSize(new Dimension(400, 200));
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}*/
	
}
