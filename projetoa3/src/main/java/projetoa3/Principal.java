package projetoa3;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ClienteDao servico = new ClienteDao();
		 String menu = "1-Cadastro cliente\n2-Cadastro Funcionário\n3-Solicitar Serviço\n4-Gerar Nota fiscal\n0-Sair";
		 int op;
	     do{
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (op){
                case 1:
                	
                	String idcliente = JOptionPane.showInputDialog("ID do cliente:");
                	String nome = JOptionPane.showInputDialog("Nome completo?");
                	String cpf = JOptionPane.showInputDialog("CPF? ");
                	String telefone = JOptionPane.showInputDialog("Telefone?");
                	String endereco = JOptionPane.showInputDialog("Endereço?");
                	Cliente p = new Cliente(idcliente, nome, cpf, telefone, endereco);
                	servico.inserir(p);
                	break;
                case 2:
                	String idprestador = JOptionPane.showInputDialog("ID do prestador:");
                	String nomeprestador = JOptionPane.showInputDialog("Nome completo?");
                	String cpfprestador = JOptionPane.showInputDialog("CPF?");
                	String tipo_de_servico = JOptionPane.showInputDialog("Qual serviço irá realizar?");
                	String carga_horaria = JOptionPane.showInputDialog("Qual a carga horária?");
                	Prestador o = new Prestador(idprestador, nomeprestador, cpfprestador, tipo_de_servico, carga_horaria);
                	servico.adicionar(o);
                	break;
                case 3:
                	String idsolicitacao = JOptionPane.showInputDialog("ID da solicitação:");
                	String tipo_de_trabalho = JOptionPane.showInputDialog("Tarefa necessária?:");
                	String descricao_do_servico = JOptionPane.showInputDialog("Descreva a tarefa:");
                	String localizacao = JOptionPane.showInputDialog("Endereço?");
                	String valor_mao_de_obra = JOptionPane.showInputDialog("Valor mão de obra?");
                	String valor_materiais = JOptionPane.showInputDialog("Valor materiais?");
                	String valor_total = JOptionPane.showInputDialog("Valor total?");
                	Solicitar_servico i = new Solicitar_servico(idsolicitacao, tipo_de_trabalho, descricao_do_servico, localizacao, valor_mao_de_obra, valor_materiais, valor_total);
                	servico.solicitar(i);
                case 4: 
                        String idcliente1 = JOptionPane.showInputDialog("ID do Cliente?");
                        Cliente cliente = servico.buscarClientePorId(idcliente1);

                     
                        String idprestador1 = JOptionPane.showInputDialog("ID do Prestador?");
                        Prestador prestador = servico.buscarPrestadorPorId(idprestador1);

                        
                        String idsolicitacao1 = JOptionPane.showInputDialog("ID da Solicitação?");
                        Solicitar_servico solicitar_servico = servico.buscarServicoPorId(idsolicitacao1);

                    break;
                
	            case 0:
	                break;
                default:
	                JOptionPane.showMessageDialog(null, "Opção inválida");
	            }
	        }while (op != 0);
	    }
	}
