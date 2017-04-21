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
import trabalhoBD.model.ClienteTableModel;
import trabalhoBD.model.Produto;
import trabalhoBD.model.ProdutoTableModel;

public class telaProduto extends JFrame {
	private clienteController controller;
	private ArrayList<Produto> newList = new ArrayList<Produto>();
	private ProdutoTableModel model = new ProdutoTableModel(newList);
	
	private JTable table = new JTable(model);
	private JLabel lbCod = new JLabel("Pesquisar (por ID)");
	private JTextField txCod = new JTextField(20);
	private JPanel pnBase = new JPanel();
	private JPanel pnProd = new JPanel();
	private JButton btbuscar = new JButton("Buscar");
	private JButton btList = new JButton("Listar");
	private JButton btNovo = new JButton("Novo");
	private JButton btAlt = new JButton("Alterar");
	private JButton btRemove = new JButton("Remover");
	
	public telaProduto(){ //tentar modificar depois
		this.controller = controller;
	}
	
	public void init(){
		configurePnPro();
		centralizeFrame(); 
		GridBagLayout layoutData = new GridBagLayout();
		pnBase.setLayout(layoutData);
		
		GBC gbc10 = new GBC(1,1);
		pnBase.add(pnProd,gbc10);
		
		super.setTitle("Tela Produtos");
		super.setSize(200, 300);
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
		super.setLocationRelativeTo(null);
		//super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void configurePnPro(){
		
		JScrollPane scroll = new JScrollPane(table);
		GridBagLayout layoutData = new GridBagLayout();
		pnProd.setLayout(layoutData);
		
		GBC gbc1 = new GBC(1,1).setSpan(1, 1);
		GBC gbc2 = new GBC(2,1).setSpan(3, 1);
		GBC gbc8 = new GBC(5,1).setSpan(1, 1);
		GBC gbc3 = new GBC(1,8).setSpan(1, 1);//botoes
		GBC gbc4 = new GBC(2,8).setSpan(1, 1);
		GBC gbc5 = new GBC(3,8).setSpan(1, 1);
		GBC gbc6 = new GBC(4,8).setSpan(1, 1);//fim botoes
		GBC gbc7 = new GBC(1,3).setSpan(6, 3);
		pnProd.add(lbCod, gbc1);
		pnProd.add(txCod, gbc2);
		pnProd.add(btList, gbc3);
		pnProd.add(btNovo, gbc4);
		pnProd.add(btAlt, gbc5);
		pnProd.add(btRemove, gbc6);
		pnProd.add(scroll, gbc7);
		pnProd.add(btbuscar,gbc8);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Produtos");
		pnProd.setBorder(border);
		//configurePnBot();
		centralizeFrame(); 
		
		super.setSize(200, 300);
		super.setContentPane(pnProd);
		super.setVisible(true);
		super.pack();
		//super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void showProduto(Produto prod) {
		//converte de int para String
		txCod.setText(Integer.toString(prod.getCod())); 
		txCod.setText(Integer.toString(prod.getSaldo()));
    }
	
	public void centralizeFrame(){
		int x, y;
		
		Rectangle scr = this.getGraphicsConfiguration().getBounds();
		Rectangle form = this.getBounds();
		x = (int) (scr.getWidth() - form.getWidth()) / 2;
		y = (int) (scr.getHeight() - form.getHeight())/2;
		this.setLocation(x,y);
	}
}
