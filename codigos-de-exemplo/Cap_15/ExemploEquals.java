import java.util.HashMap;

public class ExemploEquals {
    public static void main(String[] args) {
	Pessoa a = new Pessoa("Rodrigo",23);
	Pessoa b = new Pessoa("Claudio",20);

        System.out.println(a.nome + " � igual a " + b.nome + "? " + (a.equals(b)));

	a.nome = b.nome; //Nomes iguais, mas objetos diferentes
		
	System.out.println(a.nome + " � igual a " + b.nome + "? " + (a.equals(b)));
		
	a = b; //Objetos iguais
		
	System.out.println(a.nome + " � igual a " + b.nome + "? " + (a.equals(b)));
    }
}
