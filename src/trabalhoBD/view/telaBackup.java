package trabalhoBD.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;

import trabalhoBD.dao.Conexao;
import trabalhoBD.dao.RealizaBackup;
import trabalhoBD.dao.RestaurarBackup;

public class telaBackup  extends JFrame{
	private Conexao conectar;
	
	private JPanel pnMain = new JPanel();
	private JPanel pnBase = new JPanel();
	
	private JButton btBakcup = new JButton("Realizar Backup");
	private JButton btRestaurar = new JButton("Restaurar Backup");
	private JButton btCancelar = new JButton("Cancelar");
	
	public telaBackup(){
		this.conectar = new Conexao();
	}
	
	public void init(){
		configurePnMain();
		configureBtCancelar();
		configureBtBackup();
		configureBtRestaurar();
		GridBagLayout layoutData = new GridBagLayout();
		pnMain.setLayout(layoutData);
		
		GBC gbc4 = new GBC(2,1);
		pnMain.add(pnBase,gbc4);
		
		super.setTitle("Controle de Backup");
		super.setContentPane(pnMain);
		super.setVisible(true);
		super.setPreferredSize(new Dimension(320,200));
		super.setLocationRelativeTo(null);
		super.pack();
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void configurePnMain(){
		GridBagLayout layoutData3 = new GridBagLayout();
		pnBase.setLayout(layoutData3);
		
		GBC gbc1 = new GBC(2,2).setSpan(1, 2);
		GBC gbc2 = new GBC(2,4).setSpan(1, 2);
		GBC gbc3 = new GBC(2,6).setSpan(1, 2);
		
		pnBase.add(btBakcup,gbc1);
		pnBase.add(btRestaurar,gbc2);
		pnBase.add(btCancelar,gbc3);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Tela de Backup");
		
		pnBase.setBorder(border);
		
		super.setSize(320, 200);
		super.setContentPane(pnBase);
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
	
	//botao backup
		private void configureBtBackup(){
			ActionListener lstAutenticacao = new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						JButtonBackupActionPerformed(e);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			};
			btBakcup.addActionListener(lstAutenticacao);
		}
		
		private void JButtonBackupActionPerformed(java.awt.event.ActionEvent evt) throws Exception{
			RealizaBackup bc = new RealizaBackup();
			bc.init();
		}
		
	//botao restaurar backup
		private void configureBtRestaurar(){
			ActionListener lstAutenticacao = new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						JButtonRestaurarBackupActionPerformed(e);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			};
			btRestaurar.addActionListener(lstAutenticacao);
		}
		
		private void JButtonRestaurarBackupActionPerformed(java.awt.event.ActionEvent evt) throws Exception{
			RestaurarBackup rbc = new RestaurarBackup();
			rbc.init();
		}
		
}
