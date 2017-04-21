package trabalhoBD.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import trabalhoBD.controller.produtoController;
import trabalhoBD.model.Produto;

public class telaAlterarProduto extends JFrame{
	private produtoController controller;
	private ArrayList<Produto> newList = new ArrayList<Produto>();
	
	private JLabel lbCod = new JLabel("Código:");
	private JLabel lbNome = new JLabel("Nome:");
	private JLabel lbSaldo = new JLabel("Saldo:");
	private JLabel lbCodBar = new JLabel("Código de Barras:");
	
	private JTextField txCod = new JTextField(10);
	private JTextField txNome = new JTextField(20);
	private JTextField txSaldo= new JTextField(15);
	private JTextField txCodBar= new JTextField(15);
	
	private JPanel pnBase = new JPanel();
	private JPanel pnBot = new JPanel();
	private JPanel pnMain = new JPanel();
	private JButton btSalvar = new JButton("Salvar");
	private JButton btCancelar = new JButton("Cancelar");
	
	public telaAlterarProduto(){
		this.controller = controller;
	}
	
	public void init(){
		configurePnBase();
		configurePnBotao();
		
		
		GridBagLayout layoutData = new GridBagLayout();
		pnMain.setLayout(layoutData);
		
		GBC gbc10 = new GBC(2,2);
		GBC gbc11 = new GBC(2,5);
		pnMain.add(pnBase,gbc10);
		pnMain.add(pnBot,gbc11);
		
		super.setTitle("Alteração de Produto");
		super.setContentPane(pnMain);
		super.setVisible(true);
		super.setPreferredSize(new Dimension(420,250));
		super.setLocationRelativeTo(null);
		super.pack();
	}
	public void configurePnBase(){
		
		GridBagLayout layoutData3 = new GridBagLayout();
		pnBase.setLayout(layoutData3);
		
		GBC gbc1 = new GBC(1,1).setSpan(1, 3);
		GBC gbc2 = new GBC(2,1).setSpan(4, 3);
		GBC gbc3 = new GBC(1,5).setSpan(1, 3);
		GBC gbc4 = new GBC(2,5).setSpan(3, 3);
		GBC gbc5 = new GBC(1,8).setSpan(1, 3);
		GBC gbc6 = new GBC(2,8).setSpan(3, 3);
	
		
		
		pnBase.add(lbNome,gbc1);
		pnBase.add(txNome,gbc2);
		pnBase.add(lbSaldo,gbc3);
		pnBase.add(txSaldo,gbc4);
		pnBase.add(lbCodBar,gbc5);
		pnBase.add(txCodBar,gbc6);
		
		
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Alteração de Produto");
		pnBase.setBorder(border);
		
		//super.setTitle("Novo Cliente");
		super.setSize(400, 300);
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
		//super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void configurePnBotao(){
		GridBagLayout layoutData2 = new GridBagLayout();
		pnBot.setLayout(layoutData2);
		
		GBC gbc9 = new GBC(3,10).setSpan(1, 1);
		GBC gbc10 = new GBC(4,10).setSpan(1, 1);
		
		pnBot.add(btSalvar,gbc9);
		pnBot.add(btCancelar,gbc10);
		
		super.setContentPane(pnBot);
		super.setVisible(true);
		super.pack();
	}
	
}
