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

import trabalhoBD.controller.produtoController;
import trabalhoBD.dao.Conexao;
import trabalhoBD.model.Produto;

public class telaEntradaEstoque extends JFrame {
	private produtoController controller;
	private ArrayList<Produto> newList = new ArrayList<Produto>();
	private Conexao conectar;
	
	private JLabel lbCod = new JLabel("ID do Produto(Desejado):");
	private JLabel lbQuantidade = new JLabel("Quantidade :");
	
	private JTextField txCod = new JTextField(10);
	private JTextField txQuantidade = new JTextField(20);
	
	private JPanel pnBase = new JPanel();
	private JPanel pnBot = new JPanel();
	private JPanel pnMain = new JPanel();
	
	private JButton btSalvar = new JButton("Atualizar");
	private JButton btCancelar = new JButton("Cancelar");
	
	
	public telaEntradaEstoque(){
		this.controller = controller;
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
		GBC gbc11 = new GBC(2,6);
		pnMain.add(pnBase,gbc10);
		pnMain.add(pnBot,gbc11);
		
		super.setTitle("Estoque");
		super.setContentPane(pnMain);
		super.setVisible(true);
		super.pack();
		super.setPreferredSize(new Dimension(420,250));
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void configurePnBase(){
		
		GridBagLayout layoutData3 = new GridBagLayout();
		pnBase.setLayout(layoutData3);
		
		GBC gbc1 = new GBC(1,1).setSpan(1, 3);
		GBC gbc2 = new GBC(2,1).setSpan(1, 3);
		GBC gbc3 = new GBC(1,4).setSpan(1, 3);
		GBC gbc4 = new GBC(2,4).setSpan(1, 3);
		
		pnBase.add(lbCod,gbc1);
		pnBase.add(txCod,gbc2);
		pnBase.add(lbQuantidade,gbc3);
		pnBase.add(txQuantidade,gbc4);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Entrada de Estoque");
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
					estoque();
					clearFields();
				}
		
		//conexao
		public void estoque() throws Exception{
			
			if (txQuantidade.getText().trim().equals("")){
				JOptionPane.showMessageDialog(null, "campos vazios!");
				throw new Exception("Campos vazios");
			}
			
			Statement conex = conectar.conectar();
			
			String sql = "UPDATE produto SET saldo = saldo + '" + txQuantidade.getText() + "' " + " WHERE cod = '" + txCod.getText() + "'";
			//String sql2 = "UPDATE produto SET saldo = saldo + '" + 4 + "' " + " WHERE cod = '" + 4 + "'";
			try{
				conex.executeUpdate(sql);
			
				
			}catch(SQLException e){
				throw new Exception("Erro: " + e.getMessage());
			}
		}
		
		 public void clearFields() {
				txCod.setText("");
				txQuantidade.setText("");

			}
}
