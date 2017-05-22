package trabalhoBD.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


import trabalhoBD.dao.Conexao;

public class telaLogin extends JFrame{
	private Conexao conectar;
	
	private JLabel lbUser = new JLabel("Usuário:");
	private JLabel lbSenha = new JLabel("Senha:");
	
	
	private JTextField txUser = new JTextField(20);
	private JTextField txSenha = new JTextField(14);
	
	
	private JPanel pnBase = new JPanel();
	private JPanel pnLog = new JPanel();
	
	private JButton btEntrar = new JButton("Entrar");
	private JButton btFechar = new JButton("Fechar");
	
	public telaLogin(){
		this.conectar = new Conexao();
	}
	public void init() {
		configurePnLog();
		configureBtFechar();
		configureBtEntrar();
		
		GridBagLayout layoutData = new GridBagLayout();
		pnBase.setLayout(layoutData);
		GBC gbc10 = new GBC(2,2);
		pnBase.add(pnLog,gbc10);
		
		super.setTitle("Tela de Login");
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.setPreferredSize(new Dimension(420,330));
		super.setLocationRelativeTo(null);
		super.pack();
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void configurePnLog(){
		GridBagLayout layoutData = new GridBagLayout();
		pnLog.setLayout(layoutData);
		
		GBC gbc1 = new GBC(1,1).setSpan(1, 1);
		GBC gbc2 = new GBC(2,1).setSpan(3, 1);
		GBC gbc3 = new GBC(1,5).setSpan(1, 1);
		GBC gbc4 = new GBC(2,5).setSpan(3, 1);
		
		GBC gbc7 = new GBC(2,10).setSpan(1, 1);
		GBC gbc8 = new GBC(3,10).setSpan(1, 1);
		
		pnLog.add(lbUser,gbc1);
		pnLog.add(txUser,gbc2);
		pnLog.add(lbSenha,gbc3);
		pnLog.add(txSenha,gbc4);
		pnLog.add(btEntrar,gbc7);
		pnLog.add(btFechar,gbc8);
		
		LineBorder colorBorder = new LineBorder(Color.DARK_GRAY);
		TitledBorder border = new TitledBorder(colorBorder, "Login");
		pnLog.setBorder(border);
		
		super.setSize(400, 300);
		super.setContentPane(pnLog);
		super.setVisible(true);
		super.pack();
	}
	
	
	//botao entrar
	private void configureBtEntrar(){
		ActionListener lstAutenticacao = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					JButtonEntrarActionPerformed(e);
				}catch (Exception e1){
					e1.printStackTrace();
				}
				
			}
			
		};
		btEntrar.addActionListener(lstAutenticacao);
	}
	
	private void JButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) throws Exception{
		Statement conex = conectar.conectar();
		try{
			String sql = "SELECT * From usuarios WHERE nome = '" + txUser.getText() + "'";
			ResultSet rs = conex.executeQuery(sql);
			while(rs.next()){
				if(rs.getString("senha").equals(txSenha.getText())){
					telaPrincipal tlPrinc = new telaPrincipal();
					tlPrinc.init();
					dispose(); //fechar a tela anterior
				}else{
					JOptionPane.showMessageDialog(rootPane, "Senha ou Usuário invalidos!");
				}
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(rootPane, "Senha ou Usuário invalidos!");
		}
		
	}
	
	//botao fechar
		private void configureBtFechar(){
			ActionListener lstAutenticacao = new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						JButtonFecharActionPerformed(e);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			};
			btFechar.addActionListener(lstAutenticacao);
		}
		
		private void JButtonFecharActionPerformed(java.awt.event.ActionEvent evt) throws Exception{
			
			System.exit(0);
		}
}
