
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Livros> getListaLivrosUsuario() {
        return listaLivrosUsuario;
    }

    public void setListaLivrosUsuario(ArrayList<Livros> listaLivrosUsuario) {
        this.listaLivrosUsuario = listaLivrosUsuario;
    }
    
    public boolean podeEmprestar() {
    return listaLivrosUsuario.size() < 3;
}
    
}
