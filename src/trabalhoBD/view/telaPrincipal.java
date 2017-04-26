package trabalhoBD.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;



public class telaPrincipal extends JFrame {
	private telaCliente controller2;
	
	private JPanel pnBase = new JPanel();
	private JPanel pnMain = new JPanel();
	private JButton btCli = new JButton("Clientes");
	private JButton btPro = new JButton("Produtos");
	private JButton btPed = new JButton("Pedidos");
	private JButton btEntrada = new JButton("Entrada de Estoque");
	
	
	public telaPrincipal(){
		
	}
	
	public void init(){
		GridBagLayout layoutData3 = new GridBagLayout();
		pnBase.setLayout(layoutData3);
		GBC gbc1 = new GBC(3,3);
		pnBase.add(pnMain,gbc1);
		
		configurePnBase();
		configureBtCliente();
		configureBtProdutos();
		configureBtPedidos();
		configureBtEntrada();
		
		
		super.setContentPane(pnBase);
		
		super.setTitle("Tela Principal");
		super.setVisible(true);
		super.setPreferredSize(new Dimension(320,250));
		super.pack();
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void configurePnBase(){
		GridBagLayout layoutData3 = new GridBagLayout();
		pnBase.setLayout(layoutData3);
		
		GBC gbc1 = new GBC(3,1).setSpan(3, 1);
		GBC gbc2 = new GBC(3,2).setSpan(3, 1);
		GBC gbc3 = new GBC(3,3).setSpan(3, 1);
		GBC gbc4 = new GBC(3,4).setSpan(3, 1);
		
		pnBase.add(btCli,gbc1);
		pnBase.add(btPro,gbc2);
		pnBase.add(btPed,gbc3);
		pnBase.add(btEntrada,gbc4);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "MENU");
		pnBase.setBorder(border);
		
		//super.setSize(400, 300);
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
	}
	
	//tela cliente
	private void configureBtCliente() {
		ActionListener lstAutenticacao = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButtonClienteActionPerformed(e);
			}
		};
		
		btCli.addActionListener(lstAutenticacao);
	}
	
	public void JButtonClienteActionPerformed(java.awt.event.ActionEvent evt){

		telaCliente telaCli = new telaCliente();
		pnBase.setVisible(false);
		
		telaCli.init();
		pnBase.setVisible(true);
	}
	
	//tela produtos
	private void configureBtProdutos() {
		ActionListener lstAutenticacao = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButtonProdutosActionPerformed(e);
			}
		};
		
		btPro.addActionListener(lstAutenticacao);
	}
	
	public void JButtonProdutosActionPerformed(java.awt.event.ActionEvent evt){

		telaProduto telaPro = new telaProduto();
		pnBase.setVisible(false);
		
		telaPro.init();
		pnBase.setVisible(true);
	}
	
	//tela pedidos
	private void configureBtPedidos(){
		ActionListener lstAutenticacao = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButtonPedidosActionPerformed(e);
			}
		};
		
		btPed.addActionListener(lstAutenticacao);
	}
	
	public void JButtonPedidosActionPerformed(java.awt.event.ActionEvent evt){

		telaPedido telaPed = new telaPedido();
		pnBase.setVisible(false);
		
		telaPed.init();
		pnBase.setVisible(true);
	}
	
	//tela entrada de estoque
	private void configureBtEntrada(){
		ActionListener lstAutenticacao = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButtonEntradaEstoquesActionPerformed(e);
			}
		};
		
		btEntrada.addActionListener(lstAutenticacao);
	}
	
	public void JButtonEntradaEstoquesActionPerformed(java.awt.event.ActionEvent evt){
		telaEntradaEstoque telaEnt = new telaEntradaEstoque();
		
		pnBase.setVisible(false);
		
		telaEnt.init();
		pnBase.setVisible(true);
	}
	
	public void sair(){
		telaEntradaEstoque telaEnt = new telaEntradaEstoque();
		telaEnt.setVisible(false);
		init();
	}
}
