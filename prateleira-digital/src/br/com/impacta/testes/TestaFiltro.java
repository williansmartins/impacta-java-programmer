package br.com.impacta.testes;

import java.util.ArrayList;
import java.util.List;


import br.com.impacta.controladores.FilmeController;
import br.com.impacta.persistencia.Filme;
import br.com.impacta.persistencia.FilmeDAO;

public class TestaFiltro {
	static FilmeController controller = new FilmeController();
	static List<Filme> galeria = controller.listar();

	public static void main(String[] args) {
		System.out.println(galeria.size());
		List<Filme> resultado = printar(galeria); 
		System.out.println(resultado.size());
	}

	static List<Filme> printar(List<Filme> galeria) {
		List<Filme> listaNova = new ArrayList<Filme>();
		
		for (Filme f : galeria) {
			if(f.getGeneros() != null && f.getGeneros().equals("willians")) {
			listaNova.add(f);
			}
		}
		return listaNova;
	}
}
