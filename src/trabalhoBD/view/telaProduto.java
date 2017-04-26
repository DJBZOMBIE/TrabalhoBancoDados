package trabalhoBD.view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
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

import trabalhoBD.controller.clienteController;
import trabalhoBD.controller.produtoController;
import trabalhoBD.dao.Conexao;
import trabalhoBD.model.Cliente;
import trabalhoBD.model.ClienteTableModel;
import trabalhoBD.model.Produto;
import trabalhoBD.model.ProdutoTableModel;

public class telaProduto extends JFrame {
	private produtoController controller = new produtoController();
	private ArrayList<Produto> newList = new ArrayList<Produto>();
	private ProdutoTableModel model = new ProdutoTableModel(newList);
	private Conexao conectar;
	private JTable table = new JTable(model);
	private JLabel lbCod = new JLabel("Pesquisar por (ID):");
	private JTextField txCod = new JTextField(20);
	private JPanel pnBase = new JPanel();
	private JPanel pnProd = new JPanel();
	private JButton btbuscar = new JButton("Buscar");
	private JButton btList = new JButton("Listar");
	private JButton btNovo = new JButton("Novo");
	//private JButton btAlt = new JButton("Alterar");
	private JButton btRemove = new JButton("Remover");
	
	public telaProduto(){ //tentar modificar depois
		this.controller = controller;
		this.conectar = new Conexao();
	}
	
	public void init(){
		configurePnPro();
		configureBtListar();
		configureBtInserir();
		configureBtRemover();
		configureBtBuscar();
		GridBagLayout layoutData = new GridBagLayout();
		pnBase.setLayout(layoutData);
		
		GBC gbc10 = new GBC(1,1);
		pnBase.add(pnProd,gbc10);
		
		super.setTitle("Tela Produtos");
		super.setSize(200, 300);
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
		super.setLocationRelativeTo(null);
		//super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void configurePnPro(){
		
		JScrollPane scroll = new JScrollPane(table);
		GridBagLayout layoutData = new GridBagLayout();
		pnProd.setLayout(layoutData);
		
		GBC gbc1 = new GBC(1,1).setSpan(1, 1);
		GBC gbc2 = new GBC(2,1).setSpan(3, 1);
		GBC gbc8 = new GBC(5,1).setSpan(1, 1);
		GBC gbc3 = new GBC(1,8).setSpan(1, 1);//botoes
		GBC gbc4 = new GBC(2,8).setSpan(1, 1);
		GBC gbc5 = new GBC(3,8).setSpan(1, 1);
		GBC gbc6 = new GBC(4,8).setSpan(1, 1);//fim botoes
		GBC gbc7 = new GBC(1,3).setSpan(6, 3);
		pnProd.add(lbCod, gbc1);
		pnProd.add(txCod, gbc2);
		pnProd.add(btList, gbc3);
		pnProd.add(btNovo, gbc4);
		//pnProd.add(btAlt, gbc5);
		pnProd.add(btRemove, gbc5);
		pnProd.add(scroll, gbc7);
		pnProd.add(btbuscar,gbc8);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Produtos");
		pnProd.setBorder(border);
		//configurePnBot();
	
		
		super.setSize(200, 300);
		super.setContentPane(pnProd);
		super.setVisible(true);
		super.pack();
		//super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	//botao listar todos
	private void configureBtListar(){
		ActionListener lstAutenticacao = new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				try {
					JButtomListarProdutoActionPerfomed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		
		btList.addActionListener(lstAutenticacao);
	}

			
			private void JButtomListarProdutoActionPerfomed(java.awt.event.ActionEvent evt) throws Exception{
				//dar uma olhada nesse for 
				model.setColumnIdentifiers(new String[]{"cod","nome","saldo","cod_barras"});
				this.newList = controller.listarTodos();
				for(int i = 0; i< newList.size(); i++){
					model.addRow(new Object[]{this.newList.get(i).getCod(), this.newList.get(i).getNome(),this.newList.get(i).getSaldo(), this.newList.get(i).getCod_Barras()});
				}
				
			}
			
			//botao Inserir(novo)
			private void configureBtInserir(){
				ActionListener lstAutenticacao = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							JButtomInserirProdutoActionPerfomed(e);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				};
				
				btNovo.addActionListener(lstAutenticacao);
			}

			
			
			private void JButtomInserirProdutoActionPerfomed(java.awt.event.ActionEvent evt) throws Exception{
				telaCadastroProduto cadPod = new telaCadastroProduto();
				
				cadPod.init();
			}
			
			
			//botao remover
			private void configureBtRemover(){
				ActionListener lstAutenticacao = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButtomRemoverProdutoActionPerfomed(e);
					}
				};
				
				btRemove.addActionListener(lstAutenticacao);
			}

			
			
			private void JButtomRemoverProdutoActionPerfomed(java.awt.event.ActionEvent evt){
				
				
				try{
					
					//this.newList.get(table.getSelectedRow()) serve para pegar um dos clientes que foi listado da jtable
				controller.remover(this.newList.get(table.getSelectedRow()));
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
			
			//testando busca
			//listar clientes
				public ArrayList <Produto> busca() throws Exception{
					

					if (txCod.getText().trim().equals("")){
						JOptionPane.showMessageDialog(null, "campos vazios!");
						throw new Exception("Campos vazios");
					}
					
					//abrindo conexao
					Statement conex = conectar.conectar();
					ArrayList<Produto> retorno = new ArrayList<Produto>();
					
					String sql = "SELECT cod, nome, saldo, cod_barras FROM produto WHERE cod = '" + txCod.getText() + "'";
					try{
						ResultSet rs = conex.executeQuery(sql);
						while(rs.next()){
						
							Produto produto = new Produto();
							produto.setCod(rs.getInt("cod"));
							produto.setNome(rs.getString("nome"));
							produto.setSaldo(rs.getInt("saldo"));
							produto.setCod_Barras(rs.getString("cod_barras"));
							retorno.add(produto);
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
								JButtomBuscarActionPerfomed(e);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					};
					
					btbuscar.addActionListener(lstAutenticacao);
				}

				
				
				private void JButtomBuscarActionPerfomed(java.awt.event.ActionEvent evt) throws Exception{
					
					model.setColumnIdentifiers(new String[]{"Cod","Nome","Saldo","Código de Barras"});
					this.newList = busca();
					for(int i = 0; i< newList.size(); i++){
						model.addRow(new Object[]{this.newList.get(i).getCod(), this.newList.get(i).getNome(),this.newList.get(i).getSaldo(), this.newList.get(i).getCod_Barras()});
					}
					
				}
			
}
