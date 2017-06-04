package trabalhoBD.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class telaAlterarLogin extends JFrame{
	
	private JPanel pnMain = new JPanel();
	private JPanel pnBase = new JPanel();
	private JPanel pnBotao = new JPanel();
	
	private JLabel lbCod = new JLabel("ID do login:");
	private JLabel lbNome = new JLabel("Nome do usuário:");
	private JLabel lbSenha = new JLabel("Nova senha:");
	private JLabel lbTipo = new JLabel("Tipo de usuário:");
	
	private JTextField txCod = new JTextField(14);
	private JTextField txNome = new JTextField(20);
	private JTextField txSenha = new JTextField(14);
	private JTextField txTipo = new JTextField(20);
	
	private JButton btSalvar = new JButton("Salvar");
	private JButton btCancelar = new JButton("Cancelar");
	
	public telaAlterarLogin(){
		
	}
	
	public void init(){
		configurePnBase();
		configurePnBotao();
		
		configureBtCancelar();
		//configureBtSalvar();
		GridBagLayout layoutData = new GridBagLayout();
		pnMain.setLayout(layoutData);
		
		GBC gbc10 = new GBC(2,2);
		GBC gbc11 = new GBC(2,5);
		pnMain.add(pnBase,gbc10);
		pnMain.add(pnBotao,gbc11);
		
		super.setTitle("Alteração de Login");
		super.setContentPane(pnMain);
		super.setVisible(true);
		super.setPreferredSize(new Dimension(420,250));
		super.setLocationRelativeTo(null);
		super.pack();
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void configurePnBase(){
		
		GridBagLayout layoutData3 = new GridBagLayout();
		pnBase.setLayout(layoutData3);
		
		GBC gbc0 = new GBC(1,1).setSpan(1, 3);
		GBC gbc01 = new GBC(2,1).setSpan(4, 3);
		GBC gbc1 = new GBC(1,5).setSpan(1, 3);
		GBC gbc2 = new GBC(2,5).setSpan(4, 3);
		GBC gbc3 = new GBC(1,8).setSpan(1, 3);
		GBC gbc4 = new GBC(2,8).setSpan(3, 3);
		GBC gbc5 = new GBC(1,11).setSpan(1, 3);
		GBC gbc6 = new GBC(2,11).setSpan(6, 3);
	
		
		pnBase.add(lbCod,gbc0);
		pnBase.add(txCod,gbc01);
		pnBase.add(lbNome,gbc1);
		pnBase.add(txNome,gbc2);
		pnBase.add(lbSenha,gbc3);
		pnBase.add(txSenha,gbc4);
		pnBase.add(lbTipo,gbc5);
		pnBase.add(txTipo,gbc6);
		
		
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Alteração de Login");
		pnBase.setBorder(border);
		
		super.setSize(400, 300);
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
		//super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void configurePnBotao(){
		GridBagLayout layoutData2 = new GridBagLayout();
		pnBotao.setLayout(layoutData2);
		
		GBC gbc9 = new GBC(3,10).setSpan(1, 1);
		GBC gbc10 = new GBC(4,10).setSpan(1, 1);
		
		pnBotao.add(btSalvar,gbc9);
		pnBotao.add(btCancelar,gbc10);
		
		super.setContentPane(pnBotao);
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
