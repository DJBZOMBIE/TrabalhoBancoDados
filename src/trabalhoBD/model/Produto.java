package trabalhoBD.model;

public class Produto {
	
	private int cod;
	private String nome;
	private int saldo;
	private String cod_Barras;
	
	

	public String getCod_Barras() {
		return cod_Barras;
	}
	public void setCod_Barras(String cod_Barras) {
		this.cod_Barras = cod_Barras;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
}
