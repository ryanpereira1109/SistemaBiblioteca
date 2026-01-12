
package sistemabiblioteca;


public class Emprestimo {
    
    private Livros livro;
    private Usuarios usuario;
    

    public Emprestimo(Livros livro, Usuarios usuario) {
        this.livro = livro;
        this.usuario = usuario;
    }

    public Livros getLivro() {
        return livro;
    }

    public void setLivro(Livros livro) {
        this.livro = livro;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
