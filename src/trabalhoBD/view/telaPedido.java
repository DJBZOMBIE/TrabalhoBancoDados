package trabalhoBD.view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import trabalhoBD.controller.clienteController;
import trabalhoBD.model.Cliente;
import trabalhoBD.model.Item;
import trabalhoBD.model.Pedido;
import trabalhoBD.model.PedidoTableModel;
import trabalhoBD.model.Produto;
import trabalhoBD.model.ProdutoTableModel;
import trabalhoBD.model.itemTableModel;

public class telaPedido extends JFrame{
	
	private clienteController controller;
	private ArrayList<Pedido> newList = new ArrayList<Pedido>();
	private ArrayList<Item> newList2 = new ArrayList<Item>();
	private ArrayList<Cliente> newListCli = new ArrayList<Cliente>();
	
	private PedidoTableModel model = new PedidoTableModel(newList);
	
	private itemTableModel model2 = new itemTableModel(newList2);
	
	private JTable table = new JTable(model);
	private JTable table2 = new JTable(model2);
	//private JLabel lbCod = new JLabel("Pesquisar (por ID)");
	//private JTextField txCod = new JTextField(20);
	private JPanel pnBase = new JPanel();
	private JPanel pnTab = new JPanel();
	private JPanel pnTab2 = new JPanel();
	private JButton btbuscar = new JButton("Buscar");
	private JButton btList = new JButton("Listar");
	private JButton btNovo = new JButton("Novo");
	private JButton btRemove = new JButton("Remover");
	
	public telaPedido(){
		this.controller = controller;
	}
	
	public void init(){
		
		congifurepnTab();
		congifurepnTab2();
		centralizeFrame(); 
		GridBagLayout layoutData = new GridBagLayout();
		pnBase.setLayout(layoutData);
		
		GBC gbc10 = new GBC(1,1);
		GBC gbc11 = new GBC(1,7);
		pnBase.add(pnTab,gbc11);
		pnBase.add(pnTab2,gbc10);
		
		super.setTitle("Tela Pedidos");
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
		super.setLocationRelativeTo(null);
		//super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void congifurepnTab2(){
		JScrollPane scroll = new JScrollPane(table);
		GridBagLayout layoutData = new GridBagLayout();
		pnTab2.setLayout(layoutData);
		GBC gbc1 = new GBC(1,1).setSpan(1, 1);
		GBC gbc2 = new GBC(2,1).setSpan(3, 1);
		GBC gbc8 = new GBC(5,1).setSpan(1, 1);
		GBC gbc3 = new GBC(2,6).setSpan(1, 1);//botoes
		GBC gbc4 = new GBC(3,6).setSpan(1, 1);
		GBC gbc6 = new GBC(4,6).setSpan(1, 1);//fim botoes
		GBC gbc7 = new GBC(1,3).setSpan(6, 3);
		
		//GBC gbc10 = new GBC(2,7);
		
		//pnTab2.add(pnTab,gbc10);
		//pnTab2.add(lbCod, gbc1);
		//pnTab2.add(txCod, gbc2);
		pnTab2.add(btList, gbc3);
		pnTab2.add(btNovo, gbc4);
		pnTab2.add(btRemove, gbc6);
		pnTab2.add(scroll, gbc7);
		//pnTab2.add(btbuscar,gbc8);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Pedidos");
		pnTab2.setBorder(border);
		//configurePnBot();
		
		
		
		
		super.setContentPane(pnTab2);
		super.setVisible(true);
		super.pack();
		//super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void congifurepnTab(){
		JScrollPane scroll2 = new JScrollPane(table2);
		GridBagLayout layoutData2 = new GridBagLayout();
		pnTab.setLayout(layoutData2);
		GBC gbc9 = new GBC(1,8).setSpan(6, 3);
		pnTab.add(scroll2,gbc9);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Itens do pedido");
		pnTab.setBorder(border);
		
		
		//super.setTitle("Tela Cliente");
		super.setSize(300, 400);
		super.setContentPane(pnTab);
		super.setVisible(true);
		super.pack();
		//super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	/*public void showProduto(Produto prod) { //editar depois
		//converte de int para String
		txCod.setText(Integer.toString(prod.getCod())); 
		txCod.setText(Integer.toString(prod.getSaldo()));
    }*/
	
	public void centralizeFrame(){
		int x, y;
		
		Rectangle scr = this.getGraphicsConfiguration().getBounds();
		Rectangle form = this.getBounds();
		x = (int) (scr.getWidth() - form.getWidth()) / 2;
		y = (int) (scr.getHeight() - form.getHeight())/2;
		this.setLocation(x,y);
	}
		
}
