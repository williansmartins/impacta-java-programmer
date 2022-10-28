
public class Programador extends Funcionario {
	// atributos privados
	private String linguagem;
	private String sistemaOperacional;
	
	// construtor
	public Programador(String nome, String email, String linguagem, String sistemaOperacional){
		// chamada ao construtor pai que recebe 2 argumentos
		super(nome, email);
		this.linguagem = linguagem;
		this.sistemaOperacional = sistemaOperacional;
	}
	
	// m�todos
	public String getLinguagem() {
		return linguagem;
	}
	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}
	public String getSistemaOperacional() {
		return sistemaOperacional;
	}
	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}
	
	public void imprimirDados(){
		// Os m�todos getNome e getEmail s�o HERDADOS da superclasse Funcion�rio
		System.out.println("Nome: " + super.getNome());
		System.out.println("Email: " + super.getEmail());
		System.out.println("Linguagem: " + linguagem);
		System.out.println("Sistema Operacional: " + sistemaOperacional);
	}
}
