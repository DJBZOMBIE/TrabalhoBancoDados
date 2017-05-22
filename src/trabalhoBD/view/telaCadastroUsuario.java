package trabalhoBD.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import trabalhoBD.dao.Conexao;
import trabalhoBD.dao.usuariosControllerDao;
import trabalhoBD.model.Usuarios;

public class telaCadastroUsuario extends JFrame{
	private usuariosControllerDao controller = new usuariosControllerDao();
	private ArrayList<Usuarios> newList = new ArrayList<Usuarios>();
	private Conexao conectar;
	private Statement connection;
	
	private JLabel lbNome = new JLabel("Nome:");
	private JLabel lbSenha= new JLabel("Senha:");
	private JLabel lbTipo = new JLabel("Tipo(Admin/Func):");
	
	private JTextField txNome = new JTextField(20);
	private JTextField txSenha = new JTextField(14);
	private JTextField txTipo = new JTextField(20);
	
	private JPanel pnBase = new JPanel();
	private JPanel pnBot = new JPanel();
	private JPanel pnMain = new JPanel();
	
	private JButton btSalvar = new JButton("Salvar");
	private JButton btCancelar = new JButton("Cancelar");
	
	public telaCadastroUsuario(){
		this.conectar = new Conexao();
	}
	
	public void init(){
		configurePnBase();
		configurePnBotao();
		configureBtCancelar();
		configureBtSalvar();
		GridBagLayout layoutData = new GridBagLayout();
		pnMain.setLayout(layoutData);
		
		GBC gbc10 = new GBC(2,2);
		GBC gbc11 = new GBC(2,5);
		pnMain.add(pnBase,gbc10);
		pnMain.add(pnBot,gbc11);
		
		super.setTitle("Cadastro de Usuarios");
		super.setContentPane(pnMain);
		super.setVisible(true);
		super.setPreferredSize(new Dimension(420,250));
		super.setLocationRelativeTo(null);
		super.pack();
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void configurePnBase(){
		GridBagLayout layoutData = new GridBagLayout();
		pnBase.setLayout(layoutData);
		
		GBC gbc1 = new GBC(1,1).setSpan(1, 3);
		GBC gbc2 = new GBC(2,1).setSpan(4, 3);
		GBC gbc3 = new GBC(1,5).setSpan(1, 3);
		GBC gbc4 = new GBC(2,5).setSpan(3, 3);
		GBC gbc5 = new GBC(1,8).setSpan(1, 3);
		GBC gbc6 = new GBC(2,8).setSpan(4, 3);
		
		pnBase.add(lbNome,gbc1);
		pnBase.add(txNome,gbc2);
		pnBase.add(lbSenha,gbc3);
		pnBase.add(txSenha,gbc4);
		pnBase.add(lbTipo,gbc5);
		pnBase.add(txTipo,gbc6);
		
		LineBorder colorBorder = new LineBorder(Color.DARK_GRAY);
		TitledBorder border = new TitledBorder(colorBorder, "Cadastro de Login");
		pnBase.setBorder(border);
		
		super.setSize(420, 300);
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
	
	//botao salvar
	private void configureBtSalvar(){
		ActionListener lstAutenticacao = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JButtonSalvarActionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			};
			btSalvar.addActionListener(lstAutenticacao);
	}
	
	
	public void JButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		
		//tentar arrumar esse try
			try{
			Usuarios user = new Usuarios();
			user.setNome(txNome.getText());
			user.setSenha(txSenha.getText());
			user.setTipo(txTipo.getText());
			teste();
			controller.inserir(user);
			this.dispose();
			JOptionPane.showMessageDialog(null, "Login cadastrado com sucesso");
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Possíveis erros: Nome já existente ou campos vazios");
			}
			
		
	}
	
	public void teste () throws Exception{
		int result = 0;
		Statement conex = conectar.conectar();
		String sql = "SELECT nome From usuarios WHERE nome = '" + txNome.getText() + "'";
		try{
		ResultSet rs = conex.executeQuery(sql);
			while(rs.next()){
				if(rs.getString("nome").equals(txNome.getText())){
					throw new Exception("Nome de usuario ja existe!");
				}
			}
			
		}catch(SQLException e){
			throw new Exception("Erro");
		}
		conectar.desconectar();
		
	}
	
	//botao cancelar
	private void configureBtCancelar(){
		ActionListener lstAutenticacao = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JButtonCancelarActionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		};
		btCancelar.addActionListener(lstAutenticacao);
	}
	
	private void JButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) throws Exception{
		this.dispose();
	}
}
