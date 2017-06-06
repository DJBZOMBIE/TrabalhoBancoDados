package trabalhoBD.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.table.DefaultTableModel;

import trabalhoBD.controller.clienteController;
import trabalhoBD.controller.pedidoController;
import trabalhoBD.dao.Conexao;
import trabalhoBD.dao.ItemControllerDao;
import trabalhoBD.model.Cliente;
import trabalhoBD.model.Item;
import trabalhoBD.model.Pedido;
import trabalhoBD.model.PedidoTableModel;
import trabalhoBD.model.Produto;
import trabalhoBD.model.ProdutoTableModel;
import trabalhoBD.model.itemTableModel;

public class telaPedido extends JFrame{
	
	private pedidoController controller = new pedidoController();
	private ItemControllerDao controller2 = new ItemControllerDao();
	
	private ArrayList<Pedido> newList = new ArrayList<Pedido>();
	private ArrayList<Item> newList2 = new ArrayList<Item>();
	private ArrayList<Cliente> newListCli = new ArrayList<Cliente>();
	private Conexao conectar;
	private PedidoTableModel model = new PedidoTableModel(newList);
	
	private itemTableModel model2 = new itemTableModel(newList2);
	
	private JTable table = new JTable(model);
	private JTable table2 = new JTable(model2);
	private JLabel lbBuscar = new JLabel("Verificar itens do Pedido (ID):");
	private JLabel lbBuscarP = new JLabel("Buscar Pedido (ID):");
	
	private JTextField txPesquisa = new JTextField();
	private JTextField txPesquisaP = new JTextField();
	private JPanel pnBase = new JPanel();
	private JPanel pnTab = new JPanel();
	private JPanel pnTab2 = new JPanel();
	private JButton btbuscar = new JButton("Verificar");
	private JButton btList = new JButton("Listar");
	private JButton btNovo = new JButton("Novo");
	private JButton btRemove = new JButton("Remover");
	private JButton btBuscarP = new JButton("Buscar");
	private JButton btRemoveItem = new JButton("Remover Item");
	
	public telaPedido(){
		this.controller = controller;
		this.conectar = new Conexao();
	}
	
	public void init(){
		
		congifurepnTab();
		congifurepnTab2();
		configureBtListar();
		configureBtInserir();
		configureBtRemover();
		configureDetalhesPedido();
		configureBtBuscar();
		configureBtRemoverItem();
		//mouseEventTable();
		GridBagLayout layoutData = new GridBagLayout();
		pnBase.setLayout(layoutData);
		
		GBC gbc10 = new GBC(1,1);
		GBC gbc11 = new GBC(5,1);
		pnBase.add(pnTab,gbc11);
		pnBase.add(pnTab2,gbc10);
		
		 setResizable(false);
		    setLocationRelativeTo(null);
		    pegarResolucao();   
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
		super.setTitle("Tela Pedidos");
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
		super.setLocationRelativeTo(null);
		//super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void pegarResolucao() {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension dimensao = t.getScreenSize();
        this.setSize((dimensao.width + 5), (dimensao.height - 38));

 }
	public void congifurepnTab2(){
		
		JScrollPane scroll = new JScrollPane(table);
		GridBagLayout layoutData = new GridBagLayout();
		pnTab2.setLayout(layoutData);
		GBC gbc1 = new GBC(3,8).setSpan(1, 1);
		GBC gbc2 = new GBC(6,8).setSpan(1, 1);
		GBC gbc8 = new GBC(4,8).setSpan(1, 1);
		GBC gbc3 = new GBC(2,6).setSpan(1, 1);//botoes
		GBC gbc4 = new GBC(3,6).setSpan(1, 1);
		GBC gbc6 = new GBC(4,6).setSpan(1, 1);//fim botoes
		GBC gbc7 = new GBC(1,3).setSpan(6, 1);
		GBC gbc9 = new GBC(1,1).setSpan(1, 1);
		GBC gbc10 = new GBC(2,1).setSpan(1, 1);
		GBC gbc11 = new GBC(3,1).setSpan(1, 1);
		//GBC gbc10 = new GBC(2,7);
		
		//pnTab2.add(pnTab,gbc10);
		//pnTab2.add(lbCod, gbc1);
		//pnTab2.add(txCod, gbc2);
		pnTab2.add(lbBuscar,gbc1);
		pnTab2.add(btbuscar,gbc2);
		pnTab2.add(txPesquisa,gbc8);
		pnTab2.add(btList, gbc3);
		pnTab2.add(btNovo, gbc4);
		pnTab2.add(btRemove, gbc6);
		pnTab2.add(scroll, gbc7);
		pnTab2.add(lbBuscarP,gbc9);
		pnTab2.add(txPesquisaP,gbc10);
		pnTab2.add(btBuscarP,gbc11);
		//pnTab2.add(btbuscar,gbc8);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Pedidos");
		pnTab2.setBorder(border);
		//configurePnBot();
		
		
		
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
		super.setContentPane(pnTab2);
		super.setVisible(true);
		super.pack();
		//super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void congifurepnTab(){
		JScrollPane scroll2 = new JScrollPane(table2);
		GridBagLayout layoutData2 = new GridBagLayout();
		pnTab.setLayout(layoutData2);
		GBC gbc9 = new GBC(1,8).setSpan(6, 3);
		GBC gbc = new GBC(3,12).setSpan(1, 1);
		pnTab.add(btRemoveItem,gbc);
		pnTab.add(scroll2,gbc9);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Itens do Pedido");
		pnTab.setBorder(border);
		
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
		//super.setTitle("Tela Cliente");
		super.setSize(300, 400);
		super.setContentPane(pnTab);
		super.setVisible(true);
		super.pack();
		//super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	//botao listar pedido
			private void configureBtListar(){
				ActionListener lstAutenticacao = new ActionListener() {
					@Override
					
					public void actionPerformed(ActionEvent e) {
						try {
							
							JButtomListarPedidoActionPerfomed(e);
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				};
				
				btList.addActionListener(lstAutenticacao);
			}

			
			
			private void JButtomListarPedidoActionPerfomed(java.awt.event.ActionEvent evt) throws Exception{
				//dar uma olhada nesse for 
				model.setColumnIdentifiers(new String[]{"Cod","Data","Código do Cliente"});
				this.newList = controller.listarTodos();
				for(int i = 0; i< newList.size(); i++){
					model.addRow(new Object[]{this.newList.get(i).getCod(), this.newList.get(i).getData(),this.newList.get(i).getCod_cliente()});
				}
				
			}
	
			
			
			//botao Inserir
			private void configureBtInserir(){
				ActionListener lstAutenticacao = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							JButtomInserirPedidoActionPerfomed(e);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				};
				
				btNovo.addActionListener(lstAutenticacao);
			}

			
			
			private void JButtomInserirPedidoActionPerfomed(java.awt.event.ActionEvent evt) throws Exception{
				telaCadastroPedido cadPed = new telaCadastroPedido();
				
				cadPed.init();
			}
	
	
			//botao remover pedido
			private void configureBtRemover(){
				ActionListener lstAutenticacao = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButtomRemoverPedidoActionPerfomed(e);
					}
				};
				
				btRemove.addActionListener(lstAutenticacao);
			}

			
			
			private void JButtomRemoverPedidoActionPerfomed(java.awt.event.ActionEvent evt){
				
				
				try{
					
					//this.newList.get(table.getSelectedRow()) serve para pegar um dos clientes que foi listado da jtable
				controller.remover(this.newList.get(table.getSelectedRow()));
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
			
		//botao removerItem
			private void configureBtRemoverItem(){
				ActionListener lstAutenticacao = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButtomRemoverItemActionPerfomed(e);
					}
				};
				
				btRemoveItem.addActionListener(lstAutenticacao);
			}

			
			
			private void JButtomRemoverItemActionPerfomed(java.awt.event.ActionEvent evt){
				
				
				try{
					//this.newList.get(table.getSelectedRow()) serve para pegar um dos clientes que foi listado da jtable
				controller2.remover(this.newList2.get(table2.getSelectedRow()));
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		
			//busca pedidos anteriores
			public ArrayList <Item> busca() throws Exception{
				

				if (txPesquisa .getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "campos vazios!");
					throw new Exception("Campos vazios");
				}
				
				//abrindo conexao
				Statement conex = conectar.conectar();
				ArrayList<Item> retorno = new ArrayList<Item>();
				
				String sql = "SELECT cod_pedido, cod_produto, quantidade, cod FROM Item WHERE cod_pedido = '" + txPesquisa.getText() + "'";
				try{
					ResultSet rs = conex.executeQuery(sql);
					while(rs.next()){
					
						Item item = new Item();
						item.setCod_pedido(rs.getInt("cod_pedido"));
						item.setCod_produto(rs.getInt("cod_produto"));
						item.setQuantidade(rs.getInt("quantidade"));
						item.setCod(rs.getInt("cod"));
						retorno.add(item);
					}
				}catch(SQLException e){
					throw new Exception("Erro ao executar consulta: " + e.getMessage());
				}
				

				conectar.desconectar();
				
				return retorno;	//retorna lista
			}
			
			
			//botao detalhes do pedido
			private void configureDetalhesPedido(){
				ActionListener lstAutenticacao = new ActionListener() {
					@Override
					
					public void actionPerformed(ActionEvent e) {
						try {
							JButtomDetalhesActionPerfomed(e);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				};
				
				btbuscar.addActionListener(lstAutenticacao);
			}

			
			
			private void JButtomDetalhesActionPerfomed(java.awt.event.ActionEvent evt) throws Exception{
				//dar uma olhada nesse for 
				model2.setColumnIdentifiers(new String[]{"cod_pedido","cod_produto","quantidade","cod"});
				this.newList2 = busca();
				for(int i = 0; i< newList2.size(); i++){
					model2.addRow(new Object[]{this.newList2.get(i).getCod_pedido(), this.newList2.get(i).getCod_produto(),this.newList2.get(i).getQuantidade(),this.newList2.get(i).getCod()});
				}
				
			}
			
			//buscar pedido

				public ArrayList <Pedido> buscaP() throws Exception{
					
					if (txPesquisaP.getText().trim().equals("")){
						JOptionPane.showMessageDialog(null, "Digite o código do pedido!");
						
					}
					
					
					//abrindo conexao
					Statement conex = conectar.conectar();
					ArrayList<Pedido> retorno = new ArrayList<Pedido>();
					
					String sql = "SELECT cod, data, cod_cliente FROM pedido WHERE cod = '" + txPesquisaP.getText() + "'";
					try{
						ResultSet rs = conex.executeQuery(sql);
						while(rs.next()){
						
							Pedido ped = new Pedido();
							ped.setCod(rs.getInt("cod"));
							ped.setData(rs.getDate("data"));
							ped.setCod_cliente(rs.getInt("cod_cliente"));
							retorno.add(ped);
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
					
					btBuscarP.addActionListener(lstAutenticacao);
				}

				
				
				private void JButtomListarBuscarActionPerfomed(java.awt.event.ActionEvent evt) throws Exception{
					//dar uma olhada nesse for 
					model.setColumnIdentifiers(new String[]{"cod","data","cod_cliente"});
					this.newList = buscaP();
					for(int i = 0; i< newList.size(); i++){
						model.addRow(new Object[]{this.newList.get(i).getCod(), this.newList.get(i).getData(), this.newList.get(i).getCod_cliente()});
					}
					
				}
		
}





