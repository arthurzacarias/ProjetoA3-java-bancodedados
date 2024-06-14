package projetoa3;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

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
	
	public Cliente buscarClientePorId(String idCliente) {
	    String sql = "SELECT * FROM cliente WHERE idcliente = ?;";
	    Cliente cliente = null;

	    ConnectionFactory factory = new ConnectionFactory();
	    try (Connection c = factory.obtemConexao()) {
	        PreparedStatement ps = c.prepareStatement(sql);
	        ps.setString(1, idCliente);

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                String nome = rs.getString("nome");
	                String cpf = rs.getString("cpf");
	                
	                // Debugging: Log the values retrieved from the database
	                System.out.println("Cliente: " + "\n" +
	                "Nome: " + nome + "\n" +
	                "Cpf: " + cpf );
	                
	                
	                if (nome == null) {
	                    nome = ""; // Evita que o nome seja null
	                }
	                cliente = new Cliente(nome, cpf);
	                cliente.setIdcliente(idCliente);
	            } else {
	                // Debugging: Log if no result was found
	                System.out.println("Nenhum cliente encontrado com o id: " + idCliente);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return cliente;
	}

	public Prestador buscarPrestadorPorId(String idprestador) {
	    String sql = "SELECT * FROM prestador WHERE idprestador = ?;";
	    Prestador prestador = null;

	    ConnectionFactory factory = new ConnectionFactory();
	    try (Connection c = factory.obtemConexao()) {
	        PreparedStatement ps = c.prepareStatement(sql);
	        ps.setString(1, idprestador);

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                String nome = rs.getString("nome");
	                String cpf = rs.getString("cpf");
	                
	                // Debugging: Log the values retrieved from the database
	                System.out.println(
	                		"---------------------------------------------" + "\n" +
	                		"Prestador: " + "\n" +
	    	                "Nome: " + nome + "\n" +
	    	                "Cpf: " + cpf );
	                
	                if (nome == null) {
	                    nome = ""; // Evita que o nome seja null
	                }
	                prestador = new Prestador(nome, cpf);
	                prestador.setIdprestador(idprestador);
	            } else {
	                // Debugging: Log if no result was found
	                System.out.println("Nenhum cliente encontrado com o id: " + idprestador);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return prestador;
	}
     
    public Solicitar_servico buscarServicoPorId(String idsolicitacao) {
    	String sql = "SELECT * FROM solicitar_servico WHERE idsolicitacao = ?;";
	    Solicitar_servico solicitar_servico = null;

	    ConnectionFactory factory = new ConnectionFactory();
	    try (Connection c = factory.obtemConexao()) {
	        PreparedStatement ps = c.prepareStatement(sql);
	        ps.setString(1, idsolicitacao);

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                String tipo_de_trabalho = rs.getString("tipo_de_trabalho");
	                String localizacao = rs.getString("localizacao");
	                String valor_mao_de_obra = rs.getString("valor_mao_de_obra");
	                String valor_materiais = rs.getString("valor_materiais");
	                String valor_total = rs.getString("valor_total");
	                
	                // Debugging: Log the values retrieved from the database
	              
	                System.out.println(
	                		"---------------------------------------------" + "\n" +
	                		"Serviço: " + "\n" +
	    	                "Tipo de trabalho: " + tipo_de_trabalho + "\n" +
	    	                "Endereço: " + localizacao + "\n" +
	    	                "Valor Mão de Obra: " + valor_mao_de_obra + "\n" +
	    	                "Valor dos materiais: " + valor_materiais + "\n" +
	    	                "Valor total: " + valor_total 
	    	                );
	                
	                
	                if (tipo_de_trabalho == null) {
	                	tipo_de_trabalho = ""; // Evita que o nome seja null
	                }
	                solicitar_servico = new Solicitar_servico(tipo_de_trabalho, localizacao, valor_mao_de_obra, valor_materiais, valor_total);
	                solicitar_servico.setIdsolicitacao(idsolicitacao);
	            } else {
	                // Debugging: Log if no result was found
	                System.out.println("Nenhum cliente encontrado com o id: " + idsolicitacao);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return solicitar_servico;
	}
    
}