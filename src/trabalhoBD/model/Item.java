package trabalhoBD.model;

public class Item {
	private int cod;
	private Produto cod_produto;
	private int quantidade;
	private int cod_pedido;
	private float preco;
	
	public Item (){
		this.cod_produto = new Produto();
	}
	
	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public Produto getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(Produto cod_produto) {
		this.cod_produto = cod_produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getCod_pedido() {
		return cod_pedido;
	}

	public void setCod_pedido(int cod_pedido) {
		this.cod_pedido = cod_pedido;
	}
	
}
