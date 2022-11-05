package br.com.impacta.apresentacao;

import java.util.Scanner;

import br.com.impacta.controladores.FilmeController;
import br.com.impacta.persistencia.Filme;

public class CriarFilme {
	
	public static void main(String[] args) {
		boolean continuar = true; 
		
		while(continuar) {
			criarFilme();
			System.out.println("Deseja continuar (S/N)?");
			Scanner scan = new Scanner(System.in);
			String confirmacao = scan.nextLine();
			
			if(confirmacao.equalsIgnoreCase("N")) {
				continuar = false;
			}			
		}
		
		System.out.println("Fim!");
	}
	
	static void criarFilme() {
		Scanner scan = new Scanner(System.in);
		Filme filme = new Filme();
		
		//titulo
		System.out.println("Digite o t�tulo do Filme:");
		String titulo = scan.nextLine();
		System.out.println("O t�tulo do filme escolhido �: " + titulo);
		filme.titulo = titulo;
		System.out.println("----");
		
		/*
		
		//diretores
		System.out.println("Digite o diretores do Filme:");
		String diretores = scan.nextLine();
		System.out.println("Os diretores do filme escolhido s�o: " + diretores);
		filme.diretores = diretores;
		System.out.println("----");
		
		//nota
		System.out.println("Digite a nota do Filme:");
		double nota = Double.parseDouble(scan.nextLine());
		System.out.println("A nota do filme escolhido �: " + nota);
		filme.nota = nota;
		System.out.println("----");		

		//duracao
		System.out.println("Digite a duracao do Filme:");
		int duracao = Integer.parseInt(scan.nextLine());
		System.out.println("duracao do filme escolhido �: " + duracao);
		filme.duracao = duracao;
		System.out.println("----");

		//ano
		System.out.println("Digite o ano do Filme:");
		int ano = Integer.parseInt(scan.nextLine());
		System.out.println("ano do filme escolhido �: " + ano);
		filme.ano = ano;
		System.out.println("----");

		//generos
		System.out.println("Digite os g�neros do Filme:");
		String generos = scan.nextLine();
		System.out.println("generos do filme escolhido �: " + generos);
		filme.generos = generos;
		System.out.println("----");

		//numVotos
		System.out.println("Digite a numVotos do Filme:");
		int numVotos = Integer.parseInt(scan.nextLine());
		System.out.println("numVotos do filme escolhido �: " + numVotos);
		filme.numVotos = numVotos;
		System.out.println("----");

		//url
		System.out.println("Digite a url do Filme:");
		String url = scan.nextLine();
		System.out.println("url do filme escolhido �: " + url);
		filme.url = url;
		System.out.println("----");
		
		*/
		
		//final
		System.out.println(filme);
		
		FilmeController controller = new FilmeController();
		controller.criar(filme);
	}
}
