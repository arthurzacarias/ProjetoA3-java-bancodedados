package projetoa3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private String usuario = "root";
    private String senha = "Art180207";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "projetoa3";

    public Connection obtemConexao() {
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://" + host + ":" + porta + "/" + bd +
                            "?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true",
                    usuario,
                    senha
            );
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public String getBd() {
		return bd;
	}

	public void setBd(String bd) {
		this.bd = bd;
	}

	
}