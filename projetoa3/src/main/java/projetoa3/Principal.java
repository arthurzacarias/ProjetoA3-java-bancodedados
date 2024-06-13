package projetoa3;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ClienteDao servico = new ClienteDao();
		 String menu = "1-Cadastro cliente\n2-Cadastro Funcionário\n3-Mostrar Clientes\n4-Mostrar Funcionários\n5-Solicitar Serviço\n6-Mostrar Solicitações\n7-Gerar Nota fiscal\n0-Sair";
		 int op;
	     do{
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (op){
                case 1:
                	
                	String idcliente = JOptionPane.showInputDialog("ID do cliente:");
                	String nome = JOptionPane.showInputDialog("Nome completo?");
                	String cpf = JOptionPane.showInputDialog("CPF? (Ex: 123.456.789-10)");
                	String telefone = JOptionPane.showInputDialog("Telefone? (Ex: 4191234-5678)");
                	String endereco = JOptionPane.showInputDialog("Endereço?");
                	Cliente p = new Cliente(idcliente, nome, cpf, telefone, endereco);
                	servico.inserir(p);
                	break;
                case 2:
                	String idprestador = JOptionPane.showInputDialog("ID do prestador:");
                	String nomeprestador = JOptionPane.showInputDialog("Nome completo?");
                	String cpfprestador = JOptionPane.showInputDialog("CPF? (apenas os números)");
                	String tipo_de_servico = JOptionPane.showInputDialog("Qual serviço irá realizar?");
                	String carga_horaria = JOptionPane.showInputDialog("Qual a carga horária?");
                	Prestador o = new Prestador(idprestador, nomeprestador, cpfprestador, tipo_de_servico, carga_horaria);
                	servico.adicionar(o);
                	break;
                case 3:
	                break;
                case 4:
	                break;
                case 5:
                	String idsolicitacao = JOptionPane.showInputDialog("ID da solicitação:");
                	String tipo_de_trabalho = JOptionPane.showInputDialog("Tarefa necessária?:");
                	String descricao_do_servico = JOptionPane.showInputDialog("Descreva a tarefa:");
                	String localizacao = JOptionPane.showInputDialog("Endereço?");
                	String valor_mao_de_obra = JOptionPane.showInputDialog("Valor mão de obra?");
                	String valor_materiais = JOptionPane.showInputDialog("Valor materiais?");
                	String valor_total = JOptionPane.showInputDialog("Valor total?");
                	Solicitar_servico i = new Solicitar_servico(idsolicitacao, tipo_de_trabalho, descricao_do_servico, localizacao, valor_mao_de_obra, valor_materiais, valor_total);
                	servico.solicitar(i);
	                break;
                case 6:
	                break;
                case 7:
                	try {
                        String idcliente1 = JOptionPane.showInputDialog("ID do Cliente?");
                        int idprestador1 = Integer.parseInt(JOptionPane.showInputDialog("ID do Prestador?"));
                        int idsolicitacao1 = Integer.parseInt(JOptionPane.showInputDialog("ID da Solicitação?"));

                        Cliente cliente = servico.buscarClientePorId(idcliente1);
                        Prestador prestador = servico.buscarPrestadorPorId(idprestador1);
                        Solicitar_servico solicitar_servico = servico.buscarServicoPorId(idsolicitacao1);

                        if (cliente != null && prestador != null && servico != null) {
                            // Monta a mensagem com os dados da nota fiscal
                            String mensagem = "Nota Fiscal:\n" +
                                    "Cliente: " + cliente.getNome() + " (" + cliente.getCpf() + ")\n" +
                                    "Prestador: " + prestador.getNome() + " (" + prestador.getCpf() + ")\n" +
                                    "Serviço:\n" +
                                    "Tipo de Trabalho: " + solicitar_servico.getTipo_de_trabalho() + "\n" +
                                    "Localização: " + solicitar_servico.getLocalizacao() + "\n" +
                                    "Valor Mão de Obra: " + solicitar_servico.getValor_mao_de_obra() + "\n" +
                                    "Valor Materiais: " + solicitar_servico.getValor_materiais() + "\n" +
                                    "Valor Total: " + solicitar_servico.getValor_total();

                            // Exibe a mensagem com os dados da nota fiscal
                            JOptionPane.showMessageDialog(null, mensagem);
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possível encontrar os dados para o ID informado.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "ID inválido.");
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + e.getMessage());
                    }
                
	                break;
	            case 0:
	                break;
                default:
	                JOptionPane.showMessageDialog(null, "Opção inválida");
	            }
	        }while (op != 0);
	    }
	}
