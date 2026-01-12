
package sistemabiblioteca;

import java.util.ArrayList;
import java.util.Scanner;



public class SistemaBiblioteca {
     static Biblioteca b = new Biblioteca(); // variavel global biblioteca sendo instanciada
     
      public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);   // scanner
        int escolha; // variavel de escolha menu
        
        
        
        do { // iniciando do while
        mostrarMenuLogin(); // mostrando menu do login
        escolha = leia.nextInt(); // guardando a escolha do usuario na variavel escolha
        leia.nextLine(); // limpando scanner
        
        switch(escolha) { // iniciando todas as escolhas possivel
            case 1:
                Usuarios u = loginUsuario(leia); // instanciando e criando login usuario e retornando
                
                int escolha2; // criando a segunda variavel de escolha do usuario
                do {
                menuUsuario(); // mostrando todas as opções de usuario no sistema
                escolha2 = leia.nextInt(); // colocando a escolha do usuario
                leia.nextLine();
                
                switch(escolha2)  { // iniciando escolha
                    case 1: // caso ele escolha 1 vai mostrar todos os livros cadastrados no sistema e se ele quer pegar emprestado
                        
                        mostrarLivro(); // mostrando livros
                        emprestarLivro(leia , u); // mostrando menu e entregando o usuario cadastrando para a função
                        
                        break;
                        
                        
                    case 2: // caso ele escolha 2, vai mostrar os livros cadastrados
                        mostrarLivro(); // mostrando o livro
                        break; // caso 2 acaba aqui retornando a escolha
                                
                    case 3:
                        devolverEmprestimo(leia, u ); // metodo devolver emprestimo recebendo leia e o usuario
                        
                        break; // parando case
                   case 4: 
                       System.out.println("Saindo...");   // parando sistema
                       break;
                       
                       
                   default: // caso default, ele digitou algo aleatorio
                       System.out.println("Valor invalidado");   
                       break;
                }
                } while (escolha2 != 4); // fim do do while caso ele digite 4
                break; // fim da escolha usuario
                
                
            case 2: //caso escolha biblioteca
                loginAtendente(leia); // fazendo login atendente
                int escolha3; // escolha do menu do atendente
                do { // iniciando do while atendente
                menuAtendente(); // mostrando menu
                escolha3 = leia.nextInt(); // lendo a escolha do usuario
                leia.nextLine();
                switch(escolha3) { // abrindo escolha atendente
                    case 1:
                        cadastrarLivro(leia); // cadastrando livro no metodo cadastrarLivro
                        break;
                        
                        
                    case 2:
                         mostrarLivro(); // mostrando lista de livros
                        break;
                                
                               
                   case 3: 
                       mostrarUsuarios(); // mostrando lista de usuarios
                       break;
                       
                   case 4:
                       mostrarEmprestimos(); // mostre lista de emprestimos
                       break;
                   case 5:  
                   System.out.println("Saindo...");   // ssaindo do ssistema
                       break;
                       
                       
                   default:
                       System.out.println("Valor invalidado");   // digitou valor aleatorio
                       break;
                }
                
                }while (escolha3 != 5); // saindo do loop
            
                 break;
                 
                 
            case 3:
               System.out.println("Encerrando programa");   // encerrando programa
               break;
                
        }
        
         } while(escolha != 3);
    }
    
    
     public static void mostrarMenuLogin() {
       System.out.println("1- Login Usuario");   
       System.out.println("2- Login Biblioteca");
       System.out.println("3- Sair");
       // mostrando escolhas que o usuario vai fazer
        
    }
    
    public static Usuarios loginUsuario (Scanner leia) {
        System.out.println("Digite seu nome: ");   
        String nome = leia.nextLine();
        System.out.println("Digite seu CPF: ");   
        String cpf = leia.nextLine(); 
        System.out.println("Digite seu email: ");   
        String email = leia.nextLine();
        System.out.println("Digite sua senha: ");   
        String senha = leia.nextLine();
        // mostrando e recebendo dados do usuario
        
        return b.cadastrarUsuario(nome, cpf, email, senha); // cadastrando usuario no metodo de cadastrar na biblioteca
        
    }
    
    
        public static void loginAtendente (Scanner leia) {
        System.out.println("Digite seu nome: ");  // leitura de dados do atendente (login ainda não implementado)
        String nome = leia.nextLine();
        System.out.println("Digite seu CPF: ");   
        String cpf = leia.nextLine(); 
        System.out.println("Digite o codigo de entrada: ");   
        String codigo = leia.nextLine();
        }
        public static void menuUsuario () {
         
            System.out.println("1 - Emprestimos de livros "); 
            System.out.println("2 - Lista de livros ");   
            System.out.println("3- Devolver livro");
            System.out.println("4 - Sair ");   
            
        }
        
        public static void menuAtendente () {
         
            System.out.println("1 - Cadastro de livros "); 
            System.out.println("2 - Lista de livros ");   
            System.out.println("3 - Lista de usuarios ");   
            System.out.println("4 - Lista de emprestimos ");
            System.out.println("5 - Sair ");
            
        }
        
        public static void cadastrarLivro (Scanner leia) {
            System.out.println("Digite o titulo: ");   
            String titulo = leia.nextLine();
            System.out.println("Digite o numero de paginas: ");   
            int paginas = leia.nextInt(); 
            leia.nextLine();
            System.out.println("Digite o autor: ");   
            String autor = leia.nextLine();
            // perguntando dados do livro e guardando em suas respectivas variaveiss
        
            b.cadastrarLivro(titulo, paginas, autor); // pegando o metodo da biblioteca livro e cadastrando
            
        }
        
         public static void mostrarLivro() {
                
                System.out.println("--- Lista de Livros ---"); // mostrando que é uma lista de livros
                for (Livros l :  b.listarLivros()) { // mostrando cada livro da lista (para cada livro da lista de livros mostre os detalhes deles
                System.out.println("Nome: " + l.getTitulo() + " | Paginas: " + l.getPaginas() + " | Autor: " + l.getAutor() + " | Situação: " + (l.isDisponivel() ? "Sim" : "Não"));
                // mostrando detalhes
           }
         }
         
        public static void emprestarLivro (Scanner leia, Usuarios u) {
              System.out.println("Digite o livro desejado: ");   // perguntando ao usuario qual livro desejado
              String pesquisalivro = leia.nextLine(); // recebendo
              boolean sucesso = b.emprestarLivro(u, pesquisalivro); // criando uma variavel boleana que vai retornar se é verdadeiro ou falso do metodo criado de biblioteca
              
              if (sucesso) { // se o metodo retornar verdadeiro mostre que foi um sucesso
                System.out.println("Empréstimo realizado com sucesso!");
                } else { // se falso, mostre que nao foi possivel.
                 System.out.println("Não foi possível realizar o empréstimo.");
                }
              
    
          }
          
          
         public static void mostrarUsuarios() {
             for (Usuarios u : b.listarUsuarios()) { // para cada usuario de lista usuarioss
                System.out.println("Nome: " + u.getNome() + " | CPF: " + u.getCpf() + " | Email: " + u.getEmail()); // mostre essas informações
             
         }
             
         }
         
          public static void mostrarEmprestimos() {
              for (Emprestimo e : b.listarEmprestimos()) {
                  
              System.out.println("Usuário: " + e.getUsuario().getNome() + 
                           " | CPF: " + e.getUsuario().getCpf() + 
                           " | Livro: " + e.getLivro().getTitulo());
             }
              
          }
          
           public static void devolverEmprestimo(Scanner leia , Usuarios u) { 
                    System.out.println("--- Seus Livros Emprestados ---"); // mostrando menu 

                        if (u.getListaLivrosUsuario().isEmpty()) { // Se a lista de livros que o usuário u pegou emprestado estiver vazia...
                          System.out.println("Você não possui livros para devolver."); //Esta linha só será executada se a condição lá de cima for verdadeira.
                         return; // Encerra a execução do método atual imediatamente.
                            }

                        for (Livros l : u.getListaLivrosUsuario()) { // para cada livro da lista de emprestimo do usuario
                          System.out.println("- " + l.getTitulo()); // mostre o titulo
                          }

                          System.out.println("Digite o livro para devolver: "); // 
                          String titulo = leia.nextLine(); // pegando o titulo q ele digitou

                          boolean sucesso = b.devolverLivro(u, titulo); // verificando sucesso do metodo de biblioteca

                        if (sucesso) { // se o metodo foi um sucesso
                          System.out.println("Livro devolvido com sucesso!"); // livro devolvido
                           } else {
                           System.out.println("Livro não encontrado nos seus empréstimos.");
                        }
    
           }
}
