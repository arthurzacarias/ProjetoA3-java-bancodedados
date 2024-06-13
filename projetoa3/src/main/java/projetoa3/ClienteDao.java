package projetoa3;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao {
	public void inserir (Cliente cliente){
		//1: Definir o comando SQL
		String sql = "INSERT INTO cliente(idcliente, nome, cpf, telefone, endereco) "
				+ "VALUES (?, ?, ?, ?, ?)";
		//2: Abrir uma conexao
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()){
			//3: Pre compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			//4: Preenche os dados 
			ps.setString(1, cliente.getIdcliente());
			ps.setString(2, cliente.getNome());
			ps.setString(3, cliente.getCpf());
			ps.setString(4, cliente.getTelefone());
			ps.setString(5, cliente.getEndereco());
			//5: Executa o comando
			ps.execute();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void adicionar (Prestador prestador){
		//1: Definir o comando SQL
		String sql = "INSERT INTO prestador(idprestador, nome, cpf, tipo_de_servico, carga_horaria) "
				+ "VALUES (?, ?, ?, ?, ?)";
		//2: Abrir uma conexao
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()){
			//3: Pre compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			//4: Preenche os dados 
			ps.setString(1, prestador.getIdprestador());
			ps.setString(2, prestador.getNome());
			ps.setString(3, prestador.getCpf());
			ps.setString(4, prestador.getTipo_de_servico());
			ps.setString(5, prestador.getCarga_horaria());
			//5: Executa o comando
			ps.execute();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void solicitar (Solicitar_servico solicitar_servico){
		//1: Definir o comando SQL
		String sql = "INSERT INTO solicitar_servico(idsolicitacao, tipo_de_trabalho, descricao_do_servico, localizacao, valor_mao_de_obra, valor_materiais, valor_total) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		//2: Abrir uma conexao
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()){
			//3: Pre compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			//4: Preenche os dados 
			ps.setString(1, solicitar_servico.getIdsolicitacao());
			ps.setString(2, solicitar_servico.getTipo_de_trabalho());
			ps.setString(3, solicitar_servico.getDescricao_do_servico());
			ps.setString(4, solicitar_servico.getLocalizacao());
			ps.setString(5, solicitar_servico.getValor_mao_de_obra());
			ps.setString(6, solicitar_servico.getValor_materiais());
			ps.setString(7, solicitar_servico.getValor_total());
			//5: Executa o comando
			ps.execute();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public Cliente buscarClientePorId(String idcliente) {
	    String sql = "SELECT * FROM cliente WHERE idcliente = ?;";
	    String nome = "";
	    String cpf = "";
	    // 2: Abrir uma conexão
	    ConnectionFactory factory = new ConnectionFactory();
	    try (Connection c = factory.obtemConexao()) {
	        // 3: Pré-compila o comando
	        PreparedStatement ps = c.prepareStatement(sql);
	        // 4: Preenche os dados faltantes
	        ps.setString(1, idcliente);
	        // 5: Executa o comando e guarda o resultado em um ResultSet
	        ResultSet rs = ps.executeQuery();
	        rs.next();
	        nome = rs.getString("nome");
	        cpf = rs.getString("cpf");
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    Cliente pessoa = new Cliente(nome, cpf);
	    pessoa.setIdcliente(idcliente);
	    return pessoa;
	}



    public Prestador buscarPrestadorPorId(int idprestador) throws SQLException {
        String sql = "SELECT nome, cpf FROM prestador WHERE idprestador = ?";
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, idprestador);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Prestador(rs.getString("nome"), rs.getString("cpf"));
            }
        }
        return null;
    }

    public Solicitar_servico buscarServicoPorId(int idsolicitacao) throws SQLException {
        String sql = "SELECT tipo_de_trabalho, localizacao, valor_mao_de_obra, valor_materiais, valor_total FROM solicitar_servico WHERE idsolicitacao = ?";
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, idsolicitacao);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Solicitar_servico(rs.getString("tipo_de_trabalho"), rs.getString("localizacao"),
                        rs.getString("valor_mao_de_obra"), rs.getString("valor_materiais"),
                        rs.getString("valor_total"));
            }
        }
        return null;
    }
	
	
}
