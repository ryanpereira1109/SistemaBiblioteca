
package sistemabiblioteca;


public class Atendente extends Pessoa {
    
    private int codigoEntrada;

    public Atendente(int codigoEntrada, String nome, String cpf) {
        super(nome, cpf);
        this.codigoEntrada = codigoEntrada;
    }
    
    
    
}
