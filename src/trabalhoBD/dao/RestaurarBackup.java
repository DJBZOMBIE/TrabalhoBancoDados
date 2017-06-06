package trabalhoBD.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class RestaurarBackup {
	JFileChooser open;
	final List<String> comandos = new ArrayList<String>();
	
	public void init() throws IOException, InterruptedException{
		restaurarBKP();
	}
	
	public void restaurarBKP(){
		open = new JFileChooser(new File("G:\\TrabalhoBancoDados\\BKPCECOM\\"));
		int op = open.showOpenDialog(null);
		if(op == JFileChooser.APPROVE_OPTION){
			File arq = open.getSelectedFile();
			String nomeDoArquivo = open.getName(arq); //pega o nome do arquivo
			
			final List<String> comandos = new ArrayList<String>();
			comandos.add("C:\\Program Files\\PostgreSQL\\9.3\\bin\\pg_restore");
			
			comandos.add("-h");
			comandos.add("localhost");
			comandos.add("-p");
			comandos.add("5432");
			comandos.add("-U");
			comandos.add("postgres");
			comandos.add("-c");
			comandos.add("-d");
			comandos.add("loja");//nome do banco
			comandos.add("-v");
			
			comandos.add("G:\\TrabalhoBancoDados\\BKPCECOM\\"+nomeDoArquivo);
			ProcessBuilder pb = new ProcessBuilder(comandos);
			pb.environment().put("PGPASSWORD", "1234"); //senha do banco
			try{
				final Process process = pb.start();
				final BufferedReader r = new BufferedReader(new InputStreamReader(process.getErrorStream()));
				r.close();
				process.waitFor();
				process.destroy();
				
				JOptionPane.showMessageDialog(null, "Backup Restaurado");
			}catch(IOException e){
				e.printStackTrace();
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}else{
			
		}
	}
}
