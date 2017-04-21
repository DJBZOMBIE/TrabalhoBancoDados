package trabalhoBD.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;

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
	

}
