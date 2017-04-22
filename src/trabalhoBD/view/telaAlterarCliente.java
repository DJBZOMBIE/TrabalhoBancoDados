package trabalhoBD.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import trabalhoBD.controller.clienteController;
import trabalhoBD.model.Cliente;

public class telaAlterarCliente extends JFrame{
	
	private clienteController controller;
	private ArrayList<Cliente> newList = new ArrayList<Cliente>();
	
	private JLabel lbCod = new JLabel("Código:");
	private JLabel lbNome = new JLabel("Nome:");
	private JLabel lbCpf = new JLabel("CPF:");
	private JLabel lbEmail = new JLabel("E-Mail:");
	
	private JTextField txCod = new JTextField(10);
	private JTextField txNome = new JTextField(20);
	private JTextField txCpf= new JTextField(14);
	private JTextField txEmail= new JTextField(20);
	private JPanel pnBase = new JPanel();
	private JPanel pnBot = new JPanel();
	private JPanel pnMain = new JPanel();
	private JButton btSalvar = new JButton("Salvar");
	private JButton btCancelar = new JButton("Cancelar");
	
	public telaAlterarCliente(){
		this.controller = controller;
	}
	
	public void init(){
		configurePnBase();
		configurePnBotao();
		
		configureBtCancelar();
		
		GridBagLayout layoutData = new GridBagLayout();
		pnMain.setLayout(layoutData);
		
		GBC gbc10 = new GBC(2,2);
		GBC gbc11 = new GBC(2,5);
		pnMain.add(pnBase,gbc10);
		pnMain.add(pnBot,gbc11);
		
		super.setTitle("Alteração de Cliente");
		super.setContentPane(pnMain);
		super.setVisible(true);
		super.setPreferredSize(new Dimension(420,250));
		super.setLocationRelativeTo(null);
		super.pack();
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void configurePnBase(){
		
		GridBagLayout layoutData3 = new GridBagLayout();
		pnBase.setLayout(layoutData3);
		
		GBC gbc1 = new GBC(1,1).setSpan(1, 3);
		GBC gbc2 = new GBC(2,1).setSpan(4, 3);
		GBC gbc3 = new GBC(1,5).setSpan(1, 3);
		GBC gbc4 = new GBC(2,5).setSpan(3, 3);
		GBC gbc5 = new GBC(1,8).setSpan(1, 3);
		GBC gbc6 = new GBC(2,8).setSpan(6, 3);
	
		
		
		pnBase.add(lbNome,gbc1);
		pnBase.add(txNome,gbc2);
		pnBase.add(lbCpf,gbc3);
		pnBase.add(txCpf,gbc4);
		pnBase.add(lbEmail,gbc5);
		pnBase.add(txEmail,gbc6);
		
		
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Alteração de Cliente");
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
	
	
	//botao cancelar
	private void configureBtCancelar(){
		ActionListener lstAutenticacao = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButtonCalcelarActionPerfomed(e);
			}
		};
		
		btCancelar.addActionListener(lstAutenticacao);
	}
	
	private void JButtonCalcelarActionPerfomed(java.awt.event.ActionEvent evt){
		this.dispose();
	}

}
