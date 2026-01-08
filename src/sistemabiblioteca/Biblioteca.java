
package sistemabiblioteca;

import java.util.ArrayList;
import java.util.Scanner;


public class Biblioteca {
   
    ArrayList<Livros> listaLivros = new ArrayList<>();
    ArrayList<Usuarios> listaUsuarios= new ArrayList<>();
    ArrayList<Emprestimo> listaEmprestimos = new ArrayList<>();
    
    public void emprestarLivro(Usuarios u , Livros l ) {
        System.out.println("--- Lista de Livros ---");
                for (Livros livro : listaLivros) {
                System.out.println("Nome: " + l.getTitulo() + " | Paginas: " + l.getPaginas() + " | Autor: " + l.getAutor() + " | Situação: " + l.isDisponivel());
    }

        
         
    }
}
