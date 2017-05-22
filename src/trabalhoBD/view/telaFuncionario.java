package trabalhoBD.view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import trabalhoBD.controller.funcionarioController;
import trabalhoBD.dao.Conexao;
import trabalhoBD.model.Funcionario;
import trabalhoBD.model.funcionarioTableModel;

public class telaFuncionario extends JFrame {
	private funcionarioController controller = new funcionarioController();
	private ArrayList<Funcionario> newList = new ArrayList<Funcionario>();
	
	private Conexao conectar;
	
	private funcionarioTableModel model = new funcionarioTableModel(newList);
	
	private JTable table = new JTable(model);
	private JLabel lbCod = new JLabel("Pesquisar por (ID): ");
	private JTextField txCod = new JTextField(20);
	
	private JPanel pnBase = new JPanel();
	private JPanel pnTab = new JPanel();
	
	private JButton btBuscar = new JButton("Buscar");
	private JButton btList = new JButton("Listar");
	private JButton btNovo = new JButton("Novo");
	private JButton btRemove = new JButton("Remover");
	private JButton btAlterar = new JButton("Alterar");
	
	public telaFuncionario(){
		this.conectar = new Conexao();
	}
	
	public void init(){
		configurePnBase();
		configureBtInserir();
		configureBtAlterar();
		
		GridBagLayout layoutData = new GridBagLayout();
		pnTab.setLayout(layoutData);
		
		GBC gbc10 = new GBC(1,1);
		pnTab.add(pnBase,gbc10);
		
		super.setTitle("Tela Funcionario");
		super.setSize(200, 300);
		super.setContentPane(pnTab);
		super.setVisible(true);
		super.pack();
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void configurePnBase(){
		JScrollPane scroll = new JScrollPane(table);
		GridBagLayout layoutData = new GridBagLayout();
		
		pnBase.setLayout(layoutData);
		
		GBC gbc1 = new GBC(1,1).setSpan(1, 1);
		GBC gbc2 = new GBC(2,1).setSpan(3, 1);
		GBC gbc3 = new GBC(1,8).setSpan(1, 1);//botoes
		GBC gbc4 = new GBC(2,8).setSpan(1, 1);
		GBC gbc5 = new GBC(3,8).setSpan(1, 1); //alterar
		GBC gbc6 = new GBC(4,8).setSpan(1, 1);
		GBC gbc7 = new GBC(1,3).setSpan(6, 3);
		GBC gbc8 = new GBC(5,1).setSpan(1, 1);
		
		pnBase.add(lbCod, gbc1);
		pnBase.add(txCod, gbc2);
		pnBase.add(btList, gbc3);
		pnBase.add(btNovo, gbc4);
		pnBase.add(btAlterar, gbc5);
		pnBase.add(btRemove, gbc6);
		pnBase.add(scroll, gbc7);
		pnBase.add(btBuscar, gbc8);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Funcionario");
		pnBase.setBorder(border);
		
		
		
		super.setSize(200, 300);
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
	}
	
	//botao novo funcionario
	private void configureBtInserir(){
		ActionListener lstAutenticacao = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					JButtomInserirFuncionarioActionPerfomed(e);
				}catch(Exception e1){
					e1.printStackTrace();
				}
				
			}
		};
		btNovo.addActionListener(lstAutenticacao);
	}
	
	private void JButtomInserirFuncionarioActionPerfomed(java.awt.event.ActionEvent evt) throws Exception{
		telaCadastroFuncionario cadFunc = new telaCadastroFuncionario();
		
		cadFunc.init();
	}
	
	//botao alterar funcionario
		private void configureBtAlterar(){
			ActionListener lstAutenticacao = new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					try{
						JButtomAlterarFuncionarioActionPerfomed(e);
					}catch(Exception e1){
						e1.printStackTrace();
					}
					
				}
			};
			btAlterar.addActionListener(lstAutenticacao);
		}
		
		private void JButtomAlterarFuncionarioActionPerfomed(java.awt.event.ActionEvent evt) throws Exception{
			telaAlterarFuncionario AltFunc = new telaAlterarFuncionario();
			
			AltFunc.init();
		}
}
