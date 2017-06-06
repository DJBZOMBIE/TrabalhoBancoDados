package trabalhoBD.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
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



public class telaPrincipal extends JFrame {
	private telaCliente controller2;
	private Conexao conectar;
	private JLabel Tipouser = new JLabel("Usuário:");
	private JLabel user = new JLabel();
	
	private JPanel pnBase = new JPanel();
	private JPanel pnMain = new JPanel();
	private JButton btCli = new JButton("Clientes");
	private JButton btPro = new JButton("Produtos");
	private JButton btPed = new JButton("Pedidos");
	private JButton btEntrada = new JButton("Entrada de Estoque");
	private JButton btFunc = new JButton("Funcionario");
	private JButton btLogin = new JButton("Controle de Login");
	private JButton btBackup = new JButton("Backup");
	
	public telaPrincipal(String usuario){
		user.setText(usuario);
		this.conectar = new Conexao();
		
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
		configureBtFuncionario();
		configureBtControlLogin();
		configureBtBackup();
		super.setContentPane(pnBase);
		
		super.setTitle("Tela Principal");
		super.setVisible(true);
		super.setPreferredSize(new Dimension(320,350));
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
		GBC gbc5 = new GBC(3,5).setSpan(3, 1);
		GBC gbc6 = new GBC(3,6).setSpan(3, 1);
		GBC gbc7 = new GBC(3,7).setSpan(3, 1);
		GBC gbc8 = new GBC(3,8).setSpan(1, 1);
		GBC gbc9 = new GBC(4,8).setSpan(1, 1);
		
		pnBase.add(btCli,gbc1);
		pnBase.add(btPro,gbc2);
		pnBase.add(btPed,gbc3);
		pnBase.add(btEntrada,gbc4);
		pnBase.add(btFunc, gbc5);
		pnBase.add(btLogin, gbc6);
		pnBase.add(btBackup, gbc7);
		pnBase.add(user,gbc9);
		pnBase.add(Tipouser,gbc8);
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
	
	//botao funcionario
	private void configureBtFuncionario(){
		ActionListener lstAutenticacao = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JButtonFuncionarioPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		};
		
		btFunc.addActionListener(lstAutenticacao);
	}
	
	public void JButtonFuncionarioPerformed(java.awt.event.ActionEvent evt) throws Exception{
		Statement conex = conectar.conectar();
		try {
			String sql = "SELECT * From usuarios WHERE nome = '" + user.getText() + "'";
			ResultSet rs = conex.executeQuery(sql);
			while(rs.next()){
			if(rs.getString("tipo").equals("Administrador")){
				telaFuncionario telaEnt = new telaFuncionario();
				telaEnt.init();
			}else{
				JOptionPane.showMessageDialog(rootPane, "Você não tem permissão para executar essa funcionalidade!\n Contate o adm do Sistema!" );
			}
		}
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(rootPane, "Você não tem permissão para executar essa funcionalidade!\n Contate o adm do Sistema!" + ex );
		}
		
		
		
	}
	
	//botao controleLogin
		private void configureBtControlLogin(){
			ActionListener lstAutenticacao = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						JButtonLoginPerformed(e);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			};
			
			btLogin.addActionListener(lstAutenticacao);
		}
		
		public void JButtonLoginPerformed(java.awt.event.ActionEvent evt) throws Exception{
			Statement conex = conectar.conectar();
			try {
				
				String sql = "SELECT * From usuarios WHERE nome = '" + user.getText() + "'";
				ResultSet rs = conex.executeQuery(sql);
				while(rs.next()){
					if(rs.getString("tipo").equals("Administrador")){
						telaControleLogin telaEnt = new telaControleLogin();
						telaEnt.init();
				}else{
					JOptionPane.showMessageDialog(rootPane, "Você não tem permissão para executar essa funcionalidade!\n Contate o adm do Sistema!" );
				}
			} 
			}catch (Exception ex) {
				JOptionPane.showMessageDialog(rootPane, "Você não tem permissão para executar essa funcionalidade!\n Contate o adm do Sistema!"+ex );
			}	
		}
	
	//botao backup
		private void configureBtBackup(){
			ActionListener lstAutenticacao = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButtonBackupPerfomed(e);
				}
			};
			
			btBackup.addActionListener(lstAutenticacao);
		}
		
		public void JButtonBackupPerfomed(java.awt.event.ActionEvent evt){
			telaBackup telaBackup = new telaBackup();
			
			pnBase.setVisible(false);
			telaBackup.init();
			pnBase.setVisible(true);
		}
		

}
