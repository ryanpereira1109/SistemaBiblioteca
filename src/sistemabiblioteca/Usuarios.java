
package sistemabiblioteca;
import java.util.ArrayList;

public class Usuarios extends Pessoa {
    
    private String email;
    private String senha;
    ArrayList<Livros> listaLivrosUsuario = new ArrayList<>(); // criando a lista de livros emprestados do usuario no momento
    
    public Usuarios(String _nome,String _cpf, String email, String senha) {
        super(_nome , _cpf); 
        this.email = email;
        this.senha = senha;
    } // construtor com o super de pessoa

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
    } // retornando a lista de livros

    public void setListaLivrosUsuario(ArrayList<Livros> listaLivrosUsuario) {
        this.listaLivrosUsuario = listaLivrosUsuario;
    }
    
    public boolean podeEmprestar() {
    return listaLivrosUsuario.size() < 3;
} // se a lista de emprestimos estiver menos que tres, retorne verdadeiro
    
}
