package trabalhoBD.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import trabalhoBD.controller.clienteController;
import trabalhoBD.controller.pedidoController;
import trabalhoBD.dao.Conexao;
import trabalhoBD.model.Cliente;
import trabalhoBD.model.Item;
import trabalhoBD.model.Pedido;
import trabalhoBD.model.PedidoTableModel;
import trabalhoBD.model.Produto;
import trabalhoBD.model.itemTableModel;

public class telaCadastroPedido extends JFrame{
	private clienteController controller2 = new clienteController();
	private pedidoController controller = new pedidoController();
	private ArrayList<Pedido> newList = new ArrayList<Pedido>();
	private ArrayList<Item> newList2 = new ArrayList<Item>();
	private ArrayList<Cliente> newListCli = new ArrayList<Cliente>();
	
	private Conexao conectar;
	/*private PedidoTableModel model = new PedidoTableModel(newList);
	
	private itemTableModel model2 = new itemTableModel(newList2);
	
	private JTable table2 = new JTable(model2); /*table de itens*/
	private JLabel lbCod = new JLabel("Número (ID):");
	private JLabel lbNome = new JLabel("Data (A/M/D):");
	private JLabel CodCLI = new JLabel("Código do Cliente:");
	
	
	private JTextField txCod = new JTextField(10);
	private JTextField txData = new JTextField(20);
	private JTextField txCodCLI = new JTextField(10);

	
	//private JLabel lbPreco = new JLabel("Preço:");
	private JLabel lbQuantidade = new JLabel("Quantidade:");
	private JLabel CodCodPedido = new JLabel("Código do Pedido:");
	private JLabel lbCodProd = new JLabel("Código do Produto:");
	
	//private JTextField txPreco = new JTextField(10);
	private JTextField txQuantidade = new JTextField(20);
	private JTextField txCodPedido = new JTextField(10);
	private JTextField txCodProd = new JTextField(20);
	
	private JButton btSalvar = new JButton("Salvar");
	private JButton btCancelar = new JButton("Cancelar");
	private JButton btSalvarI = new JButton("Salvar");
	
	private JPanel pnMain = new JPanel();
	private JPanel pnItem = new JPanel();
	private JPanel pnBase = new JPanel();
	private JPanel pnBot = new JPanel();
	
	
	public telaCadastroPedido(){
		this.conectar = new Conexao();
		
		
	}
	
	
	public void init(){
		
		configurePnBase();
		configurePnItem();
		configurePnBotao(); 
		configureBtSalvar();
		configureBtCancelar();
		configureBtSalvar2();
		GridBagLayout layoutData = new GridBagLayout();
		pnMain.setLayout(layoutData);
		
		GBC gbc10 = new GBC(2,2);
		GBC gbc11 = new GBC(2,10);
		GBC gbc12 = new GBC(2,12);
		
		pnMain.add(pnBase,gbc10);
		pnMain.add(pnItem,gbc12);
		pnMain.add(pnBot,gbc11);
		
		super.setContentPane(pnMain);
		super.setTitle("Cadastro de Pedido");
		super.setVisible(true);
		//super.setPreferredSize(new Dimension(420,250));
		super.setLocationRelativeTo(null);
		super.pack();
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	public void configurePnBase(){
		
		GridBagLayout layoutData3 = new GridBagLayout();
		pnBase.setLayout(layoutData3);
		
		GBC gbc1 = new GBC(1,1).setSpan(1, 2);
		GBC gbc2 = new GBC(2,1).setSpan(1, 2);
		GBC gbc3 = new GBC(3,1).setSpan(1, 2);
		GBC gbc4 = new GBC(4,1).setSpan(1, 2);
		
		GBC gbc5 = new GBC(1,4).setSpan(1, 2);
		GBC gbc6 = new GBC(2,4).setSpan(1, 2);
		//GBC gbc7 = new GBC(3,5).setSpan(1, 2);
		GBC gbc8 = new GBC(4,4).setSpan(1, 2);
		
		GBC gbc9 = new GBC(3,5).setSpan(1, 1);
		GBC gbc10 = new GBC(4,5).setSpan(1, 1);
		
		pnBot.add(btSalvar,gbc9);
		pnBot.add(btCancelar,gbc10);
		
		pnBase.add(lbCod,gbc1);
		pnBase.add(txCod,gbc2);
		pnBase.add(lbNome,gbc3);
		pnBase.add(txData,gbc4);
		pnBase.add(CodCLI,gbc5);
		pnBase.add(txCodCLI,gbc6);
		
		//pnBase.add(lbCodProd,gbc7);
		//pnBase.add(txCodItem,gbc8);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Cadastro de Pedidos");
		pnBase.setBorder(border);
		
		super.setSize(400, 300);
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
	}

	public void configurePnItem(){
		
		GridBagLayout layoutData4 = new GridBagLayout();
		pnItem.setLayout(layoutData4);
		
		GBC gbc1 = new GBC(1,5).setSpan(1, 2);
		GBC gbc2 = new GBC(2,5).setSpan(1, 2);
		GBC gbc3 = new GBC(3,5).setSpan(1, 2);
		GBC gbc4 = new GBC(4,5).setSpan(1, 2);
		
		GBC gbc5 = new GBC(1,7).setSpan(1, 2);
		GBC gbc6 = new GBC(2,7).setSpan(1, 2);
		GBC gbc7 = new GBC(4,8).setSpan(1, 1);
		GBC gbc8 = new GBC(4,8).setSpan(1, 1);

		pnItem.add(lbQuantidade,gbc3);
		pnItem.add(txQuantidade,gbc4);
		pnItem.add(CodCodPedido,gbc1);
		pnItem.add(txCodPedido,gbc2);
		pnItem.add(lbCodProd,gbc5);
		pnItem.add(txCodProd,gbc6);
		pnItem.add(btSalvarI,gbc7);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Itens do Pedido");
		pnItem.setBorder(border);
		
		super.setSize(400, 300);
		super.setContentPane(pnItem);
		super.setVisible(true);
		super.pack();
	}
	
	public void configurePnBotao(){
		GridBagLayout layoutData2 = new GridBagLayout();
		pnBot.setLayout(layoutData2);
		
		GBC gbc9 = new GBC(3,12).setSpan(1, 1);
		GBC gbc10 = new GBC(4,12).setSpan(1, 1);
		
		pnBot.add(btSalvar,gbc9);
		pnBot.add(btCancelar,gbc10);
		
		super.setContentPane(pnBot);
		super.setVisible(true);
		super.pack();
	}
	
	
	public void gambiarra() throws Exception{
		//Produto produto = new Produto();
		
		if (txCodCLI.getText().trim().equals("")){
			JOptionPane.showMessageDialog(null, "campo cod_cliente vazio!");
			throw new Exception("Campos vazios");
		}
		
		if (txData.getText().trim().equals("")){
			JOptionPane.showMessageDialog(null, "campo data vazio!");
			throw new Exception("Campos vazios");
		}
		
		if (txCod.getText().trim().equals("")){
			JOptionPane.showMessageDialog(null, "campo numero vazio!");
			throw new Exception("Campos vazios");
		}
		
	
		
			Statement conex = conectar.conectar();
		
			String sql2 = "INSERT INTO pedido(cod, data, cod_cliente)";sql2 += "VALUES('" + txCod.getText() + "', '" + txData.getText() + "', '" + txCodCLI.getText()+"')";
			
			
			try{
			conex.execute(sql2);
		
			JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso! " );
			}catch(SQLException e){
			throw new Exception("Erro: " + e.getMessage());
		}
			conectar.desconectar();
	}
	
	
	//botao salvar
	private void configureBtSalvar(){
		ActionListener lstAutenticacao = new ActionListener() {
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
	
	
	
	public void JButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) throws Exception{	
		gambiarra();
		clearFields();
	}
	
	
	 public void clearFields() {
		 	txCodCLI.setText("");
		 	txData.setText("");
		 	txCod.setText("");

		}
	
	
	
	public void gambiarra2() throws Exception{
		
		
		
		
		if (txQuantidade.getText().trim().equals("")){
			JOptionPane.showMessageDialog(null, "campo quantidade vazio!");
			throw new Exception("Campos vazios");
		}
		
		if (txCodPedido.getText().trim().equals("")){
			JOptionPane.showMessageDialog(null, "campo cod_pedido vazio!");
			throw new Exception("Campos vazios");
		}
		if (txCodProd.getText().trim().equals("")){
			JOptionPane.showMessageDialog(null, "campo cod_produto vazio!!");
			throw new Exception("Campos vazios");
		}
		
			Statement conex = conectar.conectar();
			
			
			String sql = "INSERT INTO item(cod_pedido, cod_produto, quantidade)";sql += "VALUES('"+ txCodPedido.getText() + "', '" + txCodProd.getText()+ "', '" + txQuantidade.getText()+ "')";
			String sql2 = "UPDATE produto SET saldo = saldo - '" + txQuantidade.getText() + "' " + " WHERE cod = '" + txCodProd.getText() + "'";
			
			try{
		
			conex.execute(sql);
			conex.executeUpdate(sql2);
			JOptionPane.showMessageDialog(null, "Itens do pedido cadastrado com sucesso! " );
			}catch(SQLException e){
			throw new Exception("Erro: " + e.getMessage());
		}
			conectar.desconectar();
	}
	
	
	
	
	//botao salvar
		private void configureBtSalvar2(){
			ActionListener lstAutenticacao = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						JButtonSalvar2ActionPerformed(e);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
				};
					btSalvarI.addActionListener(lstAutenticacao);
				}
		
		
		
		public void JButtonSalvar2ActionPerformed(java.awt.event.ActionEvent evt) throws Exception{	
			gambiarra2();
			clearFields2();
		}
	
	
	
		 public void clearFields2() {
			 	txQuantidade.setText("");
			 	txCodPedido.setText("");
			 	txCodProd.setText("");

			}
	
	
	
	
	
	//botao cancelar
			private void configureBtCancelar(){
				ActionListener lstAutenticacao = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButtonCancelarActionPerformed(e);
						}
					};
						btCancelar.addActionListener(lstAutenticacao);
					}
					
					public void JButtonCancelarActionPerformed(java.awt.event.ActionEvent evt){	
						this.dispose();
						
					}
	
}
