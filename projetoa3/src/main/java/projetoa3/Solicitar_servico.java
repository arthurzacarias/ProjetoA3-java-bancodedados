package projetoa3;

public class Solicitar_servico {
	
	private String idsolicitacao;
	private String tipo_de_trabalho;
	private String descricao_do_servico;
	private String localizacao;
	private String valor_mao_de_obra;
	private String valor_materiais;
	private String valor_total;
	
	public Solicitar_servico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Solicitar_servico(String idsolicitacao, String tipo_de_trabalho, String descricao_do_servico,
			String localizacao, String valor_mao_de_obra, String valor_materiais, String valor_total) {
		super();
		this.idsolicitacao = idsolicitacao;
		this.tipo_de_trabalho = tipo_de_trabalho;
		this.descricao_do_servico = descricao_do_servico;
		this.localizacao = localizacao;
		this.valor_mao_de_obra = valor_mao_de_obra;
		this.valor_materiais = valor_materiais;
		this.valor_total = valor_total;
	}


	public Solicitar_servico(String tipo_de_trabalho, String localizacao, String valor_mao_de_obra, String valor_materiais, String valor_total) {
		// TODO Auto-generated constructor stub
	}

	public String getIdsolicitacao() {
		return idsolicitacao;
	}

	public void setIdsolicitacao(String idsolicitacao) {
		this.idsolicitacao = idsolicitacao;
	}

	public String getTipo_de_trabalho() {
		return tipo_de_trabalho;
	}

	public void setTipo_de_trabalho(String tipo_de_trabalho) {
		this.tipo_de_trabalho = tipo_de_trabalho;
	}

	public String getDescricao_do_servico() {
		return descricao_do_servico;
	}

	public void setDescricao_do_servico(String descricao_do_servico) {
		this.descricao_do_servico = descricao_do_servico;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getValor_mao_de_obra() {
		return valor_mao_de_obra;
	}

	public void setValor_mao_de_obra(String valor_mao_de_obra) {
		this.valor_mao_de_obra = valor_mao_de_obra;
	}

	public String getValor_materiais() {
		return valor_materiais;
	}

	public void setValor_materiais(String valor_materiais) {
		this.valor_materiais = valor_materiais;
	}

	public String getValor_total() {
		return valor_total;
	}

	public void setValor_total(String valor_total) {
		this.valor_total = valor_total;
	}
	
	
	
	
	
	

}
