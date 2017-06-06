package trabalhoBD.view;

import java.awt.Color;
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
		configureBtRemover();
		configureBtListar();
		configureBtBuscar();
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
		
		//botao remover
		private void configureBtRemover(){
			ActionListener lstAutenticacao = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButtomRemoverFuncActionPerfomed(e);
				}
			};
			
			btRemove.addActionListener(lstAutenticacao);
		}
		private void JButtomRemoverFuncActionPerfomed(java.awt.event.ActionEvent evt){
			try{
				//this.newList.get(table.getSelectedRow()) serve para pegar um dos clientes que foi listado da jtable
			controller.remover(this.newList.get(table.getSelectedRow()));
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
		}
		
		//botao listar
		private void configureBtListar(){
			ActionListener lstAutenticacao = new ActionListener() {
				@Override
				
				public void actionPerformed(ActionEvent e) {
					try {
						JButtomListarFuncActionPerfomed(e);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			};
			
			btList.addActionListener(lstAutenticacao);
		}
		private void JButtomListarFuncActionPerfomed(java.awt.event.ActionEvent evt) throws Exception{
			//dar uma olhada nesse for 
			model.setColumnIdentifiers(new String[]{"Cod","Nome","CPF","Cargo"});
			this.newList = controller.listarTodos();
			for(int i = 0; i< newList.size(); i++){
				model.addRow(new Object[]{this.newList.get(i).getCod(), this.newList.get(i).getNome(),this.newList.get(i).getCpf(), this.newList.get(i).getCargo()});
			}
			
		}
		
		//buscar funcionario
		public ArrayList<Funcionario> busca() throws Exception{
			if (txCod.getText().trim().equals("")){
				JOptionPane.showMessageDialog(null, "campos vazios!");
				
			}
			Statement conex = conectar.conectar();
			ArrayList<Funcionario> retorno = new ArrayList<Funcionario>();
			String sql = "SELECT cod, nome, cpf, cargo FROM funcionario WHERE cod = '" + txCod.getText() + "'";
			try{
				ResultSet rs = conex.executeQuery(sql);
				while(rs.next()){
					Funcionario func = new Funcionario();
					func.setCod(rs.getInt("cod"));
					func.setNome(rs.getString("nome"));
					func.setCpf(rs.getString("cpf"));
					func.setCargo(rs.getString("cargo"));
					retorno.add(func);
					
				}
		}catch(SQLException e){
			throw new Exception("Erro ao executar consulta: " + e.getMessage());
		}
			conectar.desconectar();
			
			return retorno;	
		}
		
		//botao buscar
		private void configureBtBuscar(){
			ActionListener lstAutenticacao = new ActionListener() {
				@Override
				
				public void actionPerformed(ActionEvent e) {
					try {
						JButtomListarBuscarActionPerfomed(e);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			};
			
			btBuscar.addActionListener(lstAutenticacao);
		}
		
		private void JButtomListarBuscarActionPerfomed(java.awt.event.ActionEvent evt) throws Exception{
			model.setColumnIdentifiers(new String[]{"Cod","Nome","CPF","Cargo"});
			this.newList = busca();
			for(int i = 0; i< newList.size(); i++){
				model.addRow(new Object[]{this.newList.get(i).getCod(), this.newList.get(i).getNome(),this.newList.get(i).getCpf(), this.newList.get(i).getCargo()});
			}
			
		}
}
