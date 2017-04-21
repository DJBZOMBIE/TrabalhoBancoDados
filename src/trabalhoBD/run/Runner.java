package trabalhoBD.run;

import trabalhoBD.view.tableFrame;
import trabalhoBD.view.telaAlterarCliente;
import trabalhoBD.view.telaAlterarProduto;
import trabalhoBD.view.telaCadastroCliente;
import trabalhoBD.view.telaCadastroProduto;
import trabalhoBD.view.telaCliente;
import trabalhoBD.view.telaPedido;
import trabalhoBD.view.telaPrincipal;
import trabalhoBD.view.telaProduto;

public class Runner {
	
	public static void main (String[] args){
		telaPrincipal screen = new telaPrincipal();
		telaCliente screen2 = new telaCliente();
		telaProduto screen3 = new telaProduto();
		telaPedido screen4 = new telaPedido();
		
		//==============
		telaCadastroCliente cli = new telaCadastroCliente();
		telaAlterarCliente cli2 = new telaAlterarCliente();
		telaCadastroProduto prod = new telaCadastroProduto();
		telaAlterarProduto prod2 = new telaAlterarProduto();
		screen2.init();
	}
}
