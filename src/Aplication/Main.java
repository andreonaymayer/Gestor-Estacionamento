package Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Entities.Carro;
import Entities.Moto;
import Entities.Patio;
import Entities.Registro;
import Entities.Veiculo;

public class Main {


	public static void main(String[] args) throws ParseException   {
		Scanner sc = new Scanner(System.in); //inicia entrada teclado
		
		SimpleDateFormat tipoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //define o tipo de data
		Date a = tipoData.parse("01/06/2021 15:00:00");
		Date b = tipoData.parse("31/06/2021 15:00:00");
		
		Patio patio; patio = new Patio(10,(double) 5.00,(double) 100.00); //instancia 		
				
		List <Registro> TbReg = new ArrayList<>(); //inicia a lista de registros
		List <Carro> TbCarro= new ArrayList<>(); //inicia a lista de Carros
		List <Moto> TbMoto= new ArrayList<>(); //inicia a lista de Motos
		
		//TbCarro.add(new Carro("Andreo","Legal", "ijaij","iii923"));

		for (Registro umdeles: TbReg) {
			System.out.println(umdeles);
		}
		
		//System.out.println(TbCarro);
		TbCarro.add(new Carro("Voyage", "VW", "Preta", "PLACAC"));
		TbMoto.add(new Moto("Voyage", "VW", "Preta", "PLACAM"));
		
		
		System.out.println("------ Menu Veiculos ------");
		System.out.print(" 1 - Cadastrar veiculo\n 2 - Editar Veiculo\n 3 - Sair\n :>");
		int escolha = sc.nextInt();
		switch (escolha) {
		case 1:
			System.out.println("------------------------");
			System.out.printf(" 1 - Cadastrar Carro;\n 2 - Cadastrar moto;\n 3 - Sair\n :>");
			escolha = sc.nextInt();sc.nextLine();
			switch (escolha) {
			case 1:
				
				System.out.print("> Insira a Placa do carro:"); String placa = sc.nextLine();
				if (pesquisaListaVeiculosIndex(TbCarro, placa)!=-1) {
					System.out.println("Placa já cadastrada como carro: "+TbCarro.get(pesquisaListaVeiculosIndex(TbCarro, placa)));
					break;
				}
				if (pesquisaListaVeiculosIndex(TbMoto, placa)!=-1) {
					System.out.println("Placa já cadastrada como Moto: "+TbMoto.get(pesquisaListaVeiculosIndex(TbMoto, placa)));
					break;
				}
				
				System.out.print("> Insira a marca do carro:"); String marca = sc.nextLine();
				System.out.print("> Insira a cor do carro:"); String cor = sc.nextLine();
				System.out.print("> Insira o nome do carro:"); String nome = sc.nextLine();
				
				TbCarro.add(new Carro(nome, marca, cor, placa));
				System.out.println("Veiculo: ("+ pesquisaListaVeiculos(TbCarro,placa) +") Cadastrado!");
				break;
			case 2:
				System.out.print("> Insira a Placa da moto:");  placa = sc.nextLine();
				if (pesquisaListaVeiculosIndex(TbCarro, placa)!=-1) {
					System.out.println("Placa já cadastrada como carro: "+TbCarro.get(pesquisaListaVeiculosIndex(TbCarro, placa)));
					break;
				}
				if (pesquisaListaVeiculosIndex(TbMoto, placa)!=-1) {
					System.out.println("Placa já cadastrada como Moto: "+TbMoto.get(pesquisaListaVeiculosIndex(TbMoto, placa)));
					break;
				}
				System.out.print("> Insira a marca da moto:");  marca = sc.nextLine();
				System.out.print("> Insira a cor da moto:");  cor = sc.nextLine();
				System.out.print("> Insira o nome da moto:"); nome = sc.nextLine();
				
				TbMoto.add(new Moto(nome, marca, cor, placa));
				System.out.println("Veiculo: ("+ pesquisaListaVeiculos(TbMoto,placa) +") Cadastrado!");
				break;
			case 3:
				System.out.println("Saindo...");
				break;

			default:
				System.out.println("Valor invalido.");
				break;
			}
			break;
		case 2:
			System.out.println("------------------------");
			System.out.printf(" 1 - Editar Carro;\n 2 - Editar moto;\n 3 - Sair\n :>");
			escolha = sc.nextInt();sc.nextLine();

			switch (escolha) {
			case 1:
				
				System.out.print("> Insira a Placa do carro:"); String placa = sc.nextLine();
				int indexInt = pesquisaListaVeiculosIndex(TbCarro, placa);
				if (indexInt != -1) {
					System.out.println("O que deseja editar:\n 1 - Nome\n 2 - Marca\n 3 - Cor\n 4 - Sair\n:>");
					escolha = sc.nextInt();sc.nextLine();
					System.out.print("Digite novo valor: ");
					String editado = sc.nextLine();
					switch (escolha) {
					case 1:
						TbCarro.get(indexInt).setNome(editado);
						break;
					case 2:
						TbCarro.get(indexInt).setMarca(editado);
						break;
					case 3:
						TbCarro.get(indexInt).setCor(editado);
						break;
					case 4:
						System.out.println("Saindo...");
						break;

					default:
						System.out.println("Valor invalido.");
						break;
					}
					
				}else {
					System.out.println("Placa :"+placa+" Não encontrada. Tente novamente");
					if (pesquisaListaVeiculosIndex(TbMoto, placa) != -1)
						System.out.println("A placa inserida ("+placa+"), esta cadastrada como uma moto.");
				}
					System.out.println("Registro atualizado: "+TbCarro.get(indexInt));
				break;
			case 2:
				System.out.print("> Insira a Placa da moto:");  placa = sc.nextLine();
				indexInt = pesquisaListaVeiculosIndex(TbMoto, placa);
				if (indexInt != -1) {
					System.out.println("O que deseja editar:\n 1 - Nome\n 2 - Marca\n 3 - Cor\n 4 - Sair\n:>");
					escolha = sc.nextInt();sc.nextLine();
					System.out.print("Digite novo valor: ");
					String editado = sc.nextLine();
					switch (escolha) {
					case 1:
						TbMoto.get(indexInt).setNome(editado);
						break;
					case 2:
						TbMoto.get(indexInt).setMarca(editado);
						break;
					case 3:
						TbMoto.get(indexInt).setCor(editado);
						break;
					case 4:
						System.out.println("Saindo...");
						break;

					default:
						System.out.println("Valor invalido.");
						break;
					}
					System.out.println("Registro atualizado: "+TbMoto.get(indexInt));
				}else {
					System.out.println("Placa :"+placa+" Não encontrada. Tente novamente");
					if (pesquisaListaVeiculosIndex(TbCarro, placa) != -1)
						System.out.println("A placa inserida ("+placa+"), esta cadastrada como um carro.");
				}
					
				break;
			case 3:
				System.out.println("Saindo...");
				break;

			default:
				System.out.println("Valor invalido.");
				break;
			}
			break;
		case 3:
			System.out.println("Saindo...");
			break;

		default:
			System.out.println("Opção invalida.");
			break;
		}
		
		
		
	}
	public void patioMenu (Patio patio, Scanner sc) {
		int escolha;
		System.out.printf("-- Informações de pátio --\n Vagas Totais:   %d   | Vagas disponíveis: %d"
				+"\n Valor hora: R$ %.2f | Valor Diaria(24h) R$ %.2f\n\n 1 - Editar\n 2 - Sair");
		escolha = sc.nextInt();
		switch (escolha) {
		case 1:
			System.out.println("--------  Editar patio --------");
			System.out.printf("\n 1 - Editar Vagas totais;\n 2 - Editar Valor Hora;\n 3 - Editar valor diaria;\n :>"
					,patio.getVagas(),patio.getVagasDisponiveis(),patio.getValorHora(),patio.getValorDiaria());
			escolha = sc.nextInt();
			switch (escolha) {
			case 1:
				System.out.printf("  Digite o novo valor de vagas totais: (Atual: %d)\n :>",patio.getVagas());
				int valor = sc.nextInt();
				if (valor < patio.getVagasOcupadas())
					while (valor < patio.getVagasOcupadas()) {
						System.out.printf("O valor de vagas não pode ser menor que as vagas já ocupadas (%d).\n Digite novamente: ",patio.getVagasOcupadas());
						valor = sc.nextInt();
					}
				patio.setVagas(valor);
				break;
			case 2: 
				System.out.printf("  Digite o novo valor da Hora (Atual: R$ %.2f): ",patio.getValorHora());
				valor = sc.nextInt();
				if (valor <= 0)
					while (valor <= 0) {
						System.out.println("O valor não pode ser menor ou igual a zero.\n Digite novamente: ");
						valor = sc.nextInt();
						patio.setValorHora(valor);
					}
				break;
			case 3: 
				System.out.printf("  Digite o novo valor da Diaria (Atual: R$ %.2f):",patio.getValorDiaria());
				valor = sc.nextInt();
				if (valor <= 0)
					while (valor <= 0) {
						System.out.println("O valor não pode ser menor ou igual a zero.\n Digite novamente: ");
						valor = sc.nextInt();
						patio.setValorHora(valor);
					}
				break;
			default:
				System.out.println("Opção invalida");
				break;
			}
			break;
		case 2:
			break;
			
		default:
			System.out.println("Opção inválida...");
			break;
		}
	}
	
	public void menu (Scanner sc) {
		
		int saida = 0;
		do {
			System.out.printf("Gerenciador de estacionamento\nSelecione uma opção:"
					+" 1 - Entrada/saida\n 2 - Veiculos\n 3 - Informações de pátio\n 4 - Pesquisa\n 5 - Sair\n :>");
			switch (saida) {
			case 1:
				System.out.println("Entrada/Saida");
				break;
			case 2:
				System.out.println("Veiculos");
				break;
			case 3:
				System.out.println("Pátio");
				break;
			case 5:
				System.out.println("Saindo...");
				return;
				
			default:
				System.out.println("Opção invalida, digite novamente: ");
				saida = sc.nextInt();
			}

			saida = sc.nextInt();
			if (saida <0 || saida > 5) {
				System.out.println("Saindo..");
				break;
			}
		}while (saida != 0);
	}

	public static String pesquisaListaVeiculos (List lista, String placa) {
		for (int i = 0; i < lista.size(); i++) {
			if (((Veiculo) lista.get(i)).getPlaca().equals(placa))
				return ((Veiculo) lista.get(i)).getPlaca();
		}
		return "Vazio";
	}
	
	public static Integer pesquisaListaVeiculosIndex (List lista, String placa) {
		for (int i = 0; i < lista.size(); i++) {
			if (((Veiculo) lista.get(i)).getPlaca().equals(placa))
				return i;
		}
		return -1;
	}
}