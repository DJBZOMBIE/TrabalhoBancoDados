package trabalhoBD.view;

import java.awt.BorderLayout;
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
	
	public telaPrincipal(){
		
	}
	
	public void init(){
		
		configurePnBase();
		centralizeFrame();
		
		pnBase.setLayout(new BorderLayout());
		pnBase.add(pnMain,BorderLayout.CENTER);
		super.setContentPane(pnBase);
		super.pack();
		super.setTitle("Tela Principal");
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(406, 238);
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
	}
	
	//centralizar a tela no desktop
	public void centralizeFrame(){
		int x, y;
		
		Rectangle scr = this.getGraphicsConfiguration().getBounds();
		Rectangle form = this.getBounds();
		x = (int) (scr.getWidth() - form.getWidth()) / 2;
		y = (int) (scr.getHeight() - form.getHeight())/2;
		this.setLocation(x,y);
	}
}
