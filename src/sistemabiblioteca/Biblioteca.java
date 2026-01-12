
package sistemabiblioteca;

import java.util.ArrayList;
import java.util.Scanner;


public class Biblioteca {
   
    ArrayList<Livros> listaLivros = new ArrayList<>();
    ArrayList<Usuarios> listaUsuarios= new ArrayList<>(); // criando lista usuario
    ArrayList<Emprestimo> listaEmprestimos = new ArrayList<>();
    
    public Livros cadastrarLivro(String titulo , int paginas , String autor) { // pegando os dados
        
            Livros livro = new Livros(titulo, paginas, autor, true); // instanciando
            listaLivros.add(livro); // adicionando a lista de livros
            System.out.println("Livro cadastrado com sucesso."); // avisando que foi cadastrando
            return livro; // retornando livro
    }
    
    public Usuarios cadastrarUsuario(String nome,String cpf, String email, String senha) { // criando o metodo para cadastrar o usuario apenas pela regra de negocio
        
            Usuarios usuario = new Usuarios(nome, cpf, email, senha); // instaciando o usuario com as variaveis pedidas
            listaUsuarios.add(usuario); // guardando na lista usuario criada em biblioteca
            System.out.println("Usuario cadastrado com sucesso."); // mensagem que retorna ao cadastrar
            return usuario; // retornando usuario
    }
    
    public ArrayList<Livros> listarLivros() {
    return listaLivros;
    }
    
    public boolean emprestarLivro(Usuarios usuario, String tituloLivro) { // recebendo usuario e nome do livro
         if (!usuario.podeEmprestar()) { // verificando se usuario tiver 3 livros ja emprestados
           return false; // todo o metodo vai retornar falso
         } // metodo ja acaba aqui
        
        for (Livros livro : listaLivros)  { // para cada livro da lista de livros

         if (livro.getTitulo().equalsIgnoreCase(tituloLivro)) { // verifique se é igual ao nome digitado pelo usuario

            
            if (!livro.isDisponivel()) { // se o livro for encontrado, verifique se esta disponivel 
                return false; // se nao estiver disponivel, retorne falso
            }

            
            livro.setDisponivel(false); // sendo o livro estiver disponivel, mude para false
            usuario.getListaLivrosUsuario().add(livro); // adicione o livro para lista de livros do usuario
            listaEmprestimos.add(new Emprestimo(livro, usuario)); // e crie o emprestimo, ja adicionando na lista de emprestimos do sistema

            return true; // retorne verdadeiro se o livro foi emprestado e ja caba aqui o metodo
        }
    }
        
         return false; //  retorne falso se o livro nao foi emprestado
    }
           
    public ArrayList<Usuarios> listarUsuarios() {
    return listaUsuarios;
    }
    
    public ArrayList<Emprestimo> listarEmprestimos() {
    return listaEmprestimos;
    }
    
    
    public boolean devolverLivro(Usuarios usuario, String tituloLivro) { // pegando usuario e o nome do livro

       Emprestimo paraRemover = null; // criando uma variavel emprestimo para pegar esse emprestimo e remover da lista de emprestimo

       for (Emprestimo e : listaEmprestimos) { // para cada emprestimo da lista de emprestimo
         if (
             e.getUsuario().getCpf().equals(usuario.getCpf()) &&
             e.getLivro().getTitulo().equalsIgnoreCase(tituloLivro) // verifique se o cpf do usuario da lista de emprestimo é igual ao cpf do usuario
                 // e verifique se o titulo do livro da lista de emprestimos é igual ao titulo digitado.
         ) { // se a condição for verdadeira

           
            e.getLivro().setDisponivel(true); // livro volta a estar disponivel para emprestimo
            usuario.getListaLivrosUsuario().remove(e.getLivro()); // remove livro da lista de emprestimo do usuario
            paraRemover = e; // e adicione o emprestimo na variavel para emprestar
            break; // interrompe o loop após encontrar o empréstimo
          }
       }

         if (paraRemover != null) { // se para remover nao for null
           listaEmprestimos.remove(paraRemover); // remova emprestimo da lista de empresimo
            return true; // retorne verdadeiro
        }

         return false; // se nao, retorne falso
        }
    
    

                
     
    
}
