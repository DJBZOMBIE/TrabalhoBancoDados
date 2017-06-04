package trabalhoBD.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import trabalhoBD.controller.clienteController;
import trabalhoBD.dao.Conexao;
import trabalhoBD.model.Cliente;
import trabalhoBD.model.ClienteTableModel;

public class telaCliente extends JFrame{
	private clienteController controller = new clienteController();
	private ArrayList<Cliente> newList = new ArrayList<Cliente>();
	private Conexao conectar;
	
	private ClienteTableModel model = new ClienteTableModel(newList);
	private telaPrincipal tela = new telaPrincipal();
	
	private JTable table = new JTable(model);
	private JLabel lbCod = new JLabel("Pesquisar por (ID):");
	private JTextField txCod = new JTextField(20);
	private JPanel pnBase = new JPanel();
	private JPanel pnTab = new JPanel();
	
	private JButton btbuscar = new JButton("Buscar");
	private JButton btList = new JButton("Listar");
	private JButton btNovo = new JButton("Novo");
	private JButton btAlt = new JButton("Alterar");
	private JButton btRemove = new JButton("Remover");
	//===================
	

	
	public telaCliente(){
		this.conectar = new Conexao();
	}
	
	public void init(){
		configurePnTab();
		
		configureBtAlterar();
		configureBtRemover();
		configureBtListar();
		configureBtInserir();
		configureBtBuscar();
		
		GridBagLayout layoutData = new GridBagLayout();
		pnBase.setLayout(layoutData);
		
		GBC gbc10 = new GBC(1,1);
		pnBase.add(pnTab,gbc10);
		
		super.setTitle("Tela Cliente");
		super.setSize(200, 300);
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
		super.setLocationRelativeTo(null);
		//super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //quando clicar em fechar não irá fechar o form principal
	}
	
	public void configurePnTab(){
		
		JScrollPane scroll = new JScrollPane(table);
		GridBagLayout layoutData = new GridBagLayout();
		
		
		pnTab.setLayout(layoutData);
		
		GBC gbc1 = new GBC(1,1).setSpan(1, 1);
		GBC gbc2 = new GBC(2,1).setSpan(3, 1);
		GBC gbc8 = new GBC(5,1).setSpan(1, 1);
		GBC gbc3 = new GBC(1,8).setSpan(1, 1);//botoes
		GBC gbc4 = new GBC(2,8).setSpan(1, 1);
		GBC gbc5 = new GBC(3,8).setSpan(1, 1);
		GBC gbc6 = new GBC(4,8).setSpan(1, 1);//fim botoes
		GBC gbc7 = new GBC(1,3).setSpan(6, 3);
		pnTab.add(lbCod, gbc1);
		pnTab.add(txCod, gbc2);
		pnTab.add(btList, gbc3);
		pnTab.add(btNovo, gbc4);
		pnTab.add(btAlt, gbc5);
		pnTab.add(btRemove, gbc6);
		pnTab.add(scroll, gbc7);
		pnTab.add(btbuscar,gbc8);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Cliente");
		pnTab.setBorder(border);
		
		
		
		super.setSize(200, 300);
		super.setContentPane(pnTab);
		super.setVisible(true);
		super.pack();
	}
	
	
	//cahamar tela AlterarCliente
		private void configureBtAlterar(){
			ActionListener lstAutenticacao = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButtomAlterarClienteActionPerfomed(e);
				}
			};
			
			btAlt.addActionListener(lstAutenticacao);
		}

		
		
		private void JButtomAlterarClienteActionPerfomed(java.awt.event.ActionEvent evt){
			telaAlterarCliente cliente = new telaAlterarCliente();
			
			
			cliente.init();
		}
		
		//botao remover cliente
		private void configureBtRemover(){
			ActionListener lstAutenticacao = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButtomRemoverClienteActionPerfomed(e);
				}
			};
			
			btRemove.addActionListener(lstAutenticacao);
		}

		
		
		private void JButtomRemoverClienteActionPerfomed(java.awt.event.ActionEvent evt){
			
			
			try{
				
				//this.newList.get(table.getSelectedRow()) serve para pegar um dos clientes que foi listado da jtable
			controller.remover(this.newList.get(table.getSelectedRow()));
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
		}
		
		
		//botao listar todos
		private void configureBtListar(){
			ActionListener lstAutenticacao = new ActionListener() {
				@Override
				
				public void actionPerformed(ActionEvent e) {
					try {
						JButtomListarClienteActionPerfomed(e);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			};
			
			btList.addActionListener(lstAutenticacao);
		}

		
		
		private void JButtomListarClienteActionPerfomed(java.awt.event.ActionEvent evt) throws Exception{
			//dar uma olhada nesse for 
			model.setColumnIdentifiers(new String[]{"Cod","Nome","Email","CPF"});
			this.newList = controller.listarTodos();
			for(int i = 0; i< newList.size(); i++){
				model.addRow(new Object[]{this.newList.get(i).getCod(), this.newList.get(i).getNome(),this.newList.get(i).getEmail(), this.newList.get(i).getCpf()});
			}
			
		}
		
		//botao Inserir
		private void configureBtInserir(){
			ActionListener lstAutenticacao = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						JButtomInserirClienteActionPerfomed(e);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			};
			
			btNovo.addActionListener(lstAutenticacao);
		}

		
		
		private void JButtomInserirClienteActionPerfomed(java.awt.event.ActionEvent evt) throws Exception{
			telaCadastroCliente cadCad = new telaCadastroCliente();
			
			cadCad.init();
		}
	
		
		
		//testando busca
		//listar clientes
			public ArrayList <Cliente> busca() throws Exception{
				

				if (txCod.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "campos vazios!");
					throw new Exception("Campos vazios");
				}
				
				//abrindo conexao
				Statement conex = conectar.conectar();
				ArrayList<Cliente> retorno = new ArrayList<Cliente>();
				
				String sql = "SELECT cod, nome, email, cpf FROM cliente WHERE cod = '" + txCod.getText() + "'";
				try{
					ResultSet rs = conex.executeQuery(sql);
					while(rs.next()){
					
						Cliente cliente = new Cliente();
						cliente.setCod(rs.getInt("cod"));
						cliente.setNnome(rs.getString("nome"));
						cliente.setEmail(rs.getString("email"));
						cliente.setCpf(rs.getString("cpf"));
						retorno.add(cliente);
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
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				};
				
				btbuscar.addActionListener(lstAutenticacao);
			}

			
			
			private void JButtomListarBuscarActionPerfomed(java.awt.event.ActionEvent evt) throws Exception{
				//dar uma olhada nesse for 
				model.setColumnIdentifiers(new String[]{"Cod","Nome","Email","CPF"});
				this.newList = busca();
				for(int i = 0; i< newList.size(); i++){
					model.addRow(new Object[]{this.newList.get(i).getCod(), this.newList.get(i).getNome(),this.newList.get(i).getEmail(), this.newList.get(i).getCpf()});
				}
				
			}
		
}
		

