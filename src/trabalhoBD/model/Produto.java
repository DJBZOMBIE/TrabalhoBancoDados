package trabalhoBD.model;

public class Produto {
	
	private int cod;
	private String nome;
	private int saldo;
	private String cod_Barras;
	
	public String getCodigoBarras() {
		return cod_Barras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.cod_Barras = codigoBarras;
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
