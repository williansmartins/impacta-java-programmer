//Resolu��o padr�o do Laborat�rio proposto
//Desenvolvido por Rodrigo Mastropietro

public class Cap4_Lab2 {

	public static void main(String[] args) {
		
		String mes = "Novembro";
		
		switch(mes) {
		case "Janeiro":
			System.out.println("O m�s escolhido tem 31 dias");
			break;
		case "Fevereiro":
			System.out.println("O m�s escolhido tem 28 ou 29 dias ");
			break;
		case "Mar�o":
			System.out.println("O m�s escolhido tem 31 dias");
			break;
		case "Abril":
			System.out.println("O m�s escolhido tem 30 dias");
			break;
		case "Maio":
			System.out.println("O m�s escolhido tem 31 dias");
			break;
		case "Junho":
			System.out.println("O m�s escolhido tem 30 dias");
			break;
		case "Julho":
			System.out.println("O m�s escolhido tem 31 dias");
			break;
		case "Agosto":
			System.out.println("O m�s escolhido tem 31 dias");
			break;
		case "Setembro":
			System.out.println("O m�s escolhido tem 30 dias");
			break;
		case "Outubro":
			System.out.println("O m�s escolhido tem 31 dias");
			break;
		case "Novembro":
			System.out.println("O m�s escolhido tem 30 dias");
			break;
		case "Dezembro":
			System.out.println("O m�s escolhido tem 31 dias");
			break;
		default:
			System.out.println("O m�s passado não existe!");
		}
	}

}
