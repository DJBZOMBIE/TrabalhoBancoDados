package trabalhoBD.run;

import trabalhoBD.view.telaCliente;
import trabalhoBD.view.telaPrincipal;

public class Runner {
	
	public static void main (String[] args){
		telaPrincipal screen = new telaPrincipal();
		telaCliente screen2 = new telaCliente();
		screen2.init();
	}
}
