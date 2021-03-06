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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import trabalhoBD.controller.funcionarioController;
import trabalhoBD.dao.Conexao;
import trabalhoBD.model.Funcionario;
import trabalhoBD.model.funcionarioTableModel;

public class telaAlterarFuncionario extends JFrame{
	
	private funcionarioController controller = new funcionarioController();
	private ArrayList<Funcionario> newList = new ArrayList<Funcionario>();
	private Conexao conectar;
	private Statement connection;
	
	private JLabel idFuncionario = new JLabel("ID do funcionário");
	private JLabel lbNome = new JLabel("Nome:");
	private JLabel lbCpf = new JLabel("CPF:");
	private JLabel lbCargo = new JLabel("Cargo:");
	
	private JTextField txNome = new JTextField(20);
	private JTextField txCpf = new JTextField(14);
	private JTextField txCargo = new JTextField(20);
	private JTextField txID = new JTextField(10);
	
	private JPanel pnBase = new JPanel();
	private JPanel pnBot = new JPanel();
	private JPanel pnMain = new JPanel();
	
	private JButton btSalvar = new JButton("Alterar");
	private JButton btCancelar = new JButton("Cancelar");

	public void init() {
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
		
		super.setTitle("Alterar Funcionario");
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
		
		GBC gbc1 = new GBC(1,1).setSpan(1, 2);
		GBC gbc2 = new GBC(2,1).setSpan(4, 3);
		GBC gbc3 = new GBC(1,5).setSpan(1, 3);
		GBC gbc4 = new GBC(2,5).setSpan(3, 3);
		GBC gbc5 = new GBC(1,8).setSpan(1, 3);
		GBC gbc6 = new GBC(2,8).setSpan(6, 3);
		GBC gbc7 = new GBC(1,11).setSpan(1, 3);
		GBC gbc8 = new GBC(2,11).setSpan(3, 3);
		
		pnBase.add(lbNome,gbc3);
		pnBase.add(txNome,gbc4);
		pnBase.add(lbCpf,gbc5);
		pnBase.add(txCpf,gbc6);
		pnBase.add(lbCargo,gbc7);
		pnBase.add(txCargo,gbc8);
		pnBase.add(idFuncionario,gbc1);
		pnBase.add(txID,gbc2);
		
		LineBorder colorBorder = new LineBorder(Color.DARK_GRAY);
		TitledBorder border = new TitledBorder(colorBorder, "Alterar Funcionário");
		pnBase.setBorder(border);
		
		super.setSize(400, 300);
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
		
		//botao salvar
		private void configureBtSalvar(){
			ActionListener lstAutenticacao = new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					JButtonSalvarActionPerfomed(e);
					
				}
				
			};
			btSalvar.addActionListener(lstAutenticacao);
		}
		
		private void JButtonSalvarActionPerfomed(java.awt.event.ActionEvent evt){
			int number;
			String valor;
			try{
				Funcionario func = new Funcionario();
				try{
					valor = txID.getText();
					number = Integer.parseInt(valor);
					func.setCod(number);
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(null,"Digite apenas numeros no ID"+ex);
				}
				func.setNome(txNome.getText());
				func.setCpf(txCpf.getText());
				func.setCargo(txCargo.getText());
				controller.atualizar(func);
				JOptionPane.showMessageDialog(null, "Funcionario alterado com sucesso");
				clearFields();
			}catch (Exception ex){
				
				JOptionPane.showMessageDialog(null, "erro na alteração"+ex);
			}
		}
		
		public void clearFields(){
			txID.setText("");
			txNome.setText("");
			txCpf.setText("");
			txCargo.setText("");
		}
}
