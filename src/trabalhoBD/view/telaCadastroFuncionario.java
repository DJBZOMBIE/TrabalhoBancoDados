package trabalhoBD.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import trabalhoBD.controller.funcionarioController;
import trabalhoBD.dao.Conexao;
import trabalhoBD.model.Funcionario;

public class telaCadastroFuncionario extends JFrame{
	private funcionarioController controller = new funcionarioController();
	private ArrayList<Funcionario> newList = new ArrayList<Funcionario>();
	private Conexao conectar;
	private Statement connection;
	
	private JLabel lbNome = new JLabel("Nome:");
	private JLabel lbCpf = new JLabel("CPF:");
	private JLabel lbCargo = new JLabel("Cargo:");
	private JLabel lbUser = new JLabel("Username:");
	private JLabel lbSenha= new JLabel("Senha:");
	
	private JTextField txNome = new JTextField(20);
	private JTextField txCpf = new JTextField(14);
	private JTextField txCargo = new JTextField(20);
	private JTextField txUser = new JTextField(20);
	private JTextField txSenha = new JTextField(14);
	
	private JPanel pnBase = new JPanel();
	private JPanel pnBot = new JPanel();
	private JPanel pnMain = new JPanel();
	
	private JButton btSalvar = new JButton("Salvar");
	private JButton btCancelar = new JButton("Cancelar");
	
	public telaCadastroFuncionario(){
		
	}
	
	public void init() {
		configurePnBase();
		configurePnBotao();
		configureBtCancelar();
		configureBTSalvar();
		GridBagLayout layoutData = new GridBagLayout();
		pnMain.setLayout(layoutData);
		
		GBC gbc10 = new GBC(2,2);
		GBC gbc11 = new GBC(2,5);
		pnMain.add(pnBase,gbc10);
		pnMain.add(pnBot,gbc11);
		
		super.setTitle("Cadastro Funcionario");
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
		GBC gbc6 = new GBC(2,8).setSpan(3, 3);
		GBC gbc7 = new GBC(1,11).setSpan(1, 3);
		GBC gbc8 = new GBC(2,11).setSpan(3, 3);
		GBC gbc9 = new GBC(1,14).setSpan(1, 3);
		GBC gbc10 = new GBC(2,14).setSpan(3, 3);
		
		pnBase.add(lbNome,gbc1);
		pnBase.add(txNome,gbc2);
		pnBase.add(lbCpf,gbc3);
		pnBase.add(txCpf,gbc4);
		pnBase.add(lbCargo,gbc5);
		pnBase.add(txCargo,gbc6);
		
		LineBorder colorBorder = new LineBorder(Color.DARK_GRAY);
		TitledBorder border = new TitledBorder(colorBorder, "Cadastro de Funcionário");
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
	
	private void configureBTSalvar(){
		ActionListener lstAutenticacao = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButtonSalvarActionPerformed(e);
			}
		};
		btSalvar.addActionListener(lstAutenticacao);
	}
	
	public void JButtonSalvarActionPerformed(java.awt.event.ActionEvent evt){
		try{
			Funcionario func = new Funcionario();
			func.setNome(txNome.getText());
			func.setCpf(txCpf.getText());
			func.setCargo(txCargo.getText());
			controller.inserir(func);
			JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso");
			clearFields();
			
		}catch(Exception ex){
			
			JOptionPane.showMessageDialog(null, "Campos vazios");
		}
	}
	public void clearFields(){
		txNome.setText("");
		txCpf.setText("");
		txCargo.setText("");
	}
}
