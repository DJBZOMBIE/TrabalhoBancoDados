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

public class telaEntradaEstoque extends JFrame {
	private produtoController controller;
	private ArrayList<Produto> newList = new ArrayList<Produto>();
	
	private JLabel lbCod = new JLabel("C�digo do Produto:");
	private JLabel lbQuantidade = new JLabel("Quantidade");
	
	private JTextField txCod = new JTextField(10);
	private JTextField txQuantidade = new JTextField(20);
	
	private JPanel pnBase = new JPanel();
	private JPanel pnBot = new JPanel();
	private JPanel pnMain = new JPanel();
	
	private JButton btSalvar = new JButton("Enviar");
	private JButton btCancelar = new JButton("Cancelar");
	
	
	public telaEntradaEstoque(){
		this.controller = controller;
	}
	
	public void init(){
		
		configurePnBase();
		configurePnBotao();
		
		
		GridBagLayout layoutData = new GridBagLayout();
		pnMain.setLayout(layoutData);
		
		GBC gbc10 = new GBC(2,2);
		GBC gbc11 = new GBC(2,6);
		pnMain.add(pnBase,gbc10);
		pnMain.add(pnBot,gbc11);
		
		super.setTitle("Estoque");
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
		GBC gbc2 = new GBC(2,1).setSpan(1, 3);
		GBC gbc3 = new GBC(1,4).setSpan(1, 3);
		GBC gbc4 = new GBC(2,4).setSpan(1, 3);
		
		pnBase.add(lbCod,gbc1);
		pnBase.add(txCod,gbc2);
		pnBase.add(lbQuantidade,gbc3);
		pnBase.add(txQuantidade,gbc4);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Entrada de Estoque");
		pnBase.setBorder(border);
		
		super.setSize(400, 300);
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
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
