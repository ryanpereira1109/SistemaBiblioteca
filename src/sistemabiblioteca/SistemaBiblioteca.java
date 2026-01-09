
package sistemabiblioteca;

import java.util.ArrayList;
import java.util.Scanner;



public class SistemaBiblioteca {
     static Biblioteca b = new Biblioteca();
     
      public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);  
        int escolha;
        
        
        
        do {
        mostrarMenuLogin();
        escolha = leia.nextInt();
        leia.nextLine();
        
        switch(escolha) {
            case 1:
                Usuarios u = loginUsuario(leia, b.listaUsuarios);
                
                int escolha2;
                do {
                menuUsuario();
                escolha2 = leia.nextInt();
                leia.nextLine();
                
                switch(escolha2) {
                    case 1:
                        
                        mostrarLivro(b.listaLivros);
                        emprestarLivro(leia , b.listaLivros , u , b.listaEmprestimos); 
                        
                        break;
                        
                        
                    case 2:
                        mostrarLivro(b.listaLivros);
                        break;
                                
                    case 3:
                        devolverEmprestimo(leia, b.listaEmprestimos , u );
                        
                        break;
                   case 4: 
                       System.out.println("Saindo...");   
                       break;
                       
                       
                   default:
                       System.out.println("Valor invalidado");   
                       break;
                }
                } while (escolha2 != 4);
                break;
                
                
            case 2:
                loginAtendente(leia);
                int escolha3;
                do {
                menuAtendente();
                escolha3 = leia.nextInt();
                leia.nextLine();
                switch(escolha3) {
                    case 1:
                        cadastrarLivro(leia , b.listaLivros);
                        break;
                        
                        
                    case 2:
                         mostrarLivro(b.listaLivros);
                        break;
                                
                               
                   case 3: 
                       mostrarUsuarios(b.listaUsuarios);
                       break;
                       
                   case 4:
                       mostrarEmprestimos(b.listaEmprestimos);
                       break;
                   case 5:  
                   System.out.println("Saindo...");   
                       break;
                       
                       
                   default:
                       System.out.println("Valor invalidado");   
                       break;
                }
                
                }while (escolha3 != 5);
            
                 break;
                 
                 
            case 3:
               System.out.println("Encerrando programa");   
               break;
                
        }
        
         } while(escolha != 3);
    }
    
    
     public static void mostrarMenuLogin() {
       System.out.println("1- Login Usuario");   
       System.out.println("2- Login Biblioteca");
       System.out.println("3- Sair");
        
    }
    
    public static Usuarios loginUsuario (Scanner leia, ArrayList<Usuarios> lista) {
        System.out.println("Digite seu nome: ");   
        String nome = leia.nextLine();
        System.out.println("Digite seu CPF: ");   
        String cpf = leia.nextLine(); 
        System.out.println("Digite seu email: ");   
        String email = leia.nextLine();
        System.out.println("Digite sua senha: ");   
        String senha = leia.nextLine();
        
        Usuarios usuario = new Usuarios( nome, cpf, email, senha);
        lista.add(usuario);
        return usuario;
        
    }
    
    
        public static void loginAtendente (Scanner leia) {
        System.out.println("Digite seu nome: ");   
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
        
        public static void cadastrarLivro (Scanner leia, ArrayList<Livros> lista) {
            System.out.println("Digite o titulo: ");   
            String titulo = leia.nextLine();
            System.out.println("Digite o numero de paginas: ");   
            int paginas = leia.nextInt(); 
            leia.nextLine();
            System.out.println("Digite o autor: ");   
            String autor = leia.nextLine();
        
            Livros livro = new  Livros( titulo, paginas, autor, true);
            lista.add(livro);
            
        }
        
         public static void mostrarLivro( ArrayList<Livros> lista) {
                
                System.out.println("--- Lista de Livros ---");
                for (Livros l : lista) {
                System.out.println("Nome: " + l.getTitulo() + " | Paginas: " + l.getPaginas() + " | Autor: " + l.getAutor() + " | Situação: " + (l.isDisponivel() ? "Sim" : "Não"));
           }
         }
         
          public static void emprestarLivro (Scanner leia , ArrayList<Livros> lista , Usuarios u , ArrayList<Emprestimo> lista2) {
              System.out.println("Digite o livro desejado: ");   
              String pesquisalivro = leia.nextLine();
              boolean encontrado = false;
              
              for (Livros livro : lista) {
              
               if (livro.getTitulo().equalsIgnoreCase(pesquisalivro)) {
                      System.out.println("Livro encontrado!");
                      System.out.println("Autor: " + livro.getAutor() + " | Disponível: " + (livro.isDisponivel() ? "Sim" : "Não"));
                      encontrado = true;
                      System.out.println("Deseja pedir o livro emprestado? S/N ");
                      String pedir = leia.nextLine();
                      if (u.podeEmprestar()) {
                      switch (pedir)
                      {
                          case "S": 
                              if(livro.isDisponivel()) {
                                  u.listaLivrosUsuario.add(livro);
                                  livro.setDisponivel(false);
                                  Emprestimo e = new Emprestimo(livro , u);
                                  b.listaEmprestimos.add(e);
                                  System.out.println("Empréstimo realizado com sucesso para: " + u.getNome());
                              } else {
                                System.out.println("Este livro já está com outro usuário.");
                                 } 

                              break;
                                      
                                      
                          case "N":
                          
                              System.out.println("Operação cancelada.");
                              
                             break;
                             
                          default:
                              System.out.println("Valor invalido");
                              break;
                      
               
              }
                      } else {
                          System.out.println("limite atingido");
                      }
                
           }
               
              }

           if (!encontrado) {
              System.out.println("Desculpe, o livro '" + pesquisalivro + "' não foi encontrado no sistema.");
           }
        
    
         }
          
          
         public static void mostrarUsuarios(ArrayList<Usuarios> lista) {
             for (Usuarios u : lista) {
                System.out.println("Nome: " + u.getNome() + " | CPF: " + u.getCpf() + " | Email: " + u.getEmail());
             
         }
             
         }
         
          public static void mostrarEmprestimos(ArrayList<Emprestimo> lista) {
              for (Emprestimo e : lista) {
                  
              System.out.println("Usuário: " + e.usuario.getNome() + 
                           " | CPF: " + e.usuario.getCpf() + 
                           " | Livro: " + e.livro.getTitulo());
             }
              
          }
          
           public static void devolverEmprestimo(Scanner leia , ArrayList<Emprestimo> lista , Usuarios u) {
               System.out.println("--- Seus Livros Emprestados ---");
               boolean temEmprestimo = false;
               for (Emprestimo e : lista) {
                 if (e.usuario.getCpf().equals(u.getCpf())) {
                   System.out.println("- " + e.livro.getTitulo());
                   temEmprestimo = true;
                    }
                 }           
 
                if (!temEmprestimo) {
                   System.out.println("Você não possui livros para devolver.");
                  return;
                 }
              
               System.out.println("Digite o livro para devolver: ");  
               String pesquisalivro = leia.nextLine();
               Emprestimo paraRemover = null;
               
               for (Emprestimo e : lista) {
              
              if (e.livro.getTitulo().equalsIgnoreCase(pesquisalivro) && e.usuario.getCpf().equals(u.getCpf())) {
                      System.out.println("Deseja realmente devolver o livro? S/N ");
                      String pedir = leia.nextLine();
                      switch(pedir) {
                          case "S":
                              e.livro.setDisponivel(true);
                              u.listaLivrosUsuario.remove(e.livro);
                              paraRemover = e;
                
                              System.out.println("Livro devolvido com sucesso!");
                              break;
                          case "N":
                               System.out.println("Processo cancelado!");
                               break;
                               
                          default:
                              System.out.println("Valor invalido!");
                              break;       
                             
                      }
                     
                      
               }
               
              }
               
                 if (paraRemover != null) {
                 lista.remove(paraRemover);
                 } else {
                 System.out.println("Livro não encontrado nos seus empréstimos.");
                  }
              
                }
    

}
