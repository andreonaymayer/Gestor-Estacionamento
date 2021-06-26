package Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
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
		Date a = tipoData.parse("26/06/2021 00:00:00");
		Date b = tipoData.parse("31/06/2021 15:00:00");
		
		
		
		
		//x = tipoData.parse()
		
		
		Patio patio; patio = new Patio(10,(double) 5.00,(double) 100.00); //instancia 		
				
		List <Registro> TbReg = new ArrayList<>(); //inicia a lista de registros
		List <Carro> TbCarro= new ArrayList<>(); //inicia a lista de Carros
		List <Moto> TbMoto= new ArrayList<>(); //inicia a lista de Motos
		
		//TbCarro.add(new Carro("Andreo","Legal", "ijaij","iii923"));


		
		//System.out.println(TbCarro);
		TbCarro.add(new Carro("Voyage", "VW", "Preta", "PLACAC"));
		TbCarro.add(new Carro("Voyage", "VW", "Preta", "CARRO"));
		TbMoto.add(new Moto("Cb150", "Honda", "Preta", "PLACAM"));
		TbMoto.add(new Moto("R1000", "Yamaha", "Preta", "MOTO"));
		TbReg.add(new Registro(a, null, TbCarro.get(pesquisaListaVeiculosIndex(TbCarro, "CARRO")), patio, true));
		TbReg.add(new Registro(a, null, TbMoto.get(pesquisaListaVeiculosIndex(TbMoto, "MOTO")), patio, true));
		System.out.println(TbCarro.get(0));
		
		String placa;
		System.out.println("------ Gestor ------");
		System.out.print(" 1 - Entrada de veiculo\n 2 - Saída Veiculo\n 3 - Sair\n :>");
		int escolha = sc.nextInt();
		switch (escolha) {
		case 1:
			System.out.println("  .:: Entrada de veiculos ::.");
			System.out.print("Insira a placa:\n>> ");
			placa = sc.nextLine();placa = sc.nextLine();
			int teste = pesquisaListaRegistroIndex(TbReg, placa);
			if (teste !=-1 && TbReg.get(teste).getOcupando() != false) {
				System.out.println("Já foi registrada a entrada desse veículo no estacionamento. Ele está ocupando uma vaga. Dados:\n" + TbReg.get(teste)+"\n");
				break;
			}
			
			if (pesquisaListaVeiculosIndex(TbMoto, placa)!=-1) {
				int index = pesquisaListaVeiculosIndex(TbMoto, placa);
				
				TbReg.add(new Registro(new Date(), null, TbMoto.get(index), patio, true));
				TbMoto.get(index).setOcupandoVei(true);
				System.out.println(TbReg.get(index));
			}else if (pesquisaListaVeiculosIndex(TbCarro, placa)!=-1) {
				int index = pesquisaListaVeiculosIndex(TbCarro, placa);
				
				TbReg.add(new Registro(new Date(), null, TbCarro.get(index), patio, true));
				TbCarro.get(index).setOcupandoVei(true);
				System.out.println(TbReg.get(index));
			}else {
				System.out.printf("!! Placa não encontrada, vamos cadastrar o veiculo - %s -. !! \n",placa);
			System.out.print("  O veiculo é:\n  1 - Carro;\n  2 - Moto;\n  3 - Cancelar;\n   :>");
			teste = sc.nextInt();
			if (teste!=1 && teste!=2) {
				System.out.println("Saindo...");
				break;
			}
			System.out.print("> Insira a marca do carro:"); String marca = sc.nextLine();marca = sc.nextLine();
			System.out.print("> Insira a cor do carro:"); String cor = sc.nextLine();
			System.out.print("> Insira o nome do carro:"); String nome = sc.nextLine();
			
			
			switch (teste) {
			case 1://carro
				TbCarro.add(new Carro(nome, marca, cor, placa));
				System.out.println("Veiculo: ("+ pesquisaListaVeiculos(TbCarro,placa) +") Cadastrado!");
				int index = pesquisaListaVeiculosIndex(TbCarro, placa);
				TbReg.add(new Registro(new Date(), null, TbCarro.get(index), patio, true));
				break;
			case 2://moto
				TbMoto.add(new Moto(nome, marca, cor, placa));
				System.out.println("Veiculo: ("+ pesquisaListaVeiculos(TbMoto,placa) +") Cadastrada!");
				index = pesquisaListaVeiculosIndex(TbMoto, placa);
				TbReg.add(new Registro(new Date(), null, TbMoto.get(index), patio, true));
				break;
			}
			}
			
			break;
		case 2:
			System.out.print("Digite a placa do veículo que vai deixar o estacionamento.\n:> ");
			placa = sc.nextLine();placa = sc.nextLine();
			int tipoVei = placaExiste(placa, TbCarro, TbMoto);
			if (tipoVei==-1) {
				System.out.println("Placa não cadastrada.");
				break;
			}
			if (pesquisaListaRegistroIndex(TbReg, placa)!=-1 && TbReg.get(pesquisaListaRegistroIndex(TbReg, placa)).getOcupando()) {
				int indexAlterando=pesquisaListaRegistroIndex(TbReg, placa);
					TbReg.get(indexAlterando).saidaDeVeiculo();
					break;
			}
					
				System.out.printf("O veiculo %s não está no estacionamento no momento.\n",placa);
			
			
			break;
		case 3:
			System.out.println("Saindo...");
			break;
		default:
			break;
		}
		System.out.println("-------loop--------");
		for (int i = 0; i < TbReg.size(); i++) {
			System.out.println(TbReg.get(i));
		}
		System.out.println(TbMoto.get(0));
	}
	
	public void veiculosMenu (List TbCarro,List TbMoto, Scanner sc) {
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
						((Carro) TbCarro.get(indexInt)).setNome(editado);
						break;
					case 2:
						((Carro) TbCarro.get(indexInt)).setMarca(editado);
						break;
					case 3:
						((Carro) TbCarro.get(indexInt)).setCor(editado);
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
						((Carro) TbMoto.get(indexInt)).setNome(editado);
						break;
					case 2:
						((Carro) TbMoto.get(indexInt)).setMarca(editado);
						break;
					case 3:
						((Carro) TbMoto.get(indexInt)).setCor(editado);
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
	
	public static Integer pesquisaListaRegistroIndex (List lista, String placa) {
		for (int i = 0; i < lista.size(); i++) {
			if (((Registro) lista.get(i)).getVeiculo().getPlaca().equals(placa))
				return i;
		}
		return -1;
	}
	
	public static Integer pesquisaListaVeiculosIndex (List lista, String placa) {
		for (int i = 0; i < lista.size(); i++) {
			if (((Veiculo) lista.get(i)).getPlaca().equals(placa))
				return i;
		}
		return -1;
	}

	public static Date dataAtual () throws ParseException {

		SimpleDateFormat tipoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //define o tipo de data
		LocalDateTime c;
		c = LocalDateTime.now();
		int dia = c.getDayOfMonth();
		int mes = c.getMonthValue();
		int ano = c.getYear();
		int hora = c.getHour();
		int minuto = c.getMinute();
		int segundo = c.getSecond();
		String stringData = String.format("%d/%d/%d %d:%d:%d", dia,mes,ano,hora,minuto,segundo);
		Date x = tipoData.parse(stringData);
		return x;
		
	}
	
	public static Integer placaExiste (String placa,List Carro, List Moto) {
		if (pesquisaListaVeiculosIndex(Carro, placa)!=-1) {
			return 1;
		}
		if (pesquisaListaVeiculosIndex(Moto, placa)!=-1) {
			return 2;
		}
		return -1;
	}
	
}
