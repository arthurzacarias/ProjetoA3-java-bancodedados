package projetoa3;

public class Prestador {

	private String idprestador;
	private String nomeprestador;
	private String cpfprestador;
	private String tipo_de_servico;
	private String carga_horaria;
	
	public Prestador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Prestador(String idprestador, String nome, String cpf, String tipo_de_servico, String carga_horaria) {
		super();
		this.idprestador = idprestador;
		this.nomeprestador = nome;
		this.cpfprestador = cpf;
		this.tipo_de_servico = tipo_de_servico;
		this.carga_horaria = carga_horaria;
	}

	public Prestador(String nome, String cpf) {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getIdprestador() {
		return idprestador;
	}

	public void setIdprestador(String idprestador) {
		this.idprestador = idprestador;
	}

	public String getNome() {
		return nomeprestador;
	}

	public void setNome(String nome) {
		this.nomeprestador = nome;
	}

	public String getCpf() {
		return cpfprestador;
	}

	public void setCpf(String cpf) {
		this.cpfprestador = cpf;
	}

	public String getTipo_de_servico() {
		return tipo_de_servico;
	}

	public void setTipo_de_servico(String tipo_de_servico) {
		this.tipo_de_servico = tipo_de_servico;
	}

	public String getCarga_horaria() {
		return carga_horaria;
	}

	public void setCarga_horaria(String carga_horaria) {
		this.carga_horaria = carga_horaria;
	}

	
	
	
	
}
