package projetoa3;


public class Cliente {

	private String idcliente;
	private String nome;
	private String cpf;
	private String telefone;
	private String endereco;
	
	
	public Cliente() {
		super();
		
	}
	
	public Cliente(String idcliente, String nome, String cpf, String telefone, String endereco
			) {
		super();
		this.idcliente = idcliente;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		
	}

	public Cliente(String nome, String cpf) {
		// TODO Auto-generated constructor stub
	}

	

	public String getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	
	
	
	
	
	
}