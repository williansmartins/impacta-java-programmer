
public class CadastroNotas {
	public static void main(String args[]){
		try{
			Nota nota = new Nota("Maria", 11);
		}catch(NotaInvalidaException e){
			System.err.println("Nota inv�lida = " + e.getMessage());
			e.printStackTrace();
		}
	}
}
