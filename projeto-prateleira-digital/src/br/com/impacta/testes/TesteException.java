package br.com.impacta.testes;

public class TesteException {
	
	public static void main(String[] args) {

		try {			
			//System.out.println(4/0); ///codigo perigoso
			//int a = Integer.parseInt("perigo"); //codigo perigoso
		}catch(Exception e) {
			System.out.println("N�o est� tudo bem...");
		}finally {
			System.out.println("acabou");			
		}	
		
		
	}
}