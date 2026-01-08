
package sistemabiblioteca;
import java.util.ArrayList;

public class Usuarios extends Pessoa {
    
    private String email;
    private String senha;
    ArrayList<Livros> listaLivrosUsuario = new ArrayList<>();
    
    public Usuarios(String _nome,String _cpf, String email, String senha) {
        super(_nome , _cpf); 
        this.email = email;
        this.senha = senha;
    }
    
}
