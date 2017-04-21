package trabalhoBD.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import trabalhoBD.controller.clienteController;
import trabalhoBD.model.Cliente;
import trabalhoBD.model.Item;
import trabalhoBD.model.Pedido;
import trabalhoBD.model.PedidoTableModel;
import trabalhoBD.model.itemTableModel;

public class telaCadastroPedido extends JFrame{
	private clienteController controller;
	private ArrayList<Pedido> newList = new ArrayList<Pedido>();
	private ArrayList<Item> newList2 = new ArrayList<Item>();
	private ArrayList<Cliente> newListCli = new ArrayList<Cliente>();
	
	/*private PedidoTableModel model = new PedidoTableModel(newList);
	
	private itemTableModel model2 = new itemTableModel(newList2);
	
	private JTable table2 = new JTable(model2); /*table de itens*/
	private JLabel lbCod = new JLabel("Número:");
	private JLabel lbNome = new JLabel("Data:");
	private JLabel CodCLI = new JLabel("Código do Cliente:");
	private JLabel lbCodItem = new JLabel("Código do Item:");
	
	private JTextField txCod = new JTextField(10);
	private JTextField txNome = new JTextField(20);
	private JTextField txCodCLI = new JTextField(10);
	private JTextField txCodItem = new JTextField(20);
	
	private JLabel lbPreco = new JLabel("Preço:");
	private JLabel lbQuantidade = new JLabel("Quantidade:");
	private JLabel CodCodPedido = new JLabel("Código do Pedido:");
	private JLabel lbCodProd = new JLabel("Código do Produto:");
	
	private JTextField txPreco = new JTextField(10);
	private JTextField txQuantidade = new JTextField(20);
	private JTextField txCodPedido = new JTextField(10);
	private JTextField txCodProd = new JTextField(20);
	
	private JButton btSalvar = new JButton("Salvar");
	private JButton btCancelar = new JButton("Cancelar");
	
	
	private JPanel pnMain = new JPanel();
	private JPanel pnItem = new JPanel();
	private JPanel pnBase = new JPanel();
	private JPanel pnBot = new JPanel();
	
	
	public telaCadastroPedido(){
		
		
		
	}
	
	
	public void init(){
		
		configurePnBase();
		configurePnItem();
		configurePnBotao(); 
		
		GridBagLayout layoutData = new GridBagLayout();
		pnMain.setLayout(layoutData);
		
		GBC gbc10 = new GBC(2,2);
		GBC gbc11 = new GBC(2,10);
		GBC gbc12 = new GBC(2,12);
		
		pnMain.add(pnBase,gbc10);
		pnMain.add(pnItem,gbc11);
		pnMain.add(pnBot,gbc12);
		
		super.setContentPane(pnMain);
		super.setTitle("Cadastro de Pedido");
		super.setVisible(true);
		//super.setPreferredSize(new Dimension(420,250));
		super.setLocationRelativeTo(null);
		super.pack();
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void configurePnBase(){
		
		GridBagLayout layoutData3 = new GridBagLayout();
		pnBase.setLayout(layoutData3);
		
		GBC gbc1 = new GBC(1,1).setSpan(1, 2);
		GBC gbc2 = new GBC(2,1).setSpan(1, 2);
		GBC gbc3 = new GBC(3,1).setSpan(1, 2);
		GBC gbc4 = new GBC(4,1).setSpan(1, 2);
		
		GBC gbc5 = new GBC(1,4).setSpan(1, 2);
		GBC gbc6 = new GBC(2,4).setSpan(1, 2);
		GBC gbc7 = new GBC(3,4).setSpan(1, 2);
		GBC gbc8 = new GBC(4,4).setSpan(1, 2);
		
		pnBase.add(lbCod,gbc1);
		pnBase.add(txCod,gbc2);
		pnBase.add(lbNome,gbc3);
		pnBase.add(txNome,gbc4);
		pnBase.add(CodCLI,gbc5);
		pnBase.add(txCodCLI,gbc6);
		pnBase.add(lbCodProd,gbc7);
		pnBase.add(txCodItem,gbc8);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Cadastro de Pedidos");
		pnBase.setBorder(border);
		
		super.setSize(400, 300);
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
	}

	public void configurePnItem(){
		
		GridBagLayout layoutData4 = new GridBagLayout();
		pnItem.setLayout(layoutData4);
		
		GBC gbc1 = new GBC(1,5).setSpan(1, 2);
		GBC gbc2 = new GBC(2,5).setSpan(1, 2);
		GBC gbc3 = new GBC(3,5).setSpan(1, 2);
		GBC gbc4 = new GBC(4,5).setSpan(1, 2);
		
		GBC gbc5 = new GBC(1,7).setSpan(1, 2);
		GBC gbc6 = new GBC(2,7).setSpan(1, 2);
		GBC gbc7 = new GBC(3,7).setSpan(1, 2);
		GBC gbc8 = new GBC(4,7).setSpan(1, 2);
		
		pnItem.add(lbPreco,gbc1);
		pnItem.add(txPreco,gbc2);
		pnItem.add(lbQuantidade,gbc3);
		pnItem.add(txQuantidade,gbc4);
		pnItem.add(CodCodPedido,gbc5);
		pnItem.add(txCodPedido,gbc6);
		pnItem.add(lbCodItem,gbc7);
		pnItem.add(txCodProd,gbc8);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Itens do Produto");
		pnItem.setBorder(border);
		
		super.setSize(400, 300);
		super.setContentPane(pnItem);
		super.setVisible(true);
		super.pack();
	}
	
	public void configurePnBotao(){
		GridBagLayout layoutData2 = new GridBagLayout();
		pnBot.setLayout(layoutData2);
		
		GBC gbc9 = new GBC(3,12).setSpan(1, 1);
		GBC gbc10 = new GBC(4,12).setSpan(1, 1);
		
		pnBot.add(btSalvar,gbc9);
		pnBot.add(btCancelar,gbc10);
		
		super.setContentPane(pnBot);
		super.setVisible(true);
		super.pack();
	}
	
}
