package controller;

import dao.UsuarioDAO;
import model.Calendario;
import model.Evento;
import model.Mes;
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

    public void iniciarPrograma() {


        boolean trigger = true;

        while (trigger) {
            menu.imprimeTelaInicial();
            int opcaoMenuInicial = scanner.nextInt();

            switch (opcaoMenuInicial) {
                case 1:
                    System.out.println();
                    System.out.print("Login: ");
                    String login = scanner.next();
                    System.out.print("Senha: ");
                    String senha = scanner.next();

                    usuario = usuarioDAO.loadUser(login, senha);

                    boolean flag = true;
                    while (flag) {
                        scanner = new Scanner(System.in);
                        menu.imprimeInterfaceUsuario(usuario);
                        Integer opcaoMenuInterfaceCalendario = scanner.nextInt();
                        switch (opcaoMenuInterfaceCalendario) {
                            case 1:
                                System.out.print("Digite um ano entre 2017 e 2027: ");
                                int ano = scanner.nextInt();
                                menu.imprimeCalendario(ano);
                                System.out.println("Digite o nome do mes o qual deseja acessar: ");
                                String mes = scanner.next();
                                menu.imprimeMesDesejado(ano, mes, usuario);
                                Mes[] meses = Calendario.getInstance().getAno(ano).getMeses();

                                int numeroMes  = selecionaMes(mes);

                                System.out.println();

                                boolean visualizacaoCalendario = true;

                                while(visualizacaoCalendario){
                                    menu.imprimeOpcoesVisualizarEventos();
                                    Integer opcaoVisualizacao = 0;
                                    opcaoVisualizacao = scanner.nextInt();
                                    switch(opcaoVisualizacao){
                                        case 1:
                                            menu.imprimeEscolhaSemana(mes,ano);
                                            opcaoVisualizacao = scanner.nextInt();

                                            switch (opcaoVisualizacao){
                                                case 1:
                                                    menu.imprimePrimeiraSemana(meses[numeroMes]);
                                                    break;
                                                case 2:
                                                    menu.imprimeSegundaSemana(meses[numeroMes]);
                                                    break;
                                                case 3:
                                                    menu.imprimeTerceiraSemana(meses[numeroMes]);
                                                    break;
                                                case 4:
                                                    menu.imprimeQuartaSemana(meses[numeroMes]);
                                                    break;
                                            }
                                            break;
                                        case 2:
                                            menu.imprimeRequisicaoData();
                                            int dataEvento = scanner.nextInt();
                                            menu.imprimeDia(meses[numeroMes],dataEvento);
                                            break;
                                        case 3:
                                            visualizacaoCalendario = false;
                                            break;

                                        default:
                                            visualizacaoCalendario = false;
                                    }
                                }

                                break;
                            case 2:
                                menu.imprimeEventos(usuario);
                                break;
                            case 3:
                                System.out.print("Digite a data do Evento (Formato dia/mes/ano): ");
                                String data = scanner.next();
                                System.out.print("Digite a descrição do evento: ");
                                String descriscao = scanner.next();
                                Evento userEvent = new Evento(descriscao,data);
                                usuario.cadastraEvento(userEvent);
                                userEvent.cadastraEvento();
                                try {
                                    usuarioDAO.saveUser();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                break;

                            case 4:
                                menu.imprimeInterfaceConfiguracoes();

                            case 5:
                                flag = false;
                                trigger = false;
                                break;

                        }
                    }
                    break;
                case 2:
                    System.out.print("Digite seu Nome: ");
                    String nomeUsuario = scanner.next();
                    System.out.print("Digite seu email: ");
                    String emailUsuario = scanner.next();
                    System.out.print("Digite uma senha: ");
                    String senhaUsuario = scanner.next();
                    usuario = new Usuario(nomeUsuario, emailUsuario, senhaUsuario);
                    usuarioDAO.setUsuario(usuario);
                    try {
                        usuarioDAO.registerUser();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    trigger = false;
                    break;

                 default:
                     opcaoMenuInicial = 0;
                     trigger = false;
            }

        }
    }

    private int selecionaMes(String mes) {
        switch(mes){
            case "Janeiro":
                return 0;

            case "Fevereiro":
                return 1;

            case "Marco":
                return 2;

            case "Abril":
                return 3;

            case "Maio":
                return 4;

            case "Junho":
                return 5;

            case "Julho":
                return 6;

            case "Agosto":
                return 7;

            case "Setembro":
                return 8;

            case "Outubro":
                return 9;

            case "Novembro":
                return 10;

            case "Dezembro":
                return 11;
        }
        return -1;
    }


}
