
package sistemabiblioteca;


public class Livros {
    
    private String titulo;
    private int paginas;
    private String autor;
    private boolean disponivel;

    public Livros(String titulo, int paginas, String autor, boolean disponivel) {
        this.titulo = titulo;
        this.paginas = paginas;
        this.autor = autor;
        this.disponivel = disponivel;
        System.out.println("Livro cadastrado com sucesso.");
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponivel() {
        
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    
    
   
}
