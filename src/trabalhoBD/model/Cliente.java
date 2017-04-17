package trabalhoBD.model;

public class Cliente {
	private int cod;
	private String nome;
	private String email;
	private String cpf;
	
	public Cliente(int string, String string2, String string3, String string4) {
		this.cod = string;
		this.nome = string2;
		this.cpf = string3;
		this.email = string4;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int code) {
		this.cod = code;
	}
	public String getNome() {
		return nome;
	}
	public void setNnome(String name) {
		this.nome = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return cod + " - " + nome + " - " + cpf + " - " + email;
	}
}
