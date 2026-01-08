
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
                loginUsuario(leia,b.listaUsuarios); 
                int escolha2;
                do {
                menuUsuario();
                escolha2 = leia.nextInt();
                } while (escolha2 != 3);
                break;
                
                
            case 2:
                loginAtendente(leia);
                int escolha3;
                do {
                menuAtendente();
                escolha3 = leia.nextInt();
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
    
    public static void loginUsuario (Scanner leia, ArrayList<Usuarios> lista) {
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
            System.out.println("3 - Sair ");   
            
        }
        
        public static void menuAtendente () {
         
            System.out.println("1 - Cadastro de livros "); 
            System.out.println("2 - Lista de livros ");   
            System.out.println("3 - Lista de usuarios ");   
            System.out.println("4 - Lista de emprestimos ");
            System.out.println("5 - Sair ");
            
        }
        
 
        
    
    
    

}
