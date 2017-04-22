package trabalhoBD.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class telaPrincipal extends JFrame {
	
	
	private JPanel pnBase = new JPanel();
	private JPanel pnMain = new JPanel();
	private JButton btCli = new JButton("Clientes");
	private JButton btPro = new JButton("Produtos");
	private JButton btPed = new JButton("Pedidos");
	private JButton btEntrada = new JButton("Entrada de Estoque");
	
	
	public telaPrincipal(){
		
	}
	
	public void init(){
		
		configurePnBase();
		configureBtCliente();
		configureBtProdutos();
		configureBtPedidos();
		configureBtEntrada();
		
		/*DEIXAR MELHOR SAPORRA DEPOIS*/
		pnBase.setLayout(new BorderLayout());
		pnBase.add(pnMain,BorderLayout.SOUTH);
		super.setContentPane(pnBase);
		super.pack();
		super.setTitle("Tela Principal");
		super.setVisible(true);
		super.setPreferredSize(new Dimension(420,250));
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void configurePnBase(){
		pnBase.setLayout(new GridBagLayout());
		
		GridBagConstraints restricoes = new GridBagConstraints();
		restricoes.gridx = 1;
		restricoes.gridy = 1;
		restricoes.gridwidth = 1;
		restricoes.gridheight = 2;
		pnMain.add(btCli, restricoes);
		
		restricoes.gridx = 2; //coluna
		restricoes.gridy = 0; //linha
		restricoes.gridwidth = 1;
		restricoes.gridheight = 2;
		
		pnMain.add(btPro, restricoes);
		
		restricoes.gridx = 3; //coluna
		restricoes.gridy = 0; //linha
		restricoes.gridwidth = 1;
		restricoes.gridheight = 2;
		
		pnMain.add(btPed, restricoes);
		
		restricoes.gridx = 4; //coluna
		restricoes.gridy = 0; //linha
		restricoes.gridwidth = 1;
		restricoes.gridheight = 2;
		
		pnMain.add(btEntrada, restricoes);
		
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
