package model;

public class Cliente {
	private String idcli;
	private String nome;
	private String email;
	private String senha;
	
	public Cliente(String idcli, String nome, String email, String senha) {
		super();
		this.idcli = idcli;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public Cliente() {
		super();
	}



	public String getIdcli() {
		return idcli;
	}
	public void setIdcli(String idcli) {
		this.idcli = idcli;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
