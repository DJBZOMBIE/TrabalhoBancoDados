package trabalhoBD.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class RealizaBackup {
	JFileChooser open;
	public RealizaBackup(){
		
	}
	public void init() throws IOException, InterruptedException{
		backup();
	}
	
	public void backup()throws IOException, InterruptedException{
		final List<String> comandos = new ArrayList<String>();
		String dir = "G:\\TrabalhoBancoDados\\BKPCECOM\\";
		
		List<String> lista = new ArrayList<String>(9); //guardar os nomes dos backups
		
		File diretorio = new File(dir); //passa o diretorio onde esta localizado a pasta de backup
		
		File fList[] = diretorio.listFiles(); //pega a lista de backups no diretorio e passa para o vetor
		
		if(fList.length == 0){
			comandos.add("C:\\Program Files\\PostgreSQL\\9.3\\bin\\pg_dump.exe"); //caminho  do dump do postgress
			
			comandos.add("-h");
			comandos.add("localhost");
			comandos.add("-p");
			comandos.add("5432"); //porta
			comandos.add("-U");
			comandos.add("postgres");
			comandos.add("-F");
			comandos.add("c");
			comandos.add("-b");
			comandos.add("-v");
			comandos.add("-f");
			
			comandos.add("G:\\TrabalhoBancoDados\\BKPCECOM\\"+1+" "+getDateTime()+".backup");
			comandos.add("loja");
			ProcessBuilder pb = new ProcessBuilder(comandos); //executado com a memoria do pc
			
			pb.environment().put("PGPASSWORD", "1234"); //senha do banco
			
			try{
				final Process process = pb.start();
				
				final BufferedReader r = new BufferedReader( //criar espaço na memoria pra executar
					new InputStreamReader(process.getErrorStream()));
				
				r.close();
				
				process.waitFor();
				process.destroy();
				JOptionPane.showMessageDialog(null, "Backup Realizado com sucesso!");
			}catch(IOException e){
				e.printStackTrace();
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}else{
			for(int i = 0; i < fList.length; i++){
				lista.add(fList[i].getName()); //verifica o numero do o ultimo backup feito
			}
			char recebe = Collections.max(lista).charAt(0);
			
			comandos.add("C:\\Program Files\\PostgreSQL\\9.3\\bin\\pg_dump.exe");
			comandos.add("-h");
			comandos.add("localhost");
			comandos.add("-p");
			comandos.add("5432"); //porta
			comandos.add("-U");
			comandos.add("postgres");
			comandos.add("-F");
			comandos.add("c");
			comandos.add("-b");
			comandos.add("-v");
			comandos.add("-f");
			
			comandos.add("G:\\TrabalhoBancoDados\\BKPCECOM\\"+(Character.getNumericValue(recebe)+1)+" "+getDateTime()+".backup");
			comandos.add("loja");
			ProcessBuilder pb = new ProcessBuilder(comandos);
			
			pb.environment().put("PGPASSWORD", "1234");
			
			try{
				final Process process = pb.start();
				
				final BufferedReader r = new BufferedReader( //criar espaço na memoria pra executar
					new InputStreamReader(process.getErrorStream()));
				
				r.close();
				
				process.waitFor();
				process.destroy();
				JOptionPane.showMessageDialog(null, "Backup Realizado com sucesso!");
			}catch(IOException e){
				e.printStackTrace();
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
	}
	
	private String getDateTime(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy HHmm");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
