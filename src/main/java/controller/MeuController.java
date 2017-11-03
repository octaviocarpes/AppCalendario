package controller;

import dao.UsuarioDAO;
import model.Usuario;
import view.ImpressorDeCalendario;
import view.ImpressorDeMes;
import view.Menu;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Classe que controla o Projeto
 */
public class MeuController {

    private UsuarioDAO usuarioDAO;
    private Usuario usuario;
    private Scanner scanner;
    private Menu menu;

    public MeuController(UsuarioDAO userDao) {
        scanner = new Scanner(System.in);
        usuarioDAO = userDao;
        menu = new Menu();
    }

    public void iniciarPrograma(){
        menu.imprimeTelaInicial();

        int opcao = scanner.nextInt();

        switch (opcao){
            case 1:
                System.out.println();
                System.out.print("Login: ");
                String login = scanner.next();
                System.out.print("Senha: ");
                String senha = scanner.next();

                usuario = usuarioDAO.loadUser(login,senha);

                boolean flag = true;
                while (flag){
                    menu.imprimeInterfaceUsuario(usuario);
                    Integer option = scanner.nextInt();
                    switch (option){
                        case 1:
                            System.out.print("Digite um ano entre 2017 e 2027: ");
                            int ano = scanner.nextInt();
                            menu.imprimeCalendario(ano);
                            System.out.println("Digite o nome do mes o qual deseja acessar: ");
                            String mes = scanner.next();
                            menu.imprimeMesDesejado(ano,mes);
                            System.out.println();
                            break;
                        case 2:

                    }

                }
        }
    }


}
