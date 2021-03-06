package trabalhoBD.view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import trabalhoBD.dao.Conexao;
import trabalhoBD.dao.usuariosControllerDao;
import trabalhoBD.model.Usuarios;
import trabalhoBD.model.UsuariosTableModel;

public class telaControleLogin extends JFrame{
	private usuariosControllerDao controller = new usuariosControllerDao();
	
	private ArrayList<Usuarios> newList = new ArrayList<Usuarios>();
	private UsuariosTableModel model = new UsuariosTableModel(newList);
	private Conexao conectar;
	private JTable table = new JTable(model); 
	private JPanel pnMain = new JPanel();
	private JPanel pnBase = new JPanel();
	private JButton pnListar = new JButton("Listar");
	private JButton pnCadastrar = new JButton("Cadastrar");
	private JButton pnAlterar = new JButton("Alterar");
	private JButton pnRemover = new JButton("Remover");
	
	public telaControleLogin(){
		this.conectar = new Conexao();
	}
	
	public void init(){
		configurePnBase();
		configureBtCadastrar();
		configureBtAlterar();
		configureBtRemover();
		configureBtListar();
		GridBagLayout layoutData = new GridBagLayout();
		pnMain.setLayout(layoutData);
		
		GBC gbc10 = new GBC(1,1);
		pnMain.add(pnBase,gbc10);
		
		super.setTitle("Tela Controle Login");
		super.setSize(200, 300);
		super.setContentPane(pnMain);
		super.setVisible(true);
		super.pack();
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void configurePnBase(){
		JScrollPane scroll = new JScrollPane(table);
		GridBagLayout layoutData = new GridBagLayout();
		pnBase.setLayout(layoutData);
		
		GBC gbc1 = new GBC(1,7).setSpan(1, 1);
		GBC gbc2 = new GBC(2,7).setSpan(1, 1);
		GBC gbc3 = new GBC(3,7).setSpan(1, 1);
		GBC gbc4= new GBC(4,7).setSpan(1, 1);
		GBC gbc7 = new GBC(1,3).setSpan(6, 3);
		
		pnBase.add(pnListar, gbc1);
		pnBase.add(pnCadastrar, gbc2);
		pnBase.add(pnAlterar, gbc3);
		pnBase.add(pnRemover, gbc4);
		pnBase.add(scroll, gbc7);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Controle de Login");
		pnBase.setBorder(border);
		
		super.setSize(200, 300);
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
	}
	
	//botao cadastrar
	private void configureBtCadastrar(){
		ActionListener lstAutenticacao = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					JButtomInserirUsuarioActionPerfomed(e);
				}catch(Exception e1){
					e1.printStackTrace();
				}
				
			}
		};
		pnCadastrar.addActionListener(lstAutenticacao);
	}
	
	private void JButtomInserirUsuarioActionPerfomed(java.awt.event.ActionEvent evt) throws Exception{
		telaCadastroUsuario cadLog = new telaCadastroUsuario();
		
		cadLog.init();
	}
	
	//botao alterar
		private void configureBtAlterar(){
			ActionListener lstAutenticacao = new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					try{
						JButtomCancelarLoginActionPerfomed(e);
					}catch(Exception e1){
						e1.printStackTrace();
					}
					
				}
			};
			pnAlterar.addActionListener(lstAutenticacao);
		}
		
		private void JButtomCancelarLoginActionPerfomed(java.awt.event.ActionEvent evt) throws Exception{
			telaAlterarLogin altLog = new telaAlterarLogin();
			
			altLog.init();
		}
		
		//botao remover
				private void configureBtRemover(){
					ActionListener lstAutenticacao = new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							JButtomRemoverFuncActionPerfomed(e);
						}
					};
					
					pnRemover.addActionListener(lstAutenticacao);
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
					
					pnListar.addActionListener(lstAutenticacao);
				}
				private void JButtomListarFuncActionPerfomed(java.awt.event.ActionEvent evt) throws Exception{
					//dar uma olhada nesse for 
					model.setColumnIdentifiers(new String[]{"Cod","Nome","Senha","Tipo"});
					this.newList = controller.listarTodos();
					for(int i = 0; i< newList.size(); i++){
						model.addRow(new Object[]{this.newList.get(i).getCod(), this.newList.get(i).getNome(),this.newList.get(i).getSenha(), this.newList.get(i).getTipo()});
					}
					
				}
		
				
}				
